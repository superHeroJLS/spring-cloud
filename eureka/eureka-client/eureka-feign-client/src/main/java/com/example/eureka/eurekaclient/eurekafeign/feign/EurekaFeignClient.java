package com.example.eureka.eurekaclient.eurekafeign.feign;

import com.example.eureka.eurekaclient.eurekafeign.feign.config.FeignConfig;
import com.example.eureka.eurekaclient.eurekafeign.feign.hystrix.HiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ＠FeignClient注解来声明一个FeignClient,其中value为远程调用其他服务的服务名，FeignConfig.class为FeignClient的配置类。
 * FeignClient 结合了Ribbon的负载均衡能力，自动选择合适的微服务实例。
 * 这里的 interface EurekaFeignClient 不需要实现类。
 * 注解@FeignClient中fallback属性表示熔断处理逻辑类。
 */
@FeignClient(value = "eureka-client-provider", configuration = FeignConfig.class, fallback = HiHystrix.class)
public interface EurekaFeignClient {


    /**
     * 该方法通过Feign来远程调用eureka-client-provider服务 "/provider/hi" 的API接口（Controller中的接口）
     * 这里相当于发起一个HTTP请求
     */
    @GetMapping("/provider/hi")
    String sayHiFromEurekaClientProvider(@RequestParam("name")String name);
}
