package com.example.stationdeski.Configs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j

public class PerformanceAspect {


    @Before("execution(* com.example.stationdeski.services.ISkieurService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method before " + name + " : ");
    }

    @After("execution(* com.example.stationdeski.services.ISkieurService.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method after " + name + " : ");
    }

   /*@Around("execution(* com.example.stationdeski.services.ISkieurService.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }*/

}
