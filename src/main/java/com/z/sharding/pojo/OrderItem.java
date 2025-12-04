package com.z.sharding.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderItem {
    private long itemId;
    private long orderId;
    private String userId;
    private long goodId;
    private String goodNameSnapshot;
    private BigDecimal goodPriceSnapshot;
    private String goodImageSnapshot;
    private String attributesSnapshotJson;
    private int quantity;
    private LocalDateTime createTime;

}
