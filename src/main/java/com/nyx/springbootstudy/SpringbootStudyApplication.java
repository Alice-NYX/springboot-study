package com.nyx.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//标记这个类是一个springboot应用：启动类下的所有资源被导入
public class SpringbootStudyApplication {

    public static void main(String[] args) {
        //将springboot这个应用启动
        SpringApplication.run(SpringbootStudyApplication.class, args);
    }

}
