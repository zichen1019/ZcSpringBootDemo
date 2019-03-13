package com.zc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigInteger;

@ApiModel("个人拥有权限")
@Table(name = "sys_role")
public class Role extends Base {

    @ApiModelProperty("用户ID")
    @Column(name = "user_id")
    @Getter @Setter
    private BigInteger userid;

    @ApiModelProperty("权限代码")
    @Column(name = "code")
    @Getter @Setter
    private String code;

}
