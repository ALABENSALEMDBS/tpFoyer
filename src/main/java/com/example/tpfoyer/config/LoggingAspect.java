package com.example.tpfoyer.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.example.tpfoyer.services.FoyerServiceImpliment.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In methode " + name +" : ");
    }


    @After("execution(* com.example.tpfoyer.services.FoyerServiceImpliment.*(..))")
    public void logMethodEntryAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out methode " + name +" : ");
    }

   // *********************** Home Worke **********************************
    @Before("execution(* com.example.tpfoyer.services.*.*(..))")
    public void logMethodEntryHomeWork1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In methode " + name +" : ");
    }

    @Before("execution(* com.example.tpfoyer.services.*.retrieve*(..))")
    public void logMethodEntryHomeWork2(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In methode " + name +" : ");
    }


    @Before("execution(* com.example.tpfoyer.services.BlocServiceImpliment.*(..))")
    public void logMethodEntryHomeWork3(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In methode " + name +" : ");
    }



}
