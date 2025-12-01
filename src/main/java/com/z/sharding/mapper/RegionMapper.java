package com.z.sharding.mapper;

import com.z.sharding.pojo.Region;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RegionMapper {
    void insert(Region region);

    Region getById(int id);
}
