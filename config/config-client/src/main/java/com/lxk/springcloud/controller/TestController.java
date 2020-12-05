package com.lxk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songshiyu
 * @date 2020/12/5 17:30
 **/
@RestController
public class TestController {

    @Value("${name}")
    private String name;

    @Value("${myWords}")
    private String words;

    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/words")
    public String getWords() {
        return words;
    }
}
