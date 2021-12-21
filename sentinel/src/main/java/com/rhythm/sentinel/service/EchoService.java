package com.rhythm.sentinel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-provider", fallback = EchoServiceFallback.class)
public interface EchoService {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);
}

/**
 * echo service容错
 */
@Component
class EchoServiceFallback implements  EchoService {

    @Override
    public String echo(String str) {
        return "sorry," + str + ", echo service fallback!";
    }
}