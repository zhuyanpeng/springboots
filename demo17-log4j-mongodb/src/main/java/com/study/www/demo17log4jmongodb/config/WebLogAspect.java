package com.study.www.demo17log4jmongodb.config;

import com.mongodb.BasicDBObject;
import com.sun.xml.internal.ws.client.RequestContext;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * WebLogAspect: webAop切面
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/12    18:58
 **/
@Aspect
@Order(1)
@Configuration
public class WebLogAspect {

    private Logger logger = Logger.getLogger("mongodb");

    @Pointcut("execution(public * com.study.www.demo17log4jmongodb.web..*(..))")
    public void webLog(){}

    private BasicDBObject getBasicDBObject(HttpServletRequest request,JoinPoint joinPoint){
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.append("requestURL",request.getRequestURI());
        basicDBObject.append("requestURI", request.getRequestURI());
        basicDBObject.append("queryString", request.getQueryString());
        basicDBObject.append("remoteAddr", request.getRemoteAddr());
        basicDBObject.append("remoteHost", request.getRemoteHost());
        basicDBObject.append("remotePort", request.getRemotePort());
        basicDBObject.append("localAddr", request.getLocalAddr());
        basicDBObject.append("localName", request.getLocalName());
        basicDBObject.append("method", request.getMethod());
        basicDBObject.append("headers", getHeadersInfo(request));
        basicDBObject.append("parameters", request.getParameterMap());
        basicDBObject.append("classMethod", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        basicDBObject.append("args", Arrays.toString(joinPoint.getArgs()));
        return basicDBObject;
    }
    /**
     * 获取头信息
     *
     * @param request
     * @return
     */
    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        BasicDBObject basicDBObject = getBasicDBObject(request,joinPoint);
        logger.info(basicDBObject);
    }
}
