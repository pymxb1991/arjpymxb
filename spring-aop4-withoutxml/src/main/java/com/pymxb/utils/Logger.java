package com.pymxb.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 *
 *  注意，在使用注解 @Before   @AfterReturning  @AfterThrowing @After 配置通知类型时，
 *       发现通知执行顺序有问题（最终通知总在 后置通知，异常通知前面，）调用顺序有问题
 *
 * ！！！！！！！！！！！！！！！！！！！！！！
 *   所以建议spring 使用注解配置AOP 时，直接用环绕通知 ！！！！！！！！
 *！！！！！！！！！！！！！！！！！！！！！！！！！！！
 *
 *
 *
 */
@Component("logger")
@Aspect // 表示当前类是一个切面类
public class Logger {

    @Pointcut("execution( * com.pymxb.service.impl.*.*(..))")
    private  void pt1(){

    }
    /**
     * 前置通知
     */
    //@Before("pt1()")
    public  void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
   //@AfterReturning("pt1()")
    public  void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }
    /**
     * 异常通知
     */
   // @AfterThrowing("pt1()")
    public  void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
   // @After("pt1()")
    public  void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

   @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object returnValue = null;
        try {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了。。。前置");

             returnValue = pjp.proceed();////明确调用业务层方法（切入点方法）

            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了。。。后置");
            return  returnValue;
        } catch (Throwable throwable) {
            //throwable.printStackTrace();
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了。。。异常");

            throw  new RuntimeException(throwable) ;
        }finally {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了。。。最终");
        }
    }
}
