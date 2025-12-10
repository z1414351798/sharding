package com.z.sharding.controller;

import com.z.sharding.generator.MySnowflakeGenerator;
import com.z.sharding.mapper.OrderItemMapper;
import com.z.sharding.pojo.Order;
import com.z.sharding.pojo.OrderItem;
import com.z.sharding.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orderItem")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;

    @PostMapping("/add")
    public String addOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.addOrderItem(orderItem);
    }

    @GetMapping("/listByOrderId")
    public List<OrderItem> listByOrderId(@RequestParam  long orderId) {
        return orderItemService.listByOrderId(orderId);
    }

    @GetMapping("/listByUserId")
    public List<OrderItem> listByUserId(@RequestParam  String userId) {
        return orderItemService.listByUserId(userId);
    }

    @PostMapping("/update")
    public int update(@RequestBody OrderItem orderItem) {
        return orderItemService.update(orderItem);
    }
}
