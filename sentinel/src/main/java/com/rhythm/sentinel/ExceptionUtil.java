package com.rhythm.sentinel;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class ExceptionUtil {

    /**
     * RestTemplate限流后的处理方法
     * @param var1
     * @param var2
     * @param var3
     * @param blockException
     * @return
     * @throws IOException
     */
    public static ClientHttpResponse handlerBlockException(HttpRequest var1, byte[] var2, ClientHttpRequestExecution var3, BlockException blockException) throws IOException {
        blockException.printStackTrace();
        return new SentinelClientHttpResponse("RestTemplate is block!!!");
    }

    /**
     * RestTemplate降级后的处理方法
     * @param var1
     * @param var2
     * @param var3
     * @param blockException
     * @return
     * @throws IOException
     */
    public static ClientHttpResponse handlerFallbackException(HttpRequest var1, byte[] var2, ClientHttpRequestExecution var3, BlockException blockException) throws IOException {
        blockException.printStackTrace();
        return new SentinelClientHttpResponse("RestTemplate is fallback!!!");
    }
}
