package com.zc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.base.StatusCode;
import com.zc.base.TodayMust;
import com.zc.base.Query;
import com.zc.common.utils.CheckUtil;
import com.zc.conf.ServiceImplConfig;
import com.zc.mapper.primary.TodayMustMapperConfig;
import com.zc.service.TodayMustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

/**
 * @author zichen
 */
@SuppressWarnings("ALL")
@Service
public class TodayMustServiceImpl extends ServiceImplConfig implements TodayMustService {

    @Autowired
    private TodayMustMapperConfig todayMustMapperConfig;


    /**
     * @return 当页数据，总条数
     */
    @Override
    public JSONObject get(Query query, TodayMust todayMust) {
        Weekend<TodayMust> todayMustWeekend = Weekend.of(TodayMust.class);
        WeekendCriteria<TodayMust, Object> weekendCriteria = todayMustWeekend.weekendCriteria();
        if (CheckUtil.isNotNull(todayMust.getTitle())) {
            weekendCriteria.andLike(TodayMust::getTitle, "%" + todayMust.getTitle() + "%");
        }
        if (CheckUtil.isNotNull(todayMust.getComplete())) {
            weekendCriteria.andEqualTo(TodayMust::getComplete, todayMust.getComplete());
        }
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<TodayMust> todayMusts = todayMustMapperConfig.selectByExample(todayMustWeekend);
        PageInfo pageInfo = new PageInfo(todayMusts);
        return SUCCESS.fluentPut("todayMusts", todayMusts).fluentPut("total", pageInfo.getTotal());
    }

    /**
     * @return 保存或更新后的数据，特别是保存时，因为保存时页面无主键
     */
    @Override
    public JSONObject save(TodayMust todayMust) {
        int count = 0;
        if (todayMust.getId() == 0) {
            count = todayMustMapperConfig.insertSelective(todayMust);
        } else {
            count = todayMustMapperConfig.updateByPrimaryKeySelective(todayMust);
        }
        return SUCCESS.fluentPut("success", count == 1).fluentPut("todayMust", todayMust);
    }


    /**
     * @return 今日必达事项
     */
    @Override
    public JSONObject getinfo(String id) {
        Weekend<TodayMust> todayMustWeekend = Weekend.of(TodayMust.class);
        WeekendCriteria<TodayMust, Object> weekendCriteria = todayMustWeekend.weekendCriteria();
        if (CheckUtil.isNotNull(id)) {
            weekendCriteria.andEqualTo(TodayMust::getId, id);
            TodayMust todayMust = todayMustMapperConfig.selectOneByExample(todayMustWeekend);
            return SUCCESS.fluentPut("todayMust", todayMust);
        }
        return SUCCESS.fluentPut("success", StatusCode.ERROR);
    }
}
