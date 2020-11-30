package com.lxk.springcloud.controller;

import com.lxk.springcloud.pojo.Friend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author songshiyu
 * @date 2020/11/17 22:10
 **/
@RestController
@Slf4j
public class Controller {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        ServiceInstance instance = getInstance("erueka-client");
        String requestUrl = String.format("http://%s:%s/sayHi", instance.getHost(), instance.getPort());
        String response = restTemplate.getForObject(requestUrl, String.class);
        log.info("url is {}", requestUrl);
        return response;
    }

    @PostMapping("/testPost")
    public String testPost() {
        ServiceInstance instance = getInstance("erueka-client");
        String requestUrl = String.format("http://%s:%s/sayHi", instance.getHost(), instance.getPort());
        Friend friend = new Friend("Erueka-consumer", "31000");

        String response = restTemplate.postForObject(requestUrl, friend, String.class);
        log.info("url is {}", requestUrl);
        return response;
    }

    private ServiceInstance getInstance(String name) {
        ServiceInstance instance = client.choose(name);

        if (instance == null) {
            return null;
        }
        return instance;
    }
}
