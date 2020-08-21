package com.billow.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuyongtao
 * @create 2020-08-20 14:35
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.billow.custom", "com.billow.test"})
public class CabbageApp {

    public static void main(String[] args) {
        SpringApplication.run(CabbageApp.class, args);
    }
}
