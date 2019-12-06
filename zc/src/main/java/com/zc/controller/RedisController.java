package com.zc.controller;

import com.zc.conf.ControllerConfig;
import com.zc.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Redis处理器")
@RequestMapping("/redis")
public class RedisController extends ControllerConfig {

    @Autowired
    private RedisService redisService;

    @ApiOperation("Reids测试请求-redisA")
    @GetMapping(value = "/redisA")
    public String redisA() {
        return redisService.redisA();
    }

}
