package com.zc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.zc.base.UnionLotto;
import com.zc.conf.ServiceImplConfig;
import com.zc.mapper.primary.UnionLottoMapperConfig;
import com.zc.service.UnionLottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UnionLottoServiceImpl extends ServiceImplConfig implements UnionLottoService {

    @Autowired
    private UnionLottoMapperConfig unionLottoMapperConfig;

    @Override
    public JSONObject get() {
        PageHelper.orderBy("qihao asc");
        List<UnionLotto> unionLottoList = unionLottoMapperConfig.selectAll();
        return SUCCESS.fluentPut("unionLotto", unionLottoList);
    }
}
