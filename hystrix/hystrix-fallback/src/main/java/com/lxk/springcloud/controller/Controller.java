package com.lxk.springcloud.controller;

import com.lxk.springcloud.hystrix.RequestCacheService;
import com.lxk.springcloud.pojo.Friend;
import com.lxk.springcloud.service.MyService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.Cleanup;
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

    @Autowired
    private RequestCacheService requestCacheService;

    @GetMapping("/fallback")
    public String fallback() {
        return myService.error();
    }

    @GetMapping("/timeout")
    public String timeout(Integer timeout) {
        return myService.retry(timeout);
    }

    @GetMapping("/cache")
    public Friend cache(String name) {

        @Cleanup HystrixRequestContext hystrixRequestContext =
                HystrixRequestContext.initializeContext();

        Friend friend = requestCacheService.requestCache(name);
        friend = requestCacheService.requestCache(name);
        return friend;
    }
}
