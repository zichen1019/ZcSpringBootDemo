package com.zc.mapper.primary;

import com.zc.base.TodayMust;
import com.zc.conf.MapperConfig;

import java.util.List;

public interface TodayMustMapperConfig extends MapperConfig<TodayMust> {

    List<TodayMust> getTodayMustList(TodayMust todayMust);

}
