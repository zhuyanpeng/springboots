package com.example.demo3swagger2restful;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 作用说明：restfulApi
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-25 0:03
 **/
//指明其是配置文件
@Configuration
@EnableSwagger2
public class Swagger2Restful {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .apiInfo(this.getApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo3swagger2restful.web"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("这是学习用的swagger2的页面").version("1.0.0V").build();
    }
}
