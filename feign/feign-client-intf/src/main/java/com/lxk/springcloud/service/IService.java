package com.lxk.springcloud.service;

import com.lxk.springcloud.pojo.Friend;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author songshiyu
 * @date 2020/11/30 21:56
 **/
@FeignClient(name = "feign-client")
public interface IService {

    @GetMapping("/sayHi")
    public String sayHi();

    @PostMapping("/sayHi")
    public Friend sayHiPost(@RequestBody Friend friend);

    @GetMapping("/retry")
    public String retry(@RequestParam(name = "timeout") int timeout);

    @GetMapping("/error")
    public String error();
}
