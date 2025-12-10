package com.z.sharding.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable, Versionable  {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String name;
    private String address;
    private String email;
    private int age;
    private String sex;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private long version;
}
