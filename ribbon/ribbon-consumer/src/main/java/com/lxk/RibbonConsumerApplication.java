package com.lxk;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author songshiyu
 * @date 2020/11/21 22:17
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RibbonConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(RibbonConsumerApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
