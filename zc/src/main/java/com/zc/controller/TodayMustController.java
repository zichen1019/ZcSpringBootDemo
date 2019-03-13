package com.zc.controller;

import com.alibaba.fastjson.JSONObject;
import com.zc.base.TodayMust;
import com.zc.conf.ControllerConfig;
import com.zc.base.Query;
import com.zc.service.TodayMustService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "今日必须")
@RestController
@RequestMapping("/todayMust")
public class TodayMustController extends ControllerConfig {

    @Autowired
    private TodayMustService todayMustService;

    @ApiOperation(value = "获取今日必达列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "todayMust", value = "查询条件", dataTypeClass = TodayMust.class),
        @ApiImplicitParam(name = "query", value = "查询专用", dataTypeClass = Query.class)})
    @GetMapping("/get")
    @ResponseBody
    public JSONObject getTodayMust(Query query, TodayMust todayMust){
        return todayMustService.getTodayMust(query, todayMust);
    }

}
