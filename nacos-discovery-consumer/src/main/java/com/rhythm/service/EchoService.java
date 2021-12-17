package com.rhythm.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-provider")
public interface EchoService {

    @GetMapping("/echo/{value}")
    String echo(@PathVariable("value") String value);
}
