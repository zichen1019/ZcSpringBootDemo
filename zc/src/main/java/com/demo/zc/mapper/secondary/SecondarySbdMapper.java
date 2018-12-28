package com.demo.zc.mapper.secondary;

import com.demo.zc.base.Sbd;
import com.demo.zc.conf.ConfigMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecondarySbdMapper extends ConfigMapper<Sbd> {

    List<Sbd> findAll();

}
