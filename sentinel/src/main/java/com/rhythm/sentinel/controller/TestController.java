package com.rhythm.sentinel.controller;

import com.rhythm.sentinel.service.EchoService;
import com.rhythm.sentinel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EchoService echoService;

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return testService.sayHello(name);
    }

    @GetMapping("/test")
    public String testMth() {
        return "I'm test method!";
    }

    @GetMapping("/rest/{str}")
    public String rest(@PathVariable("str") String str) {
        /**
         * 这里使用restTemplate请求的路径是http://service-provider/echo/{str}，故在sentinel控制台做限流时，
         * 资源名称应为
         *      1、GET:http://service-provider/echo/{str}（{str}替换为确定的值）
         *      2、GET:http://service-provider
         */
        return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
    }

    @GetMapping("/feign/{str}")
    public String feign(@PathVariable("str") String str) {
        return echoService.echo(str);
    }

}
