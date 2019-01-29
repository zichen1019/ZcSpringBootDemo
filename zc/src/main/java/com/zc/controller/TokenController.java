package com.zc.controller;

import com.zc.conf.ControllerConfig;
import com.zc.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
@RequestMapping("/token")
public class TokenController extends ControllerConfig {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/info")
    @ResponseBody
    public Map<String, Object> getToken(HttpServletRequest request) {
        RESULT.putAll(tokenService.getToken(request));
        return RESULT;
    }

}
