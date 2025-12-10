package com.z.sharding.service;

import com.z.sharding.generator.MySnowflakeGenerator;
import com.z.sharding.mapper.OrderMapper;
import com.z.sharding.mapper.OutboundMessageMapper;
import com.z.sharding.pojo.Order;
import com.z.sharding.pojo.OutboundMessage;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ConcurrentModificationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private CacheEventProducer cacheEventProducer;
    @Autowired
    private OutboundMessageMapper outboundMessageMapper;
    private final CacheService cacheService;
    private final OrderMapper orderMapper;
    private final String OrderUser = "order:user:";
    private final String OrderId = "order:id:";

    public List<Order> getOrdersByUserId(String userId) {
        String key = OrderUser + userId;

        // 热点阈值 1000，缓存逻辑全部交给 CacheService
        return cacheService.get(key, () -> orderMapper.selectByUserId(userId), 1000);
    }

    public Order getOrdersByOrderId(long orderId) {
        String key = OrderId + orderId;

        // 热点阈值 1000，缓存逻辑全部交给 CacheService
        return cacheService.get(key, () -> orderMapper.selectByOrderId(orderId), 1000);
    }

    public String addOrder(Order order) {
        order.setOrderId(MySnowflakeGenerator.getInstance().generate(order.getUserId()));
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        order.setVersion(1);

        orderMapper.insert(order);

        // 设置 version，避免未来读旧数据
        redissonClient.getBucket(OrderId + order.getOrderId() + ":version")
                .set(order.getVersion());

        return "success: " + order.getOrderId();
    }


    @Transactional
    public int update(Order order) {

        // 1. 查询数据库旧版本
        Order dbOrder = orderMapper.selectByOrderId(order.getOrderId());
        if (dbOrder == null) {
            throw new RuntimeException("Order not exists: " + order.getOrderId());
        }

        // 2. version + 1
        long newVersion = dbOrder.getVersion() + 1;

        order.setVersion(newVersion);
        order.setUpdateTime(LocalDateTime.now());

        // 3. 乐观锁更新（重要）
        int result = orderMapper.updateOrderWithVersion(order, dbOrder.getVersion());
        if (result == 0) {
            // 乐观锁失败（version 冲突）→ 让前端重试 或返回错误码
            throw new ConcurrentModificationException("Order updated by another thread");
        }

//        // 插入 outbox（必须在同库事务内）
//        OutboundMessage msg = new OutboundMessage();
//        msg.setUserId(dbOrder.getUserId());  // 分库关键
//        msg.setBizKey(OrderId + order.getOrderId());
//        msg.setVersion(newVersion);
//        msg.setStatus(0);
//        msg.setTopic("order-cache-delete");
//
//        outboundMessageMapper.insert(msg);
//
//        OutboundMessage msg2 = new OutboundMessage();
//        msg.setUserId(dbOrder.getUserId());  // 分库关键
//        msg.setBizKey(OrderUser + order.getUserId());
//        msg.setVersion(0L);
//        msg.setStatus(0);
//        msg.setTopic("order-cache-delete");
//
//        outboundMessageMapper.insert(msg2);


//        if (result > 0) {
//            // 4. MQ 通知清缓存
//            cacheEventProducer.sendDeleteEvent(OrderId + order.getOrderId(), newVersion);
//            cacheEventProducer.sendDeleteEvent(OrderUser + order.getUserId(), 0);
//        }

        return result;
    }

}
