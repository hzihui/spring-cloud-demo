package com.hzihui.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置中心测试
 * @author HZI.HUI
 * @date 2019/9/11 18:39
 */
@RestController
@RequestMapping("config")
public class ConfigController {

    @Value("${test}")
    private String testName;

    @RequestMapping("testConfig")
    public String testConfig(){
        return this.testName;
    }
}
