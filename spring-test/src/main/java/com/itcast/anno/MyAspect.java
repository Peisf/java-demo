package com.itcast.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {

    //配置前置增强
    //@Before("execution(* com.itcast.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强...");
    }

    public void afterReturning(){
        System.out.println("后置增强...");
    }

    //ProceedingJoinPoint 正在执行的连接点 === 切点
    @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强...");
        //切点方法
        pjp.proceed();
        System.out.println("环绕后增强...");
    }

    public void afterThrowing(){
        System.out.println("异常抛出增强...");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("最终增强...");
    }


    //定义切点表达式
    @Pointcut("execution(* com.itcast.anno.*.*(..))")
    public void pointcut(){}

}
