package com.zc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zc.base.User;
import com.zc.common.utils.JWTUtil;
import com.zc.conf.ServiceImplConfig;
import com.zc.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;

@Service
public class TokenServiceImpl extends ServiceImplConfig implements TokenService {

    @Override
    public JSONObject getToken(HttpServletRequest request) {
        User u = new User();

        StringBuilder sb = new StringBuilder();
        int zifu = 0;

        for(int i = 0 ;i < 26; i++) {
            do {
                zifu = new Random().nextInt(122) + 65;
            } while (zifu == 91 || zifu == 92 || zifu == 93 || zifu == 94 || zifu == 95 || zifu == 96);
            sb.append((char) zifu);
        }

        System.out.println("随机name：" + sb.toString());
        u.setUsername(sb.toString());
        String ujson = JSON.toJSONString(u);
        Map<String, Object> map = JWTUtil.Encrypted(ujson);
        String token = (String) map.get("miwen");
        jedisCluster.set(token, (String) map.get("key"));
        SUCCESS.put("token", token+":zc:"+map.get("key"));
        return SUCCESS;
    }

}
