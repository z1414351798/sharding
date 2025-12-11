//package com.z.sharding.service;
//
//import com.z.sharding.pojo.Order;
//import lombok.RequiredArgsConstructor;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class ExternalOrderProducer {
//    private final KafkaTemplate<String, Order> orderKafkaTemplate;
//
//    public void sendOrder(Order order) {
//        orderKafkaTemplate.send("order-cache-delete", order);
//    }
//}
