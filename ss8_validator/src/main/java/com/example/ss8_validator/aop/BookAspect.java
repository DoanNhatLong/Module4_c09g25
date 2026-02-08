//package com.example.ss8_validator.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Aspect
//@Component
//public class BookAspect {
//
//    @AfterReturning(
//            pointcut = "execution(* com.example.ss8_validator.service.IBookService.borrow(..))",
//            returning = "code"
//    )
//    public void logBorrow(JoinPoint joinPoint, Object code) {
//        Object[] args = joinPoint.getArgs();
//        Long bookId = (Long) args[0];
//        System.out.println("Book ID: " + bookId);
//        System.out.println("Code: " + code);
//        System.out.println("Time: " + LocalDateTime.now());
//    }
//
//    @After("execution(* com.example.ss8_validator.controller.BookController.check(..))")
//    public void logReturn(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        String code = (String) args[0];
//
//        System.out.println("Code: " + code);
//        System.out.println("Time: " + LocalDateTime.now());
//    }
//
//    @AfterThrowing(
//            pointcut = "execution(* com.example.ss8_validator..*(..))",
//            throwing = "ex"
//    )
//    public void logException(Exception ex) {
//        System.out.println("ERROR ");
//        System.out.println("Message: " + ex.getMessage());
//        System.out.println("Time: " + LocalDateTime.now());
//    }
//
//}
