package com.z.sharding.generator;

import com.z.sharding.util.CRC32Util;

public class MySnowflakeGenerator {

    private static volatile MySnowflakeGenerator instance;
    private MySnowflakeGenerator(){};
    private static long sequence = 0L;
    private static long lastTimestamp = -1L;

    public static MySnowflakeGenerator getInstance(){
        if (instance == null){
            synchronized (MySnowflakeGenerator.class){
                if (instance == null){
                    instance = new MySnowflakeGenerator();
                }
                return instance;
            }
        }
        return instance;
    }

    public synchronized long generate(String userId) {

        int workerId = CRC32Util.hash(userId) % 1024;

        long timestamp = System.currentTimeMillis();

        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & 0xFFFL; // 12-bit sequence
            if (sequence == 0) {
                while (timestamp <= lastTimestamp) {
                    timestamp = System.currentTimeMillis();
                }
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return (timestamp << 22) | ((long) workerId << 12) | sequence;
    }
}
