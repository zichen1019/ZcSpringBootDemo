package com.zc.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    JSONObject getToken(HttpServletRequest request);

}
