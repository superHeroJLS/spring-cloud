package com.example.eureka.eurekaclient.applicationprovider.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * RestTempalte + Ribbon + Hystrix 消费远程服务
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 这里的eureka-client-provider是spring.application.name的值。
     * eureka-client-provider服务有2个实例，端口分别为8762、8763。
     *
     * 注解@HystrixCommand表示启用熔断器动能，属性fallbackMethod表示fallback逻辑，最好返回静态字符串，不处理复杂的逻辑，也不用远程调用其他服务，
     * 方便自行快速失败，释放线程资源。
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name) {
        return restTemplate.getForObject("http://eureka-client-provider/provider/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",eureka-client-provider has error!";
    }
}
