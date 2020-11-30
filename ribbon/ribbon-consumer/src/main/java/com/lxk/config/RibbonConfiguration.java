package com.lxk.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author songshiyu
 * @date 2020/11/22 8:20
 **/
@Configuration
//采用注解的方式实现指定服务的负载均衡
//@RibbonClient(name = "eureka-client",configuration = com.netflix.loadbalancer.RoundRobinRule.class)
public class RibbonConfiguration {

    //这种是全局的负载均衡策略，本项目调用的所有服务都是采用同一种
    @Bean
    public IRule registerIRule() {
        return new RandomRule();
    }
}
