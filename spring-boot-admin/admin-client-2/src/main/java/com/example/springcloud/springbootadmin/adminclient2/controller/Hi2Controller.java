package com.example.springcloud.springbootadmin.adminclient2.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi2")
public class Hi2Controller {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi2")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi2(@RequestParam(required = false, defaultValue = "jls") String name) {
        return "hi, " + name + "i am lucy and from port " + port;

    }

    private String hiError(String name) {
        return "hi, " + name + "sorry, error!";
    }

}
