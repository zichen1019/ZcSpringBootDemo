package com.zc.controller;

import com.alibaba.fastjson.JSONObject;
import com.zc.base.User;
import com.zc.conf.ControllerConfig;
import com.zc.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户处理器")
@RestController
@RequestMapping("/user")
public class UserController extends ControllerConfig {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest requests;

    @ApiOperation(value = "注册用户：\n" +
            "100：用户已存在。")
    @PostMapping("/register")
    @ResponseBody
    public JSONObject register(@ApiParam("用户信息") @RequestBody User user){
        RESULT.fluentPutAll(userService.register(user));
        return RESULT;
    }

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "user",value = "用户", required = true, dataTypeClass = User.class)
    /*,@ApiImplicitParam(name = "pageRow", value = "每页条数", required = true, dataType = "int")*/})
    @PostMapping("/info")
    @ResponseBody
    public JSONObject login(@ApiParam("登录用户信息") @RequestBody User user, HttpServletRequest request){
        RESULT.putAll(userService.login(user, request));
        return RESULT;
    }

    @ApiOperation(value = "获取当前用户详细信息")
    @GetMapping("/getinfo")
    public JSONObject getInfo(HttpServletRequest request){
        String cookie = request.getHeader("x-csrftoken");
        RESULT.putAll(userService.getInfo(cookie, request));
        return RESULT;
    }

}
