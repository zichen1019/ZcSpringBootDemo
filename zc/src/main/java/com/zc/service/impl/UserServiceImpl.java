package com.zc.service.impl;

import com.alibaba.fastjson.JSON;
import com.zc.base.StatusCode;
import com.zc.base.User;
import com.zc.common.utils.JWTUtil;
import com.zc.conf.ServiceImplConfig;
import com.zc.mapper.primary.UserMapperConfig;
import com.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class UserServiceImpl extends ServiceImplConfig implements UserService {

    @Autowired
    private UserMapperConfig userMapperConfig;

    @Autowired
    private HttpServletRequest requests;

    @Override
    public Map login(User user, HttpServletRequest request) {
        String bcpePassword = user.getPassword();//new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(bcpePassword);
        User u = userMapperConfig.selectOne(user);
        if(u != null){
            String ujson = JSON.toJSONString(u);
            Map<String, Object> map =JWTUtil.Encrypted(ujson);
            String token = (String) map.get("miwen");
            jedisCluster.set(token, (String) map.get("key"));
            userMapperConfig.updateByPrimaryKeySelective(u);
            SUCCESS.put("token", token+":zc:"+map.get("key"));
            return SUCCESS;
        }
        return DataAndStatus("success", StatusCode.ERROR);
    }

    @Override
    public Map register(User user) {
        User u = new User();
        u.setUsername(user.getUsername());
        u = userMapperConfig.selectOne(u);
        if(u != null){
            SUCCESS.put("error", StatusCode.USER_ALREADY_EXISTS);
            return DataAndStatus("success", StatusCode.ERROR);
        }
        String bcpePassword = user.getPassword();//new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(bcpePassword);
        user.setCreateDate(new Date());
        int count = userMapperConfig.insert(user);
        if(count == 1){
            return SUCCESS;
        }
        return DataAndStatus("success", StatusCode.ERROR);
    }

    @Override
    public Map getInfo(String CSRFTOKEN, HttpServletRequest request) {
        CSRFTOKEN = request.getHeader("x-csrftoken");
        String userstr = JWTUtil.Payload(CSRFTOKEN.split(":zc:")[0], CSRFTOKEN.split(":zc:")[1]);
        System.out.println("jedisCluster:::" + jedisCluster.get(CSRFTOKEN.split(":zc:")[0]));
        User user = JSON.parseObject(userstr, User.class);
        user = userMapperConfig.selectOne(user);
        if(user != null) {
            String ujson = JSON.toJSONString(user);
            Map<String, Object> map =JWTUtil.Encrypted(ujson);
            String token = (String) map.get("miwen");
            jedisCluster.set(token, (String) map.get("key"));
            SUCCESS.put("user", user);
            return SUCCESS;
        }
        return DataAndStatus("success", StatusCode.ERROR);
    }
}
