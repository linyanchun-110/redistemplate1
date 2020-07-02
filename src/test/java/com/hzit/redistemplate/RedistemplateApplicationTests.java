package com.hzit.redistemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Set;

@SpringBootTest
class RedistemplateApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 用list来求最新数据
     */
//    @Test
//    void contextLoads() {
//               ListOperations<String,Object> listOperations=redisTemplate.opsForList();//用来实现消息队列，排行榜（不能实时）
////               listOperations.leftPush("testList",1);//添加的key为redisKey，与创建的list集合同名，后面为值
////               listOperations.leftPush("testList",2);
////               listOperations.leftPush("testList",3);
//            List<Object> range=listOperations.range("testList",0,1);
//            for(Object o:range){
//                System.out.println(o);
//            }
//
//
//    }

    /**
     * 用set找出共同好友
     */
//    @Test
//    void set(){
//        SetOperations<String,String> setOperations=redisTemplate.opsForSet();
////        setOperations.add("set:lin","yu","ren","huang");//冒号前面为set集合文件名（redisKey）,后面为set集合名，整个连接起来为完整集合名
////        setOperations.add("set:zhou","yu","ren","liu");
//        Set<String> set= setOperations.intersect("set:lin","set:zhou");
//        for(String s:set){
//            System.out.println(s);
//        }
//    }

    /**
     * 用set实现对账
     */
//    @Test
//    void set1(){
//        SetOperations<String,String> setOperations=redisTemplate.opsForSet();
////        String localStr1="2010,100,1,bk01";
////        String localStr2="2010,200,1,bk01";
////        String localStr3="2010,300,1,bk01";
////        setOperations.add("local:trade","localStr1","localStr2","localStr3");
////        setOperations.add("bank:trade","localStr1","localStr2");
//        Set<String> set=setOperations.difference("local:trade","bank:trade");
//        for(String s:set){
//            System.out.println(s);
//        }
//    }
    /**
     * 用zset实现排行榜（实时）
     */
    @Test
    void set2(){
        ZSetOperations<String,Object> zSetOperations=redisTemplate.opsForZSet();
//        zSetOperations.add("bd","lin",101);
  //     zSetOperations.add("bd","ling1",100);
        Set<Object>set=zSetOperations.range("bd",0,1);
        for(Object o:set){
            System.out.println(o);
        }
    }
}
