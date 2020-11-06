package com.example.eureka.eurekaclient.eurekafeign.service;

import com.example.eureka.eurekaclient.eurekafeign.feign.EurekaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {
    @Autowired
    private EurekaFeignClient eurekaFeignClient;

    public String sayHi(String name) {
        return eurekaFeignClient.sayHiFromEurekaClientProvider(name);
    }



}
