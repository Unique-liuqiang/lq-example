/*
package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
@Aspect
public class AopTransaction {

    @Autowired
    private TransactionUtils   transactionUtils;

    @AfterThrowing("execution(* aop.service.UserService.add(..))")
    public void afterThrowing(){
          //获取当前事务
        System.out.println("回滚事务");
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
    @Around("execution(* aop.service.UserService.add(..))")
   public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("开启事务");
        TransactionStatus transactionStatus = transactionUtils.begin();
        proceedingJoinPoint.proceed();// 如果调用方法抛出溢出不会执行后面代码
        //调用方法之后执行

        transactionUtils.commit(transactionStatus);

    }
}
*/
