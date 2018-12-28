package com.demo.zc.controller;

import com.demo.zc.base.Sbd;
import com.demo.zc.service.SbdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SbdController {

    @Autowired
    private SbdService sbdService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Sbd> findAll(){
        return sbdService.findAll();
    }

    @RequestMapping("/findAll2")
    @ResponseBody
    public List<Sbd> findAll2(){
        return sbdService.findAll2();
    }

    @RequestMapping("/findAll3")
    @ResponseBody
    public List<Sbd> findAll3(){
        return sbdService.findAll3();
    }

}
