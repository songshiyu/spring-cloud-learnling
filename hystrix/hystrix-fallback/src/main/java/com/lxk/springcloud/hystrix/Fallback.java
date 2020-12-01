package com.lxk.springcloud.hystrix;

import com.lxk.springcloud.pojo.Friend;
import com.lxk.springcloud.service.MyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author songshiyu
 * @date 2020/11/30 22:24
 **/
@Slf4j
@Component
public class Fallback implements MyService {

    @Override
    @HystrixCommand(fallbackMethod = "fallback1")
    public String error() {
        log.info("Fallback: I'm not a black sheep any more");
        throw new RuntimeException("falback");
        //return "first fallback";
    }

    @HystrixCommand(fallbackMethod = "fallback2")
    public String fallback1() {
        log.info("fallback again");
        throw new RuntimeException("fallback");
    }

    @HystrixCommand(fallbackMethod = "fallback3")
    public String fallback2() {
        log.info("fallback again and again");
        throw new RuntimeException("fallback");
    }

    public String fallback3() {
        return "success";
    }

    @Override
    public String sayHi() {
        return null;
    }

    @Override
    public Friend sayHiPost(Friend friend) {
        return null;
    }

    @Override
    public String retry(int timeout) {
        return "you are late ！";
    }


}
