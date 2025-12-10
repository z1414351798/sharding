package com.z.sharding.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderItem implements Serializable, Versionable  {
    private static final long serialVersionUID = 1L;
    private String itemId;
    private long orderId;
    private String userId;
    private long goodId;
    private String goodNameSnapshot;
    private BigDecimal goodPriceSnapshot;
    private String goodImageSnapshot;
    private String attributesSnapshotJson;
    private int quantity;
    private int itemIndex;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private long version;
}
