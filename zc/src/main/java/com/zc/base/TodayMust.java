package com.zc.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "今日必达")
@Table(name = "today_must")
public class TodayMust extends Base {

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user")
    private Long userId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "提交时间")
    @Column(name = "executionTime")
    private Date executionTime;

    @ApiModelProperty(value = "标题")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "必达信息")
    @Column(name = "todaymust")
    private String todaymust;

    @ApiModelProperty(value = "完成状态")
    @Column(name = "complete")
    private Boolean complete;

    @ApiModelProperty(value = "当日排序")
    @Column(name = "sort")
    private Integer sort;

}
