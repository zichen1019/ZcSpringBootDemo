package com.zc.service.impl;

import com.zc.conf.ServiceImplConfig;
import com.zc.service.RedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl extends ServiceImplConfig implements RedisService {

    @Override
    public String redisA() {
        jedisCluster.set("redisA", "zc say Hello!");
        return jedisCluster.get("redisA");
    }

}
