package com.zc.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

@ApiModel(value = "今日必达")
@Table(name = "today_must")
@ToString
public class TodayMust extends Base {

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user")
    @Getter @Setter
    private BigInteger user;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "提交时间")
    @Column(name = "executionTime")
    @Getter @Setter
    private Date executionTime;

    @ApiModelProperty(value = "标题")
    @Column(name = "title")
    @Getter @Setter
    private String title;

    @ApiModelProperty(value = "必达信息")
    @Column(name = "todaymust")
    @Getter @Setter
    private String todaymust;

    @ApiModelProperty(value = "完成状态")
    @Column(name = "complete")
    @Getter @Setter
    private Boolean complete;

    @ApiModelProperty(value = "当日排序")
    @Column(name = "sort")
    @Getter @Setter
    private Integer sort;

}
