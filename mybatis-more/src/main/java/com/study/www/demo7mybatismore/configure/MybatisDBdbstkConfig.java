package com.study.www.demo7mybatismore.configure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

/**
 * MybatisDBdbstkConfig: dbstk
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/9/19    16:41
 **/
@Configuration
@MapperScan(basePackages = {"com.study.www.demo7mybatismore.domain.dbstk.mapper"},sqlSessionFactoryRef = "sqlSessionFactoryDbStk")
public class MybatisDBdbstkConfig {
    @Autowired
    @Qualifier("dbstkDataSource")
    private DataSource dbstkDataSource;

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryDbStk() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dbstkDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/dbstk/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplateDbStk() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryDbStk());
        return sqlSessionTemplate;
    }
}
