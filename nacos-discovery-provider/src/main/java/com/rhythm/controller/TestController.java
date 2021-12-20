package com.rhythm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 动态加载类
public class TestController {

    @Value("${user.name1:defaultName}")
    private String userName;
    @Value("${user.age:20}")
    private String userAge;

    @GetMapping("/user")
    public String getUserInfo() {
        return "hi, my name is " + userName + ", I'm " + userAge + " years old!";
    }

    @GetMapping("/echo/{value}")
    public String echo(@PathVariable String value) {
        return "Hi, I'm nacos-discovery-provider, I received value: " + value;
    }

}