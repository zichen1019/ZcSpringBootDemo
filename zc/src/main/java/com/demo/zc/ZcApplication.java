package com.demo.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
public class ZcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcApplication.class, args);
    }
}
