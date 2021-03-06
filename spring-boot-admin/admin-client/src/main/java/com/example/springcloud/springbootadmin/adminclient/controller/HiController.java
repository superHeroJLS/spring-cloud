package com.example.springcloud.springbootadmin.adminclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(@RequestParam(required = false, defaultValue = "jls") String name) {
        return "hi, " + name + "i am lucy and from port " + port;

    }

    private String hiError(String name) {
        return "hi, " + name + "sorry, error!";
    }

}
