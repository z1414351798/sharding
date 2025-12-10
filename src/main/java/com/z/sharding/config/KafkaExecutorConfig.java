package com.z.sharding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class KafkaExecutorConfig {

    @Bean("cacheDeleteExecutor")
    public ExecutorService cacheDeleteExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                16,                     // core pool
                32,                     // max pool
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20000),   // queue for backpressure
                new ThreadFactory() {
                    private final AtomicInteger idx = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "cache-delete-worker-" + idx.getAndIncrement());
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy()  // backpressure handler
        );

        return executor;
    }
}
