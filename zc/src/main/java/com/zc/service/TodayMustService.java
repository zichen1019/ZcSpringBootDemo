package com.zc.service;

import com.alibaba.fastjson.JSONObject;
import com.zc.base.TodayMust;
import com.zc.base.Query;

public interface TodayMustService {

    /**
     * 此处注意接收Mapper返回值用的是List<实体类>，并非因为Mapper返回值无法用JSONArray接收，
     * 而是因为PageInfo对JSONArray无法提取对应的总条数信息。
     *
     * @param query     查询所需条件
     * @param todayMust 查询根据
     */
    JSONObject get(Query query, TodayMust todayMust);

    /**
     * 保存/更新今日必达事项
     *
     * @param todayMust
     */
    JSONObject save(TodayMust todayMust);

    /**
     * 根据ID进行查询今日必达事项
     *
     * @param id
     */
    JSONObject getinfo(String id);
}
