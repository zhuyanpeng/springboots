#springboot的简单使用以及properties和Value注解的简单使用

#1、涉及注解
###1、@ConfigurationProperties 
* 1、可以放在类上需要与@Component结合使用可以接上@PropertySource来指定properties文件,其有Prefix指定引入的头其会将配置文件中的值注入到该实体创建之时。
```java
@Component
@ConfigurationProperties(prefix = "user")
@PropertySource(value = "classpath:user.properties")//目录源配置
public class UserDto {
    private String names;
    private String author;
    private int age;
    省略GET\SET
}
```

* 2、或者与@Bean连用进行注入时候直接创建。
```java
@Bean
@ConfigurationProperties(prefix="user")
public UserDto userDto(){
    return new UserDto();
}
```

###2、`@EnableConfigurationProperties`用来开启`@ConfigurationProperties`注解时用的，当你采用1-1的通过`@Component`的方式创建Bean的时候在Controller中使用是无法使用的必须使用EnableConfigurationProperties来进行激活.
```java
@RestController
@EnableConfigurationProperties({BookBean.class,UserDto.class})
public class BookControl {
    @Autowired
    private BookBean book;
    @Autowired
    private UserDto userDto;
    @GetMapping("/book1")
    public String book(){
        return "又在看黄书"+book.getName()+userDto.getNames();
    }


}

```