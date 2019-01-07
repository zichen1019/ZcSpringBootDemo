package com.zc.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

public class Sbd implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private String id;

    @Column(name = "text")
    @Getter @Setter private String text;

    @Transient // 注解含义：排除此字段，不从数据库获取数据
    @Getter @Setter private int pagesize;

    @Transient
    @Getter @Setter private int pagecount;
}
