package com.z.sharding.controller;

import com.z.sharding.generator.MySnowflakeGenerator;
import com.z.sharding.mapper.OrderMapper;
import com.z.sharding.pojo.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order) {
        order.setOrderId(MySnowflakeGenerator.getInstance().generate(order.getUserId()));
        order.setUpdateTime(LocalDateTime.now());
        order.setCreateTime(LocalDateTime.now());
        orderMapper.insert(order);
        return "success";
    }

    @GetMapping("/listByUserId")
    public List<Order> listByUserId(@RequestParam  String userId) {
        return orderMapper.selectByUserId(userId);
    }

    @GetMapping("/listByOrderId")
    public List<Order> listByOrderId(@RequestParam  long orderId) {
        return orderMapper.selectByOrderId(orderId);
    }
}
