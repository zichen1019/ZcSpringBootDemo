package com.zc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Table;

@ApiModel("用户")
@Table(name = "sys_user")
public class User extends Base {

    @ApiModelProperty("昵称")
    @Column(name = "nickname")
    @Getter @Setter
    private String nickname;

    @ApiModelProperty("用户名")
    @Column(name = "username")
    @Getter @Setter
    private String username;

    @ApiModelProperty("密码")
    @Column(name = "password")
    @Getter @Setter
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickname + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
