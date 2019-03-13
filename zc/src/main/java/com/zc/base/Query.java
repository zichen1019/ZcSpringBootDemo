package com.zc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel("查询专用")
@ToString
public class Query {

    @ApiParam("当前页数")
    @Getter @Setter
    private int page;

    @ApiParam("当前页数据条数")
    @Getter @Setter
    private int limit;

    @ApiParam("排序。例如：annalid asc")
    @Getter @Setter
    private String sort;

}
