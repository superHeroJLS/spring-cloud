package com.example.eureka.eurekaclient.applicationprovider.controller;

import com.example.eureka.eurekaclient.applicationprovider.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cr")
public class ConsumerWithRibbonController {

    @Autowired
    private RibbonService ribbonService;

    //测试Ribbon的核心类LoadBalancerClient（Ribbon是服务消费者端的负载均衡器）
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name", required = false, defaultValue = "jls")String name) {
        return ribbonService.hi(name);
    }


    @GetMapping("/testRibbon")
    public String testRibbon() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-provider");
        return "host: " + serviceInstance.getHost()
                + ", port: " + serviceInstance.getPort()
                + ", serviceId: " + serviceInstance.getServiceId()
                + ", uri: " + serviceInstance.getUri();
    }

    @GetMapping("/test")
    public String test() {
        return "test ok";
    }


}
