package com.z.sharding.mapper;

import com.z.sharding.pojo.OutboundMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OutboundMessageMapper {
    void insert(OutboundMessage msg);

    List<OutboundMessage> selectPending(@Param("limit") int limit);

    int markSent(@Param("id") Long id);
}
