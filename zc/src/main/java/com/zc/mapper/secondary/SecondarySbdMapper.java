package com.zc.mapper.secondary;

import com.zc.base.Sbd;
import com.zc.conf.ConfigMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecondarySbdMapper extends ConfigMapper<Sbd> {

    List<Sbd> findAll();

}
