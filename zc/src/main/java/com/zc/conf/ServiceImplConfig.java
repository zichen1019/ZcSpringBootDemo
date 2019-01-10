package com.zc.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
public class ServiceImplConfig {

    @Autowired
    protected JedisCluster jedisCluster;

}
