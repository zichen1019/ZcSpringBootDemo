package com.zc.mapper.secondary;

import com.zc.base.Sbd;
import com.zc.conf.MapperConfig;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SecondarySbdMapperConfig extends MapperConfig<Sbd> {

    List<Sbd> findAll();

}
