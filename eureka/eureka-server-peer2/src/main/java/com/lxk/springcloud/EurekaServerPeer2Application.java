package com.lxk.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author songshiyu
 * @date 2020/11/18 22:09
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerPeer2Application {

    public static void main(String[] args) {

        new SpringApplicationBuilder(EurekaServerPeer2Application.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
