package com.example.eureka.eurekaclient.applicationprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateTestController {

    @GetMapping("/test")
    public String test() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.baidu.com", String.class);
    }
}
