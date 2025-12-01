package com.z.sharding.controller;

import com.z.sharding.mapper.UserMapper;
import com.z.sharding.pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserMapper userMapper;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        return "success";
    }

    @GetMapping("/ListById")
    public List<User> ListById(@RequestParam  String userId){
        return userMapper.selectByUserId(userId);
    }
}
