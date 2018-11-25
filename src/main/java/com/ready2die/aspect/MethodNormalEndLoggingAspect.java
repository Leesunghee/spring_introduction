package com.ready2die.aspect;

import com.ready2die.spring_introduction.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
public class MethodNormalEndLoggingAspect {
    @AfterReturning(value = "execution(* *..*ServiceImpl.*(..))", returning = "user")
    public void endLog(JoinPoint joinPoint, User user) {
        System.out.println("메소드 정상 종료: " + joinPoint.getSignature() + "반환값=" + user) ;
    }
}
