package com.redstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @date: 2019-03-19 上午 11:24
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudDemoProviderTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoProviderTwoApplication.class, args);
    }
}
