package com.mystudy.multilearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//设置开启定时任务
@EnableScheduling
@SpringBootApplication
public class MultiLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiLearningApplication.class, args);
    }

}
