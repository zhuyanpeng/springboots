package com.study.www.demo19security.config;

import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-10-31 00:04
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends SpringBootWebSecurityConfiguration {
}
