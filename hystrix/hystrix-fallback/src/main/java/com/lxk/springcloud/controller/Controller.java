package com.lxk.springcloud.controller;

import com.lxk.springcloud.hystrix.RequestCacheService;
import com.lxk.springcloud.pojo.Friend;
import com.lxk.springcloud.service.MyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    /**
     * 在具体的方法上指定超时时间及超时后的回调函数
     * */
    @GetMapping("/timeout")
    @HystrixCommand(
            fallbackMethod = "timeout2",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            }
    )
    public String timeout(Integer timeout) {
        return myService.retry(timeout);
    }

    public String timeout2(Integer timeout) {
        return "success";
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
