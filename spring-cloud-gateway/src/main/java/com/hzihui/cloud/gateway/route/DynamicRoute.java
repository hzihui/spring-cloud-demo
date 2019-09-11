package com.hzihui.cloud.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 编程式自定义路由
 * @author HZI.HUI
 * @date 2019/9/11 14:27
 */
@Configuration
public class DynamicRoute {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder){
        return locatorBuilder.routes()
                .route("test2",predicateSpec -> predicateSpec.path("/restConsumer/test2")
                        .uri("lb://spring-cloud-consumer"))
                .build();
    }
}
