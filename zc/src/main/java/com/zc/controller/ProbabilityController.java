package com.zc.controller;

import com.alibaba.fastjson.JSONObject;
import com.zc.conf.ControllerConfig;
import com.zc.service.ProbabilityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Api(tags = "福利彩票分析")
@RestController
@RequestMapping("/probability")
public class ProbabilityController extends ControllerConfig {

    @Autowired
    private ProbabilityService probabilityService;

    @ApiOperation(value = "获取福利彩票数据分析信息")
    @GetMapping("/get")
    @ResponseBody
    public JSONObject get() {
        return probabilityService.get();
    }

}
