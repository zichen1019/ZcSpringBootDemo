package com.zc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zc.base.Probability;
import com.zc.conf.ServiceImplConfig;
import com.zc.mapper.primary.ProbabilityMapperConfig;
import com.zc.service.ProbabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class ProbabilityServiceImpl extends ServiceImplConfig implements ProbabilityService {

    @Autowired
    private ProbabilityMapperConfig probabilityMapperConfig;

    @Override
    public JSONObject get() {
        List<Probability> probabilityList = probabilityMapperConfig.selectAll();
        return SUCCESS.fluentPut("probability", probabilityList);
    }

}
