package com.z.sharding.controller;

import com.z.sharding.generator.MySnowflakeGenerator;
import com.z.sharding.mapper.OrderMapper;
import com.z.sharding.pojo.Order;
import com.z.sharding.service.CacheService;
import com.z.sharding.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CacheService cacheService;

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping("/listByUserId")
    public List<Order> listByUserId(@RequestParam String userId) {
        return orderService.getOrdersByUserId(userId);
    }


    @GetMapping("/listByOrderId")
    public Order listByOrderId(@RequestParam  long orderId) {
        return orderService.getOrdersByOrderId(orderId);
    }

    @PostMapping("/update")
    public int update(@RequestBody Order order){
        return orderService.update(order);
    }
}
