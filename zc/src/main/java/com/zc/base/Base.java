package com.zc.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

public class Base implements Serializable {

    @ApiModelProperty(required=true, value = "主键")
    @Id
    @Column(name = "annalid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private BigInteger annalid;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建日期")
    @Column(name = "createDate")
    @Getter @Setter
    private Date createDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间")
    @Column(name = "modifyTime")
    @Getter @Setter
    private Timestamp modifyTime;

}
