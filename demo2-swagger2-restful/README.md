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
                description("主页入口：http://www.baidu.com")//副标题可以接上地址
                .contact("程序人生")//创建人
                .version("1.0")//版本
                .build();
    }
```
##三、涉及注解
<table>
  <tr>
    <th width=30%, bgcolor="#FFEFDB">注解</th>
    <th width=70%, bgcolor="#FFEFDB">作用</th>
  </tr>
  <tr>
    <td bgcolor="#AEEEEE"> @ApiOperation</td>
    <td bgcolor="#AEEEEE"> 描述一个类的一个方法，或者说一个接口。拥有value（方法简述）和notes（实施说明）属性</td>
  </tr> 
   <tr>
    <td bgcolor="#AEEEEE"> @ApiImplicitParam</td>
    <td bgcolor="#AEEEEE"> 描述一个方法的入参的。拥有name（参数code）、nvalue(参数含义)、required(是否必须)、defaultValue（默认值）和dataType(属性类型可以是实体若是实体将会展现实体类所有的属性)多个属性</td>
  </tr>
    <tr>
      <td bgcolor="#AEEEEE">@ApiImplicitParams</td>
      <td bgcolor="#AEEEEE">描述一个方法的多个入参的内部嵌套多个@ApiImplicitParam</td>
    </tr> 
       <tr>
      <td bgcolor="#AEEEEE">@ApiIgnore</td>
      <td bgcolor="#AEEEEE">注解忽略这个方法</td>
    </tr>   
     <tr>
      <td bgcolor="#AEEEEE">@ApiResponses </td>
      <td bgcolor="#AEEEEE">描述一个方法的回参的http响应码的，描述不同返回的响应码代表的含义是什么,内部嵌套多个@ApiResponse</td>
    </tr>  
     <tr>
      <td bgcolor="#AEEEEE">@ApiResponse </td>
      <td bgcolor="#AEEEEE">描述一个方法的回参的http响应码的，拥有code（响应码）和message（响应信息）等字段</td>
    </tr>
</table>