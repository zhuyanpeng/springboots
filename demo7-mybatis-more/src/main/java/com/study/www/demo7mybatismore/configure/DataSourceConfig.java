package com.study.www.demo7mybatismore.configure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * DataSourceConfig:
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/9/19    16:15
 **/
@Configuration
public class DataSourceConfig {
    @Bean(name="dbstkDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.dbstk")
    public DataSource dbstkDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="cnnncDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cnnnc")
    public DataSource cnnncDataSource(){
        return DataSourceBuilder.create().build();
    }
}
