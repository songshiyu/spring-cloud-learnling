package com.lxk.springcloud.hystrix;

import com.lxk.springcloud.pojo.Friend;
import com.lxk.springcloud.service.MyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author songshiyu 请求缓存
 * @date 2020/12/1 22:01
 **/
@Service
@Slf4j
public class RequestCacheService {

    @Autowired
    private MyService myService;

    @CacheResult
    //此处的commandKey可以在配置文件中指定其超时时间
    @HystrixCommand(commandKey = "cachekey")
    public Friend requestCache(@CacheKey String name) {
        log.info("request cache " + name);
        Friend friend = new Friend();
        friend.setName(name);
        friend = myService.sayHiPost(friend);
        log.info("after requesting cache " + name);
        return friend;
    }
}
