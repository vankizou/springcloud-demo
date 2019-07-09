package com.vanki.feign.service;

import org.springframework.stereotype.Component;

/**
 * hystric 断路器，只当 springcloud-client 全挂后才会调这里
 *
 * @author vanki
 * @date 2019-07-09 15:09
 */
@Component
public class ScheduleSpringCloudClientHystric implements ScheduleSpringCloudClient {

    @Override
    public String sayHiFromOneClient(String name) {
        return "hi. " + name + ", sorry this is feign-hytrix";
    }
}
