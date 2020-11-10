package com.example.eureka.eurekaclient.eurekafeign.feign.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static java.util.concurrent.TimeUnit.SECONDS;


@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer() {
        //FeignClient 的请求失败重试的策略，重试问隔为100 毫秒，最大重试时间为1 秒，重试次数为5 次。
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }
}
