package com.example.eureka.eurekaclient.applicationprovider.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {

    /**
     * 使用RestTemplate消费服务
     * 使用 @LoadBalanced 让 RestTemplate 结合 Ribbon 在消费服务开启负载均衡功能
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
