package com.redstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @date: 2019-03-19 上午 10:58
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "provider-demo", configuration = com.redstar.config.LoanBalanced.class)
public class CloudDemoConsumerApplication {

    @Bean
    @LoadBalanced//开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudDemoConsumerApplication.class, args);
    }
}