package com.study.cn.config;

import com.study.cn.enums.AccessEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义权限细粒度注解
 * @date :Create in  2018/3/5- 11:27
 */
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAccess {
    AccessEnum[] value() default {};
}
