package com.hzit.redistemplate.controller;


import com.hzit.redistemplate.anno.RequestLimit;
import com.hzit.redistemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class LoginController {
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/login")
    @RequestLimit()
    public String login(){
       // ValueOperations valueOperations= redisTemplate.opsForValue();//操作String类
//        valueOperations.set("name","任益蓉");
        User user=new User();
        user.setName("林延春");
        user.setSex("男");
        user.setAdress("车头镇");
        user.setUserId("123");
        String userId=user.getUserId();
        HashOperations<String,String,Object> hashOperations=redisTemplate.opsForHash();
        hashOperations.put("rediskey","hashkey",user);
        Map map=new HashMap<String,String>();
        map.put("name","林延春");
        map.put("sex","男");
        hashOperations.putAll("aa",map);

        return "success";
    }
}
