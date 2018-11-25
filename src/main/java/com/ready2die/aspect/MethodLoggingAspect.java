package com.ready2die.aspect;

import com.ready2die.spring_introduction.UserServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLoggingAspect {
    @Around("execution(* *..*ServiceImpl.*(String)) && target(userServiceImpl) && args(input)")
    public Object log(ProceedingJoinPoint jp, UserServiceImpl userServiceImpl, String input) throws Throwable {
        System.out.println("메소드 시작: " + jp.getSignature());
        try {
            // 프락시가 입혀지기 전의 원본 대상 개체를 가져온다.
            Object targetObject = jp.getTarget();

            userServiceImpl.findOne(input);

            // 프락시를 가져온다.
            Object thisObject = jp.getThis();

            // 인수를 가져온다.
            Object[] args = jp.getArgs();

            Object result = jp.proceed();
            System.out.println("메서드 정상 종료: " + jp.getSignature() + " 반환값=" + result);
            return result;

        } catch (Exception e) {
            System.out.println("메소드 비정상 종료: " + jp.getSignature());
            e.printStackTrace();
            throw e;
        }
    }

}
