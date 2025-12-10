package com.z.sharding.service;

import com.z.sharding.generator.MySnowflakeGenerator;
import com.z.sharding.mapper.OrderMapper;
import com.z.sharding.mapper.UserMapper;
import com.z.sharding.pojo.Order;
import com.z.sharding.pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final CacheService cacheService;
    private final UserMapper userMapper;
    private final String UserId = "user:id:";

    public String addUser( User user){
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        cacheService.delete(UserId + user.getUserId());
        return "success: " + user.getUserId();
    }

    public List<User> ListById(String userId){
        String key = UserId + userId;
        return cacheService.get(key, () -> userMapper.selectByUserId(userId),1000);
    }

    public int update(User user){
        int result = userMapper.updateUserDynamic(user);
        cacheService.delete(UserId + user.getUserId());
        return result;
    }
}
