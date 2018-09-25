package com.lst.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AroundAop {


    @Around(value="(execution(* com.lst.service..*(..))) && @annotation(check)")
    public Object around(ProceedingJoinPoint jp,Check check) throws Throwable {

        System.out.println("环绕通知");
        Object proceed = jp.proceed();
        System.out.println("执行环绕完毕"
                + "");
        return proceed;
    }

}
