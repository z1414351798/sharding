package com.z.sharding.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// TradeEvent.java
@Data
public class Order implements Serializable, Versionable {
    private static final long serialVersionUID = 1L;
    private long orderId;
    private String userId;
    private String regionCode;
    private BigDecimal totalAmount;
    private int status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private List<OrderItem> OrderItemList;
    private long version;
}
