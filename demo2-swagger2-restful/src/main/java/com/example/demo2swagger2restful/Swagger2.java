package com.example.demo2swagger2restful;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 作用说明：restfuleAPI工具
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-24 0:14
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()//返回apiSelectorBuilder实例用来控制接口的展现情况如下文指定了web，swagger2会扫描该bao下面的所哟controller定义的url并生成文档（若被@ApiIgnore(忽略)指定的请求将不会被暴露）
                .apis(RequestHandlerSelectors.basePackage("com.example.demo2swagger2restful.web"))
                .paths(PathSelectors.any())
                .build();
    }
    //具体信息展现
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("spring boot使用Swagger2构建RESTFUL API").
                description("跟多spring boot相关文章请关注：http://www.baidu.com")
                .termsOfServiceUrl("http://www.baidu.com")
                .contact("程序人生")
                .version("1.0")
                .build();
    }
}
