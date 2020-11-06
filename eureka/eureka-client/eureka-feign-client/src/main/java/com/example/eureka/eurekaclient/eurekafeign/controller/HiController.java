package com.example.eureka.eurekaclient.eurekafeign.controller;

import com.example.eureka.eurekaclient.eurekafeign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hc")
public class HiController {
    @Autowired
    private HiService hiService;

    @GetMapping("/sayHi")
    public String sayHi(@RequestParam(value = "name", required = false, defaultValue = "jls")String name) {
        return hiService.sayHi(name);
    }
}
