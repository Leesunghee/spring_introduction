package com.ready2die.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
public class MethodStartLoggingAspect {

    @Before("execution(* *..*ServiceImpl.*(..))")
    public void startLog(JoinPoint jp) {
        System.out.println("메서드 시작: " + jp.getSignature());
    }
}

