package com.vanki.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author vanki
 * @date 2019-07-09 11:46
 */

/**
 * value: 业务客户端，fallback：当业务客户端全挂了后会直接断路到这，不会再请求业务客户端
 */
@FeignClient(value = "springcloud-client", fallback = ScheduleSpringCloudClientHystric.class)
public interface ScheduleSpringCloudClient {

    /**
     * 客户端会起N个，会自动调用客户端的 /hi
     *
     * @param name
     *
     * @return
     */
    @RequestMapping(value = "/hi")
    String sayHiFromOneClient(@RequestParam("name") String name);

}
