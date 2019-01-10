package com.zc.mapper.primary;

import com.zc.base.Sbd;
import com.zc.conf.MapperConfig;

import java.util.List;

public interface SbdMapperConfig extends MapperConfig<Sbd> {

    List<Sbd> findAll();

}
