package com.zc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Table;

@ApiModel("用户")
@Table(name = "sys_user")
public class User extends Base {

    @ApiModelProperty("用户名")
    @Column(name = "username")
    @Getter @Setter
    private String username;

    @ApiModelProperty("密码")
    @Column(name = "password")
    @Length(min = 5)
    @Getter @Setter
    private String password;

    @ApiModelProperty("昵称")
    @Column(name = "nickname")
    @Getter @Setter
    private String nickname;

    @ApiModelProperty("头像")
    @Column(name = "avatar")
    @Getter @Setter
    private String avatar;

    @ApiModelProperty("性别")
    @Column(name = "gender")
    @Getter @Setter
    private boolean gender;

    @ApiModelProperty("生日")
    @Column(name = "birday")
    @Getter @Setter
    private String birday;

    @ApiModelProperty("手机")
    @Column(name = "mobile")
    @Getter @Setter
    private String mobile;

    @ApiModelProperty("地址")
    @Column(name = "addres")
    @Getter @Setter
    private String addres;

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickname + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
