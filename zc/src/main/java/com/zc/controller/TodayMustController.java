package com.zc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zc.base.TodayMust;
import com.zc.base.User;
import com.zc.common.utils.JWTUtil;
import com.zc.conf.ControllerConfig;
import com.zc.base.Query;
import com.zc.service.TodayMustService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public JSONObject get(Query query, TodayMust todayMust, HttpServletRequest request) {
        System.err.println(getIpAddr(request));
        System.err.println(getIpAddr(request));
        return todayMustService.get(query, todayMust);
    }

    @ApiOperation(value = "获取今日必达列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "todayMust", value = "查询条件", dataTypeClass = TodayMust.class),
            @ApiImplicitParam(name = "query", value = "查询专用", dataTypeClass = Query.class)})
    @GetMapping("/getinfo")
    @ResponseBody
    public JSONObject getinfo(String id) {
        return todayMustService.getinfo(id);
    }

    @ApiOperation(value = "新建/更新今日必达")
    @ApiImplicitParams({@ApiImplicitParam(name = "todayMust", value = "查询条件", dataTypeClass = TodayMust.class)})
    @PostMapping("/save")
    @ResponseBody
    public JSONObject save(@RequestBody JSONObject tm, HttpServletRequest request) {
        User user = JWTUtil.parse(request.getHeader("x-csrftoken"));
        TodayMust todayMust = JSON.parseObject(tm.toJSONString(), TodayMust.class);
        todayMust.setUserId(user.getId());
        return todayMustService.save(todayMust);
    }

}
