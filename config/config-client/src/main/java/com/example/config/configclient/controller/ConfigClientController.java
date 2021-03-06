package com.example.config.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cc")
@RefreshScope
public class ConfigClientController {
    @Value("${foo}")
    private String foo;

    @GetMapping("/foo")
    public String foo() {
        return foo;
    }

}
