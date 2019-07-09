package com.vanki.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 业务客户端
 *
 * @author vanki
 * @date 2019-07-08 19:05
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudClientApplication {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientApplication.class);
    }

    @RequestMapping("/hi")
    public String hi(String name) {
        return "hi: " + name + ", I am the server " + port;
    }
}
