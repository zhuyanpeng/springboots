package com.study.www.demo7mybatismore.configure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * MybatisDBcnnncConfig: mappers.cnnnc
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/9/19    18:00
 **/
@Configuration
@MapperScan(basePackages = {"com.study.www.demo7mybatismore.domain.cnnnc.mapper"},sqlSessionFactoryRef = "sqlSessionFactoryDbCnnnc")
public class MybatisDBcnnncConfig {
    @Autowired
    @Qualifier("cnnncDataSource")
    private DataSource cnnncDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryDbCnnnc() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(cnnncDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/cnnnc/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateDbCnnnc() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryDbCnnnc());
        return sqlSessionTemplate;
    }

}
