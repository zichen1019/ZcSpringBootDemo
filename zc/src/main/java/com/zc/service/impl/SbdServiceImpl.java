package com.zc.service.impl;

import com.zc.base.Sbd;
import com.zc.conf.ServiceImplConfig;
import com.zc.mapper.primary.SbdMapperConfig;
import com.zc.mapper.secondary.SecondarySbdMapperConfig;
import com.zc.service.SbdService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SbdServiceImpl extends ServiceImplConfig implements SbdService {

    @Autowired
    private SbdMapperConfig primarySbdMapper;

    @Autowired
    private SecondarySbdMapperConfig secondarySbdMapper;

    @Override
    public List<Sbd> findAll() {
        PageHelper.startPage(0,10);
        Sbd sbd = new Sbd();
        sbd.setId("6666666666");
        List<Sbd> sbds = primarySbdMapper.select(sbd);
        return sbds;
    }

    @Override
    public List<Sbd> findAll2() {
        List<Sbd> sbds = secondarySbdMapper.selectAll();
        return sbds;
    }

    @Override
    public List<Sbd> findAll3() {
        return primarySbdMapper.findAll();
    }
}
