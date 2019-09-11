package com.hzihui.cloud.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author HZI.HUI
 * @date 2019/9/11 10:54
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 普通版restTemplate调用
     * @return
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    /**
     * 负载均衡版RestTemplate调用
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate loadBalanced(){
        return new RestTemplate();
    }
}
