package com.z.sharding.mapper;

import com.z.sharding.pojo.Order;
import com.z.sharding.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    void insert(OrderItem orderItem);

    List<OrderItem> selectByItemId(long itemId);

    List<OrderItem> selectByOrderId(long orderId);

    List<OrderItem> selectByUserId(String userId);
}
