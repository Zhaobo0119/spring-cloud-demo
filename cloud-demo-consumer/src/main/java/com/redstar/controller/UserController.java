package com.redstar.controller;

import com.redstar.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @date: 2019-03-19 上午 11:01
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id) {
        return restTemplate.getForObject("http://provider-demo/user/getUser/" + id, User.class);
    }
}
