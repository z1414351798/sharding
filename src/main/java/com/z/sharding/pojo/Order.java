package com.z.sharding.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// TradeEvent.java
@Data
public class Order {
    private Long id;
    private String userId;
    private String regionCode;
    private String goodId;
    private String goodName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
