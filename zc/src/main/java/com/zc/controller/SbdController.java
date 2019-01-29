package com.zc.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.zc.base.Sbd;
import com.zc.conf.ControllerConfig;
import com.zc.service.SbdService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(tags = "测试处理器")
@RestController
@RequestMapping("/demo")
public class SbdController extends ControllerConfig {

    @Autowired
    private SbdService sbdService;
    
    @ApiOperation("测试请求-findAll")
    @RequestMapping(value = "/findAll", method = GET)
    @ResponseBody
    public List<Sbd> findAll(){
        return sbdService.findAll();
    }

    @ApiOperation("测试请求-findAll2")
    @RequestMapping(value = "/findAll2", method = GET)
    @ResponseBody
    public List<Sbd> findAll2(){
        return sbdService.findAll2();
    }

    @ApiOperation("测试请求-findAll3")
    @RequestMapping(value = "/findAll3", method = GET)
    @ResponseBody
    public List<Sbd> findAll3(@ApiParam("顺序：第几个查询方法") @RequestParam int three,
                              @ApiParam("顺序：描述") @RequestParam String s){
        return sbdService.findAll3();
    }

    /**
     * 返回druid配置
     * @return
     */
    @ApiOperation("获取Druid框架所持有数据-stat")
    @RequestMapping(value = "/stat", method = GET)
    public Object stat(){
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }

}
