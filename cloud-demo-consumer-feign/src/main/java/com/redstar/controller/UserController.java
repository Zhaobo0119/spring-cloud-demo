package com.redstar.controller;

import com.redstar.domain.User;
import com.redstar.feign.UserFeignClient;
import com.redstar.rabbitmq.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2019-03-19 上午 11:01
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id) {
        return userFeignClient.getUser(id);
    }

    @Autowired
    private RabbitSender sender;

    @GetMapping("/sendDirect")
    public Object sendDirectQueue() {
        sender.sendDirectQueue();
        return "ok";
    }

    @GetMapping("/sendTopic")
    public Object sendTopic() {
        sender.sendTopic();
        return "ok";
    }

    @GetMapping("/sendFanout")
    public Object sendFanout() {
        sender.sendFanout();
        return "ok";
    }

    @GetMapping("/sendHeaders")
    public Object sendHeaders() {
        sender.sendHeaders();
        return "ok";
    }

}
