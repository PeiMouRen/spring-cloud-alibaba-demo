package com.rhythm.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Config {

    @Bean
    @LoadBalanced // 使得 RestTemplate 接入 Ribbon，开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
