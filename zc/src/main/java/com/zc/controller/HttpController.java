package com.zc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zc.base.StatusCode;
import com.zc.conf.ControllerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "访问外部")
@RestController
@RequestMapping("/http")
public class HttpController extends ControllerConfig {

    @ApiOperation(value = "获取IP")
    @GetMapping("/getIp")
    @ResponseBody
    public JSONObject getIP(HttpServletRequest request) {
        return RESULT.fluentPut("StatusCode", StatusCode.SUCCESS).fluentPut("PublicIp", getIpAddr(request));
    }

}
