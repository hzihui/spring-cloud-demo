package com.hzihui.cloud.consumer.ribbo;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 负载均衡规则
 * @author HZI.HUI
 * @date 2019/9/11 11:36
 */
@Configuration
public class RibboConfig {

    /**
     * 轮询模式
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RoundRobinRule();
    }
}
