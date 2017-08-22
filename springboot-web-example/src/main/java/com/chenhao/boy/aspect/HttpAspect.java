package com.chenhao.boy.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 陈浩
 * @Date 2017/8/22 14:55
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.chenhao.boy.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(){
        logger.info("1111111111");
        //url、method、ip、类方法、参数
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}",request.getRequestURL());

        logger.info("method={}",request.getMethod());

        logger.info("ip={}",request.getRemoteAddr());

        //logger.info("class_method={}",joinPoint.getSignature.getDeclaringTypeName());

    }

    @After("log()")
    public void doAfter(){
       logger.error("2222222222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
