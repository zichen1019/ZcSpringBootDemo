package com.zc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@ApiModel(value = "权限字典")
@Table(name = "dic_role")
public class DicRole extends Base {

    @ApiModelProperty(value = "权限名称")
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @ApiModelProperty(value = "权限代码")
    @Column(name = "code")
    @Getter
    @Setter
    private String code;

    @ApiModelProperty(value = "权限描述")
    @Column(name = "describe")
    @Getter
    @Setter
    private String describe;
}
