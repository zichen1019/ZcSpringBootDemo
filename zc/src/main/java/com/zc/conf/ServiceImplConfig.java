package com.zc.conf;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
public class ServiceImplConfig {

    @Autowired
    protected JedisCluster jedisCluster;

    protected final JSONObject SUCCESS; // 成功回复

    public ServiceImplConfig() {
        SUCCESS = new JSONObject();
    }

}
