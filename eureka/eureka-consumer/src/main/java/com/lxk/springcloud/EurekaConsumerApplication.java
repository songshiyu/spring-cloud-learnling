package com.lxk.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author songshiyu
 * @date 2020/11/17 22:07
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerApplication {

    @Bean
    public RestTemplate register() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(EurekaConsumerApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
