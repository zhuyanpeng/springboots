package com.study.www.demo16aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * WebLogAspect: 对于web层级的切面编程
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/12    9:06
 **/
@Aspect //将其定义为切面类
@Configuration
public class WebLogAspect {
    ThreadLocal<Long> startTime=new ThreadLocal<Long>();//不能用long会有同步的问题
    //定义一个切点 之后的所有的切面的方法只需要对此切点做控制
    @Pointcut("execution(public * com.study.www.demo16aop.web..*.*(..))")
    public void webLog(){}

    //切入点前置增强
    @Before(value = "webLog()")
    //@Order(2)//运行等级 切入点的操作，按照从大到小的顺序执行
     /** 如果不进行切点定义也可以写成这样
    * @Before(pointcut="execution(public * com.study.www.demo16aop.web..*.*(..))")
    */
    public void doBefore(JoinPoint joinPoint) {
        //在此举例通过上下文对象获得访问的一些属性
        System.out.println("<<<<<<<<<<<<<2");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //判断是否为Http的
        if(requestAttributes instanceof ServletRequestAttributes){
            System.out.println("---------------------start=====before---------------------");
            ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes)requestAttributes;
            HttpServletRequest request = servletRequestAttributes.getRequest();
            System.out.println("url:"+request.getRequestURI());
            System.out.println("httpMethod:"+request.getMethod());
            System.out.println("ip:"+request.getRemoteAddr());
            System.out.println("class:"+joinPoint.getSignature().getDeclaringTypeName());
            System.out.println("method:"+joinPoint.getSignature().getName());
            System.out.println("入参:"+ Arrays.toString(joinPoint.getArgs()));
            System.out.println("---------------------end=====before---------------------");
        }
    }

    @Before(value = "webLog()")
    @Order(1)//等级标注
    public void doBeforeTime(){
        System.out.println("<<<<<<<<<<<<<2.1");
        startTime.set(System.currentTimeMillis());
    }
    //切入点后置增强
    @After(value = "webLog()")
    @Order(10)
    public void doAfter(){
        //与上文同义
        System.out.println("<<<<<<<<<<<<4");
        System.out.println("运行时间:"+(System.currentTimeMillis()-startTime.get()));
    }
    //切入点后置增强
    @After(value = "webLog()")
    @Order(7)
    public void doAfter2(){
        //与上文同义
        System.out.println("<<<<<<<<<<<<4.1");
        System.out.println("幺儿子!");
    }
    //切入点return之后增强主要用来对返回值进行处理，但是其处理的只是返回值的回参的副本对真正的返回值不做任何改变，要想改变返回值得用强大的Around
    //AfterReturing的order顺序是从小到大的顺序执行的
    @AfterReturning(pointcut = "webLog()",returning = "rtv")
    @Order(3)
    public String doAfterReturning(Object rtv){
        System.out.println("<<<<<<<<<<<<<5");
        return String.valueOf(rtv+"新的風暴已經出現");
    }
    @AfterReturning(pointcut = "webLog()",returning = "rtv")
    @Order(7)
    public Object doAfterReturning1(Object rtv){
        System.out.println("<<<<<<<<<<<<<5.1");
        return rtv;
    }
    //切入点前后增强，近似与before和aterReturning的整合但是她可以决定目标方法在什么时候执行，如何执行，也可以阻断执行
    //Around的顺序在proceed之前按照Order的顺序从大到小的顺序执行之后从小到大的顺序
    @Around(value = "webLog()")
    @Order(3)
    public Object doAround(ProceedingJoinPoint joinPoint) throws  Throwable{
        System.out.println("<<<<<<<<<<<<<1");
        System.out.println("执行切入点之前。。。。。。。。。。。。。。。");
        Object proceed = joinPoint.proceed(joinPoint.getArgs());//执行切入点的方法 必须把参数重新传回,不然会导致方法没有任何返回值
        System.out.println("<<<<<<<<<<<<<3.1");
        System.out.println("执行切入点之后............");
        return String.valueOf(proceed+"新的風暴已經出現");//在此将被处理过的回参Proceed给加工处理之后传出
    }

    @Around(value = "webLog()")
    @Order(1)
    public Object doAround1(ProceedingJoinPoint joinPoint) throws  Throwable{
        System.out.println("<<<<<<<<<<<<<1.1");
        Object proceed = joinPoint.proceed(joinPoint.getArgs());//执行切入点的方法 必须把参数重新传回,不然会导致方法没有任何返回值
        System.out.println("<<<<<<<<<<<<<3");
        return proceed;//在此将被处理过的回参Proceed给加工处理之后传出
    }

//执行顺序为Arround的proceed之前的最先执行,接着是Before前置按照从大到小的顺序，然后是后置的After，最后是返回值的AfterReturning

}
