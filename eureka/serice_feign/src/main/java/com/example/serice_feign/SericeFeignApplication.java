package com.example.serice_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SericeFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SericeFeignApplication.class, args);
    }

    @FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
    public interface SchedualServiceHi {
        @RequestMapping(value = "/hi",method = RequestMethod.GET)
        String sayHiFromClientOne(@RequestParam(value = "name") String name);
    }





}
