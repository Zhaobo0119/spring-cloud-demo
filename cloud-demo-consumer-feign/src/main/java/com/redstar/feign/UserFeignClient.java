package com.redstar.feign;

import com.redstar.config.Configuration;
import com.redstar.domain.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @date: 2019-03-20 上午 12:49
 * @author: zhaobo0119@outlook.com
 * @Descriptopn: @FeignClient("provider-demo")注解，它括号里的内容
 * 就是我们的服务提供者的名称么，对其实它就是我们需要调用的服务的spring.application.name
 */
@FeignClient(value = "provider-demo", configuration = Configuration.class)
public interface UserFeignClient {

    /*@GetMapping(value = "/user/getUser/{id}")
    public User getUser(@PathVariable("id")Long id);*/

    @RequestLine("GET /user/getUser/{id}")
    public User getUser(@Param("id") Long id);
}
