package com.rhythm.sentinel.configuration;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.rhythm.sentinel.ExceptionUtil;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    @SentinelRestTemplate(blockHandlerClass = ExceptionUtil.class, blockHandler = "handlerBlockException", fallbackClass = ExceptionUtil.class, fallback = "handlerFallbackException") // 对RestTemplate进行sentinel保护
    @LoadBalanced // 开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
