package com.example.www.demo6moredatasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 作用说明：多数据源配置
 *
 * @author mirror.zhuyanpeng
 * @create 2017-09-06 0:39
 **/
@Configuration
public class DataSourceConfig {
    @Bean(name="primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(){
    return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")//根据名字注入如果autowrid书写的名字是等于Qualifier的话会被注
    @Primary//必须使用的 在被autoWrid调用时如果有两个compment的话加上这个的会被首选
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public  DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name="primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean(name="secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}

