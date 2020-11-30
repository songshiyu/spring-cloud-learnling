package com.lxk.springcloud.controller;

import com.lxk.springcloud.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songshiyu
 * @date 2020/11/30 22:12
 **/
@RestController
@Slf4j
public class Controller {

    @Autowired
    private IService iService;

    @GetMapping("/sayHi")
    public String sayHi() {
        return iService.sayHi();
    }

}
