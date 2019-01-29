package com.zc.conf;

import com.zc.base.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceImplConfig {

    @Autowired
    protected JedisCluster jedisCluster;

    protected final Map<String, Object> SUCCESS; // 成功回复

    public ServiceImplConfig() {
        SUCCESS = new HashMap<>();
        SUCCESS.put("success", StatusCode.SUCCESS);
    }

    public Map DataAndStatus(String key, Object value){
        SUCCESS.put(key, value);
        return SUCCESS;
    }

}
