package com.zc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel("数据库表字段对应测试类 - Sbd")
public class Sbd implements Serializable {

    @ApiModelProperty(required=true, value = "主键")
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private String id;

    @ApiModelProperty(required=true, value = "主要数据")
    @Column(name = "text")
    @Getter @Setter private String text;
}
