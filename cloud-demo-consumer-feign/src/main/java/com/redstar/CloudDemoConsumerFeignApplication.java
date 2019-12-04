package com.redstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @date: 2019-03-19 上午 10:58
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@EnableEurekaClient
@SpringBootApplication
//指定provider-demo服务使用的是LoadBalanced类提供的规则
@RibbonClient(name = "provider-demo", configuration = com.redstar.config.LoanBalanced.class)
@EnableFeignClients
public class CloudDemoConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoConsumerFeignApplication.class, args);
    }
}