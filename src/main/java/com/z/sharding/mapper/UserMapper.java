package com.z.sharding.mapper;

import com.z.sharding.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(User user);

    List<User> selectByUserId(String userId);

    int updateUserDynamic(User user);
}
