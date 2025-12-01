package com.z.sharding.mapper;

import com.z.sharding.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// TradeEventMapper.java
@Mapper
public interface OrderMapper {
    void insert(Order order);

    List<Order> selectByUserId(String userId);

    List<Order> selectByOrderId(Long orderId);
}
