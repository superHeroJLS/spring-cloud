package com.example.springcloud.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //开启Swagger2功能
public class Swagger2Config {

    /**
     * 在配置类Swagger2中需要注入一个Docket的Bean，该Bean包含了apiInfo，即基本API文档的描述信息，以及包扫描的基本包名等信息
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springcloud"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SpringBoot整合Swagger构建api文档")
                .description("简单优雅的Restful风格")
                .termsOfServiceUrl("https://www.jiangls.xyz")
                .version("1.0")
                .build();
    }

}
