package com.z.sharding.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Slf4j
@Service
@RequiredArgsConstructor
public class CacheDeleteConsumer {

    private final RedissonClient redissonClient;
    private final ExecutorService cacheDeleteExecutor;

    @KafkaListener(
            topics = "order-cache-delete",
            concurrency = "12",
            containerFactory = "manualAckKafkaListenerContainerFactory"
    )
    public void onMessage(String message, Acknowledgment ack) {

        cacheDeleteExecutor.submit(() -> {
            try {
                process(message);
                ack.acknowledge(); // 业务成功后再 commit offset
            } catch (Exception e) {
                log.error("异步处理失败，等待 Kafka 重投 message={}", message, e);
                // 不提交 offset，Kafka 自动重试
            }
        });
    }

    // 真正逻辑（线程池执行）
    private void process(String message) {
        String[] arr = message.split("\\|");
        String key = arr[0];
        long newVersion = Long.parseLong(arr[1]);

        if (newVersion != 0) {
            RBucket<Long> versionBucket = redissonClient.getBucket(key + ":version");
            Long current = versionBucket.get();

            if (current == null || newVersion >= current) {
                versionBucket.set(newVersion);
            }
        }

        redissonClient.getBucket(key).delete();

        log.info("缓存删除成功 key={}, version={}", key, newVersion);
    }
}