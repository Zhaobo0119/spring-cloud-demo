package com.redstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @date: 2019-03-19 上午 11:05
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudDemoEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudDemoEurekaApplication.class, args);
    }
}
