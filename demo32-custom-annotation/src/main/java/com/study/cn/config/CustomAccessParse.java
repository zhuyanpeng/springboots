package com.study.cn.config;

import com.study.cn.enums.AccessEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: : 权限注解解析器
 * @date :Create in  2018/3/5- 14:38
 * @Version: V1.0
 * @Modified By:
 **/
@Component
public class CustomAccessParse {

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 确定是否放行
     * @return
     */
    public  boolean isRelease(Class targetClass,String methodName,String userId) throws NoSuchMethodException {
        CustomAccess annotation=this.parse(targetClass,methodName);
        List<String> list = this.selectCachePermissions(userId);
        AccessEnum[] accesss = annotation.value();
        for (String perCode : list) {
            for (AccessEnum accessEnum : accesss) {
                if (Integer.valueOf(perCode) == accessEnum.getCode()){
                    return true;
                }
            }
        }
        return false;

    }
    
    /**
     *
     * 解析获得权限注解
     * @Author: Administrator.zhuyanpeng
     * @param  :targetClass 类 methodName 方法
     * @Date: 2018/3/5 14:41 
     * @return: java.lang.reflect.Method
     */
    private  CustomAccess parse(Class targetClass, String methodName) throws NoSuchMethodException {
        Method method=targetClass.getDeclaredMethod(methodName,Long.class);
        //判断方法上面是否有权限注解
        if (method.isAnnotationPresent(CustomAccess.class)){
            //得到方法上的注解
            CustomAccess annotation = method.getAnnotation(CustomAccess.class);
            return annotation;
        }
        return null;
    }

    /**
     * 查询缓存获得用户的权限集
     * @return
     */
    private  List selectCachePermissions(String userId){
        String pers = redisTemplate.opsForValue().get(userId);
        String[] split = pers.split(",");
        return Arrays.asList(split);
    }

}
