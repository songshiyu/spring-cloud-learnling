package com.lxk.springcloud.hystrix;

import com.lxk.springcloud.pojo.Friend;
import com.lxk.springcloud.service.MyService;
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
    public String error() {
        log.info("Fallback: I'm not a black sheep any more");
        return "first fallback";
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
