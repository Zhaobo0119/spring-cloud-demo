package com.redstar.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2019-03-20 上午 12:26
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@Configuration
public class LoanBalanced {

    @Bean
    public IRule ribbonRole() {
        //轮训
        return new RoundRobinRule();
        //加权权重
        // return new WeightedResponseTimeRule();
        //带有重试机制的轮训
        //return new RetryRule();
        //随机
        //return new RandomRule();
        //自定义规则
        //return new TestRule();
    }
}
