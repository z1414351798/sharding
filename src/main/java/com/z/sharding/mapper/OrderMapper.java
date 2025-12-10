package com.z.sharding.mapper;

import com.z.sharding.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// TradeEventMapper.java
@Mapper
public interface OrderMapper {
    void insert(Order order);

    List<Order> selectByUserId(String userId);

    Order selectByOrderId(long orderId);

    int updateOrderDynamic(Order order);

    long selectVersion(long orderId);

    int updateOrderWithVersion(@Param("order") Order order,
                               @Param("oldVersion") long oldVersion);}
