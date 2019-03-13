package com.zc.service;

import com.alibaba.fastjson.JSONObject;
import com.zc.base.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    JSONObject login(User user, HttpServletRequest request);

    JSONObject register(User user);

    JSONObject getInfo(String CSRFTOKEN, HttpServletRequest request);
}
