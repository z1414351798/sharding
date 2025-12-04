package com.z.sharding.controller;

import com.z.sharding.generator.MySnowflakeGenerator;
import com.z.sharding.mapper.OrderItemMapper;
import com.z.sharding.pojo.Order;
import com.z.sharding.pojo.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orderItem")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemMapper orderItemMapper;

    @PostMapping("/add")
    public String addOrder(@RequestBody OrderItem orderItem) {
        orderItem.setCreateTime(LocalDateTime.now());
        orderItemMapper.insert(orderItem);
        return "success";
    }

    @GetMapping("/listByOrderId")
    public List<OrderItem> listByOrderId(@RequestParam  long orderId) {
        return orderItemMapper.selectByOrderId(orderId);
    }

    @GetMapping("/listByUserId")
    public List<OrderItem> listByUserId(@RequestParam  String userId) {
        return orderItemMapper.selectByUserId(userId);
    }
}
