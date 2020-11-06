package com.example.eureka.eurekaclient.eurekafeign.feign;

import com.example.eureka.eurekaclient.eurekafeign.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ＠FeignClient注解来声明一个FeignClient,其中value为远程调用其他服务的服务名，FeignConfig.class为FeignClient的配置类
 */
@FeignClient(value = "eureka-client-provider", configuration = FeignConfig.class)
public interface EurekaFeignClient {


    /**
     * 该方法通过Feign来调用eureka-client-provider服务 "hi" 的API接口（Controller中的接口）
     * 这里相当于发起一个HTTP请求
     */
    @GetMapping("/provider/hi")
    String sayHiFromEurekaClientProvider(@RequestParam("name")String name);
}
