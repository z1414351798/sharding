package com.z.sharding.pojo;

import lombok.Data;

@Data
public class OutboundMessage {
    private Long id;

    private String userId; // 逻辑字段，用于分库路由

    private String bizKey;
    private Long version;
    private String topic;
    private Integer status;
}
