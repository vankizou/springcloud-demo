package com.vanki.feign;

import com.vanki.feign.service.ScheduleSpringCloudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign默认集成了 ribbon和hytrix
 *
 * @author vanki
 * @date 2019-07-09 11:42
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SpringCloudFeignApplication {

    @Autowired
    private ScheduleSpringCloudClient scheduleSpringCloudClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignApplication.class, args);
    }

    @RequestMapping("/hi")
    public String sayHi(String name) {
        return this.scheduleSpringCloudClient.sayHiFromOneClient(name);
    }
}
