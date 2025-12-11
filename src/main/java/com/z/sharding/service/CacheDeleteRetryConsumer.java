//package com.z.sharding.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.redisson.api.RBucket;
//import org.redisson.api.RedissonClient;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class CacheDeleteRetryConsumer {
//
//    private final RedissonClient redissonClient;
//
//    @KafkaListener(
//            topics = "order-cache-delete-retry",
//            concurrency = "3",
//            containerFactory = "manualAckKafkaListenerContainerFactory"
//    )
//    public void onRetryMessage(String message, Acknowledgment ack) throws InterruptedException {
//
//        try {
//            // 🔥 二级重试前延时几秒（比如 5 秒）
//            Thread.sleep(5000);
//
//            // 和正常流程一样处理
//            process(message);
//            log.info("Retry 消费: {}", message);
//
//            ack.acknowledge();
//        } catch (Exception e) {
//            log.error("retry 消费失败，进入 DLQ, msg={}", message, e);
//            throw e; // ❗仍然抛出，让 DefaultErrorHandler 把它发到 DLQ
//        }
//    }
//
//    private void process(String message) {
//        String[] arr = message.split("\\|");
//        String key = arr[0];
//        long newVersion = Long.parseLong(arr[1]);
//
//        if (newVersion != 0) {
//            RBucket<Long> versionBucket = redissonClient.getBucket(key + ":version");
//            Long current = versionBucket.get();
//
//            if (current == null || newVersion >= current) {
//                versionBucket.set(newVersion);
//            }
//        }
//
//        redissonClient.getBucket(key).delete();
//
//        log.info("缓存删除成功 key={}, version={}", key, newVersion);
//    }
//}
