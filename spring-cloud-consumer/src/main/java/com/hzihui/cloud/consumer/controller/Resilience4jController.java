package com.hzihui.cloud.consumer.controller;

import com.hzihui.cloud.consumer.inteface.FeignTestInterface;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Resilience4j 重试、限流、断路器测试接口
 * @author HZI.HUI
 * @date 2019/9/11 16:55
 */
@RestController
@RequestMapping("resilience4j")
@RequiredArgsConstructor
public class Resilience4jController {

    private final FeignTestInterface feignTestInterface;

    /**
     * 重试接口
     * @return
     */
    @RequestMapping("retry")
    @Retry(name="retryBackendA")
    public String retry(){
        return feignTestInterface.testFeign1("重试接口调用");
    }


    /**
     * 限流接口
     */
    @RequestMapping("limiter")
    @RateLimiter(name="limiterA")
    public String limiter(){
        return feignTestInterface.testFeign1("限流接口调用");
    }

    /**
     * 熔断接口
     */
    @RequestMapping("circuitbreaker")
    @CircuitBreaker(name="circuitbreakerA")
    public String circuitbreaker(){
        return feignTestInterface.testFeign1("熔断接口调用");
    }
}
