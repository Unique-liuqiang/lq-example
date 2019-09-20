package aop;

import aop.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AopLog {
  // 前置通知
    @Before("execution(* service.UserService.add(..))")
    public void begin() {
        System.out.println("前置通知");
    }

    // 后置通知
    @After("execution(* service.UserService.add(..))")
    public void commit() {
        System.out.println("后置通知");
    }

    // 运行通知
    @AfterReturning("execution(* service.UserService.add(..))")
    public void returning() {
        System.out.println("运行通知");
    }


    // 异常通知
    @AfterThrowing("execution(* service.UserService.add(..))")
    public void afterThrowing() {
        System.out.println("异常通知");
    }

    // 环绕通知
    @Around("execution(* service.UserService.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束");
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.add();
    }

}




