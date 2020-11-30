package com.lxk.springcloud.controller;

import com.lxk.springcloud.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songshiyu
 * @date 2020/11/30 22:25
 **/
@RestController
@Slf4j
public class Controller {

    @Autowired
    private MyService myService;

    @GetMapping("/fallback")
    public String fallback() {
        return myService.error();
    }
}
