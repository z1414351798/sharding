package com.z.sharding.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Region {
    private int id;
    private String name;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
