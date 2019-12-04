package com.redstar.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;

/**
 * 修改Feign的默认配置
 *
 * @date: 2019-03-20 上午 01:02
 * @author: zhaobo0119@outlook.com
 * @Descriptopn: 我们在此类中修改了Feign的Contract ，
 * 那么Contract 是什么呢。它叫做契约。因为Feign一开始使用的契约是SpringMVC，所以刚才我们SpringMVC的注解的时候直接成功了，
 * 但是你如果现在启动项目你就会发现已经启动不了了。因为Contract.Default()使用的契约是Feign自己的，
 * 也就是说我们要把SpringMVC的注解修改为Feign的注解
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }
}
