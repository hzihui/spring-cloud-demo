package com.hzihui.cloud.provider.controller;

import com.hzihui.cloud.provider.config.IpConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HZI.HUI
 * @date 2019/9/11 10:49
 */
@RestController
@RequestMapping("restTest")
@RequiredArgsConstructor
public class RestTemplateTestController {

    private final IpConfiguration ipConfiguration;

    @RequestMapping("test1")
    public String test1(String name){
        System.out.println("调用了ME" + ipConfiguration.getPost());
        return "Hi~ "+name+ "您好！这里是provider服务接口test1";
    }
}
