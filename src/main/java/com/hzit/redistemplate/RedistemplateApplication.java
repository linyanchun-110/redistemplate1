package com.hzit.redistemplate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RedistemplateApplication {


    public static void main(String[] args) {
        SpringApplication.run(RedistemplateApplication.class, args);
    }



}
