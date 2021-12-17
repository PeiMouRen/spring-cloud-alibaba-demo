package com.rhythm.controller;

import com.rhythm.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 测试RestTemplate和feign
 * @author xzpei
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EchoService echoService;

    @GetMapping("rest/{value}")
    public String rest(@PathVariable("value") String value) {
        return restTemplate.getForObject("http://service-provider/echo/" + value, String.class);
    }

    @GetMapping("feign/{value}")
    public String feign(@PathVariable("value") String value) {
        return echoService.echo(value);
    }
}
