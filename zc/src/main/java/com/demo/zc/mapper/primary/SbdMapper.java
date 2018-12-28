package com.demo.zc.mapper.primary;

import com.demo.zc.base.Sbd;
import com.demo.zc.conf.ConfigMapper;

import java.util.List;

public interface SbdMapper extends ConfigMapper<Sbd> {

    List<Sbd> findAll();

}
