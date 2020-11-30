package com.lxk.springcloud.controller;

import com.lxk.springcloud.pojo.Friend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songshiyu
 * @date 2020/11/10 22:00
 **/
@RestController
@Slf4j
public class Controller {

    @Value("${server.port}")
    private String port;

    @GetMapping("/sayHi")
    public String sayHi() {
        return "I'm a erueka client" + port;
    }

    @PostMapping("/sayHi")
    public String setFriend(@RequestBody Friend friend) {
        friend.setPort(port);
        return friend.getPort();
    }
}
