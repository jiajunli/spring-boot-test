package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 10108 on 2017/12/17.
 */
@Component
@Aspect
public class AscpetLog {
    private final static Logger logger = LoggerFactory.getLogger(AscpetLog.class);
    /**
     * 切片
     */
    @Pointcut(value ="execution(public * com.example.demo.test.PersonController.* (..))" )
    public void pointcut(){

    }

    @Before("pointcut()")  //引用切片表达式
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        logger.info("url:{}",httpServletRequest.getRequestURL());
        logger.info("method:{}",httpServletRequest.getMethod());
        logger.info("class:{}",joinPoint.getSignature().getDeclaringTypeName() +"."+joinPoint.getSignature().getName());
        Object[] objects = joinPoint.getArgs();
        for(Object object:objects){
            logger.info("args:{}",object);
        }
        logger.info("method before ....");
    }

    @After("pointcut()")
    public void after(){
        logger.info("method execute finish ...");
    }
    @AfterReturning(returning = "object",pointcut = "pointcut()")
    public void afterReturn(Object object){
        logger.info("response：{}",object);
    }
}
