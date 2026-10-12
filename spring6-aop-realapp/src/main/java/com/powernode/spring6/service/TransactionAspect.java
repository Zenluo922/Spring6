package com.powernode.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Aspect
public class TransactionAspect {
    @Around("execution(* com.powernode.spring6.service..*(..))")
    public void arounddavice(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("事务开启");
            proceedingJoinPoint.proceed();
            System.out.println("事务结束");
        } catch (Throwable e) {
            System.out.println("事务回滚");
        }
    }
}
