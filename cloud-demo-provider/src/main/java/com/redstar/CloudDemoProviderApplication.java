package com.redstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @date: 2019-03-19 上午 10:47
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudDemoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoProviderApplication.class, args);
    }
}
