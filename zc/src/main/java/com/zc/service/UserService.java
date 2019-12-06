package com.zc.service;

import com.alibaba.fastjson.JSONObject;
import com.zc.base.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    JSONObject login(User user, HttpServletRequest request);

    JSONObject register(User user);

    /**
     * 获取用户信息
     *
     * @param user
     * @return
     */
    JSONObject getInfo(User user);
}
