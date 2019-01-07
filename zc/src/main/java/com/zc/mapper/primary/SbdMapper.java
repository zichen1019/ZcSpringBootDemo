package com.zc.mapper.primary;

import com.zc.base.Sbd;
import com.zc.conf.ConfigMapper;

import java.util.List;

public interface SbdMapper extends ConfigMapper<Sbd> {

    List<Sbd> findAll();

}
