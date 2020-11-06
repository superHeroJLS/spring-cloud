package com.example.eureka.eurekaclient.applicationprovider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 这里的eureka-client-provider是spring.application.name的值
     * eureka-client-provider服务有2个实例，端口分别为8762、8763
     * @param name
     * @return
     */
    public String hi(String name) {
        return restTemplate.getForObject("http://eureka-client-provider/provider/hi?name=" + name, String.class);
    }
}
