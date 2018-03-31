#动态修改logger的级别
###1、logger的动态修改是运用在springboot1.5版本之上的
```java 
  <parent>
      	<groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.10.RELEASE</version>
       <relativePath/> <!-- lookup parent from repository -->
  </parent>
```
###2、可以去url的**logger** 的路径去查看当前信息也可以去细化指定查看如下
```java
 http://localhost:8080/loggers/com.cnnnc.www.web.LoggerController
{
    "configuredLevel": "null",
    "effectiveLevel": "DEBUG"
}
```


###3、可以使用post链接去修改当前的访问**loggers/com.cnnnc.www.web.LoggerController
```java
java  {
              "configuredLevel": "DEBUG",
              "effectiveLevel": "INFO"
          }

```
