package com.vanki.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author vanki
 * @date 2019-07-09 11:31
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 当
     *
     * @param name
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return this.restTemplate.getForObject("http://springcloud-client/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi. " + name + ", sorry!";
    }
}
