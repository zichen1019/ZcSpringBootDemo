package com.zc.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Date;

public class Base implements Serializable {

    @ApiModelProperty(required=true, value = "主键")
    @Id
    @Column(name = "annalid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private String annalid;

    @ApiModelProperty("创建日期")
    @Column(name = "createDate")
    @Getter @Setter
    private Date createDate;

    @ApiModelProperty("修改时间")
    @Column(name = "modifyTime")
    @Getter @Setter
    private Timestamp modifyTime;

}
