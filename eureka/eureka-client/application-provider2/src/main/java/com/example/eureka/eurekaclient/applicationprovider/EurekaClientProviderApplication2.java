package com.example.eureka.eurekaclient.applicationprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientProviderApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProviderApplication2.class);
    }
}
