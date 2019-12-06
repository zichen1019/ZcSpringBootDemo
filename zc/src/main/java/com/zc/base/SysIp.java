package com.zc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;


@ApiModel(value = "存储用户登录时常用的IP地址")
@Data
@Table(name = "sys_ip")
public class SysIp extends Base {

    @ApiModelProperty("公网IP")
    @Column(name = "public_ip")
    private String publicIp;

    @ApiModelProperty("内网IP")
    @Column(name = "private_ip")
    private String privateIp;

}
