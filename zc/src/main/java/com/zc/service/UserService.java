package com.zc.service;

import com.zc.base.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {

    Map login(User user, HttpServletRequest request);

    Map register(User user);

    Map getInfo(String CSRFTOKEN, HttpServletRequest request);
}
