package com.hzihui.cloud.consumer.inteface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign 服务调用接口
 * @author HZI.HUI
 * @date 2019/9/11 11:58
 */
@FeignClient("spring-cloud-provider")
public interface FeignTestInterface {

    /**
     * 使用openfeign调用
     * @param name
     * @return
     */
    @GetMapping("/restTest/test1")
    String testFeign1(@RequestParam String name);
}
