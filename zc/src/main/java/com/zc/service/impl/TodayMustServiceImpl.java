package com.zc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.base.TodayMust;
import com.zc.base.Query;
import com.zc.conf.ServiceImplConfig;
import com.zc.mapper.primary.TodayMustMapperConfig;
import com.zc.service.TodayMustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class TodayMustServiceImpl extends ServiceImplConfig implements TodayMustService {

    @Autowired
    private TodayMustMapperConfig todayMustMapperConfig;

    /**
     *  此处注意接收Mapper返回值用的是List<实体类>，并非因为Mapper返回值无法用JSONArray接收，
     *  而是因为PageInfo对JSONArray无法提取对应的总条数信息。
     *
     * @param query     查询所需条件
     * @param todayMust 查询根据
     * @return          当页数据，总条数
     */
    @Override
    public JSONObject getTodayMust(Query query, TodayMust todayMust) {
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<TodayMust> todayMusts = todayMustMapperConfig.getTodayMustList(todayMust);
        PageInfo pageInfo = new PageInfo(todayMusts);
        return SUCCESS.fluentPut("todayMusts", todayMusts).fluentPut("total", pageInfo.getTotal());
    }
}
