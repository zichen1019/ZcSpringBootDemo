package com.zc.controller;

import com.alibaba.fastjson.JSONObject;
import com.zc.conf.ControllerConfig;
import com.zc.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(tags = "x-csrfToken处理器")
@RestController
@RequestMapping("/token")
public class TokenController extends ControllerConfig {

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "获取x-csrfToken")
    @GetMapping("/info")
    @ResponseBody
    public JSONObject getToken(HttpServletRequest request) {
        RESULT.fluentPutAll(tokenService.getToken(request));
        return RESULT;
    }

}
