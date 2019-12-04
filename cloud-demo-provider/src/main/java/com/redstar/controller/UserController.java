package com.redstar.controller;

import com.redstar.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2019-03-19 上午 10:50
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("张三");
        user.setAge(18);
        return user;
    }

    @GetMapping(value = "/getName")
    public String getName() {
        return "张三";
    }
}
