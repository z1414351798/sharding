package com.z.sharding.controller;

import com.z.sharding.mapper.RegionMapper;
import com.z.sharding.pojo.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {
    private final RegionMapper regionMapper;

    @PostMapping("/add")
    public String addRegion(@RequestBody Region region){
        region.setCreateTime(LocalDateTime.now());
        region.setUpdateTime(LocalDateTime.now());
        regionMapper.insert(region);
        return "success";
    }

    @GetMapping("/getById")
    public Region getById(int id){
        return regionMapper.getById(id);
    }
}
