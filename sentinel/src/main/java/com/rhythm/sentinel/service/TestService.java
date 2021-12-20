package com.rhythm.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @SentinelResource(value = "sayHello", blockHandler = "sayHelloBlockHandler", fallback = "sayHelloFallbackHandler") // 标识sayHello资源被限流、降级
    public String sayHello(String name) {
        return "hello, " + name;
    }

    /**
     * sayHello资源的block异常处理函数
     * @param name
     * @param blockException
     * @return
     */
    public String sayHelloBlockHandler(String name, BlockException blockException) {
        blockException.printStackTrace();
        return "sorry, sayHello(" + name + ") is block!";
    }

    /**
     * sayHello资源的fallback函数
     * @param name
     * @param throwable
     * @return
     */
    public String sayHelloFallbackHandler(String name, Throwable throwable) {
        throwable.printStackTrace();
        return "sorry sayHello(" + name + ") is fallback!";
    }
}
