package com.hzihui.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author HZI.HUI
 * @date 2019/9/11 10:51
 */
@RestController
@RequestMapping("restConsumer")
public class RestTemplateTestController {
    @Autowired
    private  DiscoveryClient discoveryClient;
    @Qualifier(value = "restTemplate")
    @Autowired
    private  RestTemplate restTemplate;
    @Qualifier(value = "loadBalanced")
    @Autowired
    private  RestTemplate loadBanlanced;

    /**
     * 无负载均衡调用
     * @param name
     * @return
     */
    @RequestMapping("test")
    public String test1(String name){
        System.out.println("这是消费者test1");
        String url = getServiceInstanceUrl("spring-cloud-provider");
        url = url+"/restTest/test1?name={1}";
        return restTemplate.getForObject(url,String.class,name);
    }

    /**
     * 负载均衡调用
     * @param name
     * @return
     */
    @RequestMapping("test2")
    public String test2(String name){
        System.out.println("这是消费者test2负载均衡调用");
        String url = "http://spring-cloud-provider/restTest/test1?name={1}";
        return loadBanlanced.getForObject(url,String.class,name);
    }


    /**
     * 获取server实例
     * @return
     */
    private String getServiceInstanceUrl(String serverName){
        List<ServiceInstance> instances = discoveryClient.getInstances(serverName);
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://"+host+":"+port;
         return url;
    }

}
