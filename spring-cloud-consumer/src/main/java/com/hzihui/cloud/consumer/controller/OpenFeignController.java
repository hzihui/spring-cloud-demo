package com.hzihui.cloud.consumer.controller;

import com.hzihui.cloud.consumer.inteface.FeignTestInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HZI.HUI
 * @date 2019/9/11 12:03
 */
@RestController
@RequestMapping("openFeign")
@RequiredArgsConstructor
public class OpenFeignController {

    private final FeignTestInterface feignTestInterface;

    @GetMapping("openFeignTest")
    public String openFeignTest(String name){
        System.out.println("使用openfeign调用");
        return feignTestInterface.testFeign1(name);
    }
}
