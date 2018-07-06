package com.lst.service.impl;

import com.alibaba.fastjson.JSON;
import com.lst.service.RedissonDemo;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Service;

@Service
public class RedisssonImpl implements RedissonDemo {

    public static void main(String[] args) {

        // 默认连接地址 127.0.0.1:6379
        RedissonClient redisson = Redisson.create();

        Config config = new Config();
        config.useSingleServer().setAddress("47.100.55.58:6379");
        RedissonClient redisson1 = Redisson.create(config);
        //Redisson程序化的配置方法是通过构建Config对象实例来实现的。例如：
        /*Config config = new Config();
        config.setTransportMode(TransportMode.EPOLL);
        config.useClusterServers()
                //可以用"rediss://"来启用SSL连接
                .addNodeAddress("redis://47.100.55.58:6379");*/

        System.out.println(JSON.toJSONString(redisson1));
    }
}

