package com.example.serice_feign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SericeFeignApplication.SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}

