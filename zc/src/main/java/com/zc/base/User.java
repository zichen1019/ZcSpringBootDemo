package com.zc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@ApiModel("用户")
@Table(name = "sys_user")
public class User extends Base {

    @ApiModelProperty("用户名")
    @Column(name = "username")
    private String username;

    @ApiModelProperty("密码")
    @Column(name = "password")
    @Length(min = 5)
    private String password;

    @ApiModelProperty("昵称")
    @Column(name = "nickname")
    private String nickname;

    @ApiModelProperty("头像")
    @Column(name = "avatar")
    private String avatar;

    @ApiModelProperty("性别")
    @Column(name = "gender")
    private Boolean gender;

    @ApiModelProperty("生日")
    @Column(name = "birday")
    private String birday;

    @ApiModelProperty("手机")
    @Column(name = "mobile")
    private String mobile;

    @ApiModelProperty("地址")
    @Column(name = "addres")
    private String addres;
}
