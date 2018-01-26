package com.study.www.config;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: 自动imysql控件原因是因为Jpa默认用的hibernate的方言latin1
 *
 * @outhor Administrator
 * @create 2017-11-14 06:07
 */
@Configuration
public class MySQL5DialectUTF8 extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }



}
