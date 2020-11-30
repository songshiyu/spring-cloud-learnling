package com.lxk.springcloud.service;

import com.lxk.springcloud.hystrix.Fallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author songshiyu
 * @date 2020/11/30 22:23
 **/
@FeignClient(value = "feign-client", fallback = Fallback.class)
public interface MyService extends IService {
}
