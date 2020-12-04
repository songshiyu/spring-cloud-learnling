package com.lxk.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author songshiyu
 * @date 2020/12/4 21:53
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
@EnableTurbine
public class HystrixTurbineApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixTurbineApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
