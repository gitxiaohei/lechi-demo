package com.eurekaserver.lechidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LechidemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LechidemoApplication.class, args);
    }

}
