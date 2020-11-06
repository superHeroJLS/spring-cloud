package com.example.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customConfig")
@EnableConfigurationProperties(CustomConfigBean.class)
public class CustonConfigBeanController {

    @Autowired
    CustomConfigBean customConfigBean;

    @GetMapping("/getConfig")
    public String getConfig() {
        return customConfigBean.getName() + customConfigBean.getAge();
    }

}
