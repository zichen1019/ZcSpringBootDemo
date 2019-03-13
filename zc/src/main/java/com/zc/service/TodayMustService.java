package com.zc.service;

import com.alibaba.fastjson.JSONObject;
import com.zc.base.TodayMust;
import com.zc.base.Query;

public interface TodayMustService {

    JSONObject getTodayMust(Query query, TodayMust todayMust);

}
