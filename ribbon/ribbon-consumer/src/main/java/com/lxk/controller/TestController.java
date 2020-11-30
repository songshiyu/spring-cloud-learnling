package com.lxk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author songshiyu
 * @date 2020/11/21 22:20
 **/
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sayHi")
    public String say() {
        String response = restTemplate.getForObject("http://erueka-client/sayHi", String.class);
        return response;
    }
}
