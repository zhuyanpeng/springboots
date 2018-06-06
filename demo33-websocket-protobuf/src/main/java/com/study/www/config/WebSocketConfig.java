package com.study.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocketConfig: webStocket的EndPoint需要被自行创建
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/12/4    16:32
 **/
@Configuration
public class WebSocketConfig {
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
     * 要注意，如果使用独立的servlet容器，而不是直接使用springboot的内置容器，就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理。
     * @Date: 16:33 2017/12/4
     **/
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

}
