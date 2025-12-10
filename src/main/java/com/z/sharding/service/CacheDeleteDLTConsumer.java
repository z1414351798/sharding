package com.z.sharding.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CacheDeleteDLTConsumer {

    @KafkaListener(topics = "order-cache-delete.DLT" , concurrency = "12")
    public void onDlq(String msg) {
        log.error("死信队列收到失败消息: {}", msg);
    }

}
