package com.zc.conf;

import com.alibaba.fastjson.JSONObject;
import com.zc.base.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @author zichen
 */
@Service
public class ServiceImplConfig {

    @Autowired
    protected JedisCluster jedisCluster;

    /**
     * 成功回复
     */
    protected final JSONObject SUCCESS;

    public ServiceImplConfig() {
        SUCCESS = new JSONObject();
        SUCCESS.fluentPut("StatusCode", StatusCode.SUCCESS);
    }

}
