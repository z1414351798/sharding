//package com.z.sharding.schedule;
//
//import com.z.sharding.mapper.OutboundMessageMapper;
//import com.z.sharding.pojo.OutboundMessage;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class OutBoxSchedule {
//    @Autowired
//    private OutboundMessageMapper outboundMessageMapper;
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    @Scheduled(fixedDelay = 1000)
//    public void sendOutbox() {
//        for (int dbIndex = 0; dbIndex < 4; dbIndex++) {
//            List<OutboundMessage> list =
//                    outboundMessageMapper.selectPending(100);
//
//            if (!list.isEmpty()){
//                for (OutboundMessage msg : list) {
//
//                    try {
//                        kafkaTemplate.send(msg.getTopic(), msg.getBizKey() + "|" + msg.getVersion());
//
//                        outboundMessageMapper.markSent(msg.getId());
//                    } catch (Exception e) {
//                        // 不处理，下次 Job 再发
//                    }
//                }
//            }
//            }
//    }
//
//}
