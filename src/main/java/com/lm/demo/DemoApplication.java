package com.lm.demo;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

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
//        ReadWriteLock
//        AbstractApplicationContext
        SpringApplication.run(DemoApplication.class, args);
    }

}
