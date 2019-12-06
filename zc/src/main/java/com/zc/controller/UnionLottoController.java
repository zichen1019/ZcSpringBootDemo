package com.zc.controller;

import com.alibaba.fastjson.JSONObject;
import com.zc.conf.ControllerConfig;
import com.zc.service.UnionLottoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "福利彩票")
@RestController
@RequestMapping("/unionLotto")
public class UnionLottoController extends ControllerConfig {

    @Autowired
    private UnionLottoService unionLottoService;

    @ApiOperation(value = "获取福利彩票中奖信息")
    @GetMapping("/get")
    @ResponseBody
    public JSONObject get() {
        return unionLottoService.get();
    }

}
