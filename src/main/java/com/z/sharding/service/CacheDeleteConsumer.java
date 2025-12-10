package com.z.sharding.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CacheDeleteConsumer {

    private final RedissonClient redissonClient;

    @KafkaListener(
            topics = "order-cache-delete",
            concurrency = "12",
            containerFactory = "manualAckKafkaListenerContainerFactory"
    )
    public void onMessage(String message, Acknowledgment ack) {
        try {
            String[] arr = message.split("\\|");
            String key = arr[0];
            long newVersion = Long.parseLong(arr[1]);

            if (newVersion != 0){
                RBucket<Long> versionBucket = redissonClient.getBucket(key + ":version");

                // 🔥 版本更新成功返回 1，才允许提交 offset
                versionBucket.set(newVersion);
            }

            // 删除缓存
            boolean deleted = redissonClient.getBucket(key).delete();

            if (!deleted) {
                throw new RuntimeException("Redis 删除失败，key=" + key);
            }

            log.info("删除缓存成功 key={}, version={}", key, newVersion);

            // 🔥🔥🔥 手动提交 offset（关键）
            ack.acknowledge();

        } catch (Exception e) {
            log.error("删除缓存失败 message={}", message, e);

            // ❌ 不提交 offset → Kafka 自动重试 → 重试失败进入 DLT
            // ack 不能调用
        }
    }

}
