package com.codeygym.book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {
    private int count = 1;
    @Pointcut("within(com.codeygym.book.controller.*)")
    public void callMethod(){}

    @Before("callMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        int c = count++;
        System.out.println("Bạn đang truy cập vào phương thức " + joinPoint.getSignature().getName()
                +" vào lúc: " + LocalDateTime.now() + ". Số lần truy cập là: " + c);
    }
}
