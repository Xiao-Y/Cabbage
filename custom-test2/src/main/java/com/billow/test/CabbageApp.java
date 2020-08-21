package com.billow.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动
 *
 * @author liuyongtao
 * @create 2020-08-20 14:35
 */
@SpringBootApplication
@MapperScan("com.billow.*.dao")
@ComponentScan(basePackages = {"com.billow.custom", "com.billow.test"})
public class CabbageApp {

    public static void main(String[] args) {
        SpringApplication.run(CabbageApp.class, args);
    }
}
