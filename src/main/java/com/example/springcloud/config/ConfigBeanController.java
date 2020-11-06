package com.example.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configBean")
@EnableConfigurationProperties(ConfigBean.class)
public class ConfigBeanController {

    @Autowired
    ConfigBean configBean;

    @GetMapping("/getConfig")
    public String getConfig() {
        return configBean.getGreeting() + "-" + configBean.getName() + "-" + configBean.getUuid();
    }

}
