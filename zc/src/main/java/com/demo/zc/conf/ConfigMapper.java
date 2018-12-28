package com.demo.zc.conf;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的ConfigMapper
 *
 */
public interface ConfigMapper<T> extends Mapper<T>, MySqlMapper<T> {
    // FIXME 特别注意，该接口不能被扫描到，否则会出错
}
