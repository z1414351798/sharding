package com.z.sharding.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// TradeEvent.java
@Data
public class Order {
    private long orderId;
    private String userId;
    private String regionCode;
    private BigDecimal totalAmount;
    private int status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private List<OrderItem> OrderItemList;
}
