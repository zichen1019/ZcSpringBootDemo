package com.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ZcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcApplication.class, args);
    }
}
