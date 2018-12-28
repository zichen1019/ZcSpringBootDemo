package com.demo.zc.controller;

import com.demo.zc.ZcApplicationTests;
import com.demo.zc.base.Sbd;
import com.demo.zc.service.SbdService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SbdControllerTest extends ZcApplicationTests {

    @Autowired
    private SbdService sbdService;

    @Test
    public void findAll() {
        System.err.println("findAll()");
        List<Sbd> sbds = sbdService.findAll();
        for(Sbd sbd : sbds){
            System.err.println(sbd);
        }
    }

    @Test
    public void findAll2() {
        System.err.println("findAll2()");
        List<Sbd> sbds = sbdService.findAll2();
        for(Sbd sbd : sbds){
            System.err.println(sbd);
        }
    }
}