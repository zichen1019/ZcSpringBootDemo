package com.zc.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface TokenService {

    Map getToken(HttpServletRequest request);

}
