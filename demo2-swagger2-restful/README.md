#springboot整合Swagger2进行在线文档的测试

##一、依赖
```java
<dependency>
    <groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
</dependency>
```
##二、编写配置类
```java
@Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo2swagger2restful.web"))//返回apiSelectorBuilder实例用来控制接口的展现情况如下文指定了web，swagger2会扫描该bao下面的所有的controller定义的url并生成文档（若被@ApiIgnore(忽略)指定的请求将不会被暴露）
                .paths(PathSelectors.any())
                .build();
    }
    //具体信息展现
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("spring boot使用Swagger2构建RESTFUL API类型的API文档").
                description("主页入口：http://www.baidu.com")//副标题可以接上地址其会触发termsOfServiceUrl中的地址
                .termsOfServiceUrl("http://www.baidu.com")
                .contact("程序人生")//创建人
                .version("1.0")//版本
                .build();
    }
```
##三、涉及注解
|注解|作用|
|-|:-:|
|@Api|表述类的作用的一般放在Controller的上面|