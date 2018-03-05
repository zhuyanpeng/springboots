package com.study.cn.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: : 切面
 * @date :Create in  2018/3/5- 13:56
 * @Version: V1.0
 * @Modified By:
 **/
//定义为切面类
@Aspect
@Configuration
public class WebAspect {
    @Autowired
    CustomAccessParse customAccessParse;
    //定义一个切点
    @Pointcut("execution(public * com.study.cn.web..*.*(..))")
    public void aspect(){}

    @Around(value = "aspect()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        Class targetClass = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        try {
            ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpSession session = attributes.getRequest().getSession();
            Object userId = session.getAttribute("loginUser");
            //在此模拟已经登陆所以userId可以获得到
            if (userId==null){
                userId="100000001";
            }
            boolean release = customAccessParse.isRelease(targetClass, methodName,(String)userId);
            if (release){
                //执行切入点的方法 必须把参数重新传回,不然会导致方法没有任何返回值
                Object proceed = joinPoint.proceed(joinPoint.getArgs());
                return proceed;
            }else {
                return "no_permissions";
            }
        } catch (Throwable e) {
            return "error";
        }
    }
}
