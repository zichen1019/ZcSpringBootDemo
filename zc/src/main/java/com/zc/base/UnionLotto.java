package com.zc.base;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "福利彩票")
@Table(name = "union_lotto")
public class UnionLotto extends Base {

    private String qihao;

    private String kaijiangriqi;

    private String red1;

    private String red2;

    private String red3;

    private String red4;

    private String red5;

    private String red6;

    private String blue;

}
