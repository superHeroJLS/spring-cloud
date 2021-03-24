package com.example.eureka.eurekaclient.applicationprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name", required = false, defaultValue = "jls")String name) {
        return "hi" + name + ", i am from port: " + port;
    }

    @GetMapping("/test")
    public List<Map<String, Object>> test() {
        List<Map<String, Object>> result = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            Map<String, Object> data = new HashMap<>();
            data.put("id", i+1);
            data.put("name", "test name " + i);
            data.put("age", 20+i);
            result.add(data);
        }
        return result;
    }
}
