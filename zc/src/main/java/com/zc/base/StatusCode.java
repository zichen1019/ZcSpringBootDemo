package com.zc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(value = "状态码对应信息")
public class StatusCode {

    @ApiModelProperty(value = "失败", readOnly = true)
    @Getter
    public static final int ERROR = 0;

    @ApiModelProperty(value = "成功", readOnly = true)
    @Getter
    public static final int SUCCESS = 1;

    @ApiModelProperty(value = "用户已存在", readOnly = true)
    @Getter
    public static final int USER_ALREADY_EXISTS = 100;

    @ApiModelProperty(value = "用户不存在", readOnly = true)
    @Getter
    public static final int USER_NOT_FOUNT = 102;

}
