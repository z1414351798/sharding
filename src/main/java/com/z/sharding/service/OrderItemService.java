package com.z.sharding.service;

import com.z.sharding.generator.MySnowflakeGenerator;
import com.z.sharding.mapper.OrderItemMapper;
import com.z.sharding.pojo.Order;
import com.z.sharding.pojo.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final CacheService cacheService;
    private final OrderItemMapper orderItemMapper;
    private final String OrderItemUser = "orderItem:user:";
    private final String OrderItemOrderId = "orderItem:orderId:";

    public String addOrderItem(OrderItem orderItem) {
        orderItem.setItemId(orderItem.getOrderId() + "-" + orderItem.getItemIndex());
        orderItem.setCreateTime(LocalDateTime.now());
        orderItemMapper.insert(orderItem);
        // 删除缓存
        cacheService.delete(OrderItemUser + orderItem.getUserId());
        cacheService.delete(OrderItemOrderId + orderItem.getOrderId());
        return "success: " + orderItem.getItemId();
    }

    public List<OrderItem> listByOrderId(long orderId) {
        String key = OrderItemOrderId + orderId;
        return cacheService.get(key, () -> orderItemMapper.selectByOrderId(orderId), 1000);
    }

    public List<OrderItem> listByUserId(String userId) {
        String key = OrderItemUser + userId;
        return cacheService.get(key, () -> orderItemMapper.selectByUserId(userId), 1000);
    }

    public int update(OrderItem orderItem){
        int result = orderItemMapper.updateOrderItemDynamic(orderItem);
        cacheService.delete(OrderItemOrderId + orderItem.getOrderId());
        return result;
    }
}
