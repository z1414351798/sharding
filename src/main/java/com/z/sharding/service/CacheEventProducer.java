package com.z.sharding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CacheEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendDeleteEvent(String key, long version) {
        String message = key + "|" + version;
        kafkaTemplate.send("order-cache-delete", message);
    }
}
