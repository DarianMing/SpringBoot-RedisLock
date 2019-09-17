package com.lm.demo;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private RedissonClient redissonClient;

    public void test () {
        RLock redLock = redissonClient.getRedLock();
        boolean b = redLock.tryLock();
    }

    public static void main(String[] args) {
        //RedissonAutoConfiguration

        SpringApplication.run(DemoApplication.class, args);
    }

}
