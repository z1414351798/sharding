package com.z.sharding.util;

public class SnowflakeIdUtil {

    private static final long WORKER_ID_MASK = 0x3FFL;  // 10 bits (0-1023)
    private static final int WORKER_ID_SHIFT = 12;       // Snowflake 算法中 workerId 左移12位

    public static int getWorkerId(long id) {
        return (int) ((id >> WORKER_ID_SHIFT) & WORKER_ID_MASK);
    }
}
