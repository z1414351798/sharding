package com.z.sharding.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String userId;
    private String name;
    private String address;
    private String email;
    private int age;
    private String sex;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
