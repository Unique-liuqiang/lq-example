/*
package aop.mytransaction;

import aop.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;

*/
/**
 * 使用aop完成自定义注解事务的实现
 *//*

@Aspect
@Component
public class AopExtTransation {


    @Autowired
    private TransactionUtils transactionUtils;



    @Around("execution(* aop.service.*.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ExtTransation extTransation = getMethodExtTransaction(proceedingJoinPoint);
        TransactionStatus transactionStatus = null;
        if(extTransation!=null){
              System.out.println("开启事务");
             transactionStatus = transactionUtils.begin();
        }
        proceedingJoinPoint.proceed();
        if(transactionStatus!=null){
            transactionUtils.commit(transactionStatus);
            System.out.println("结束事务");
        }
    }



    public ExtTransation getMethodExtTransaction(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        //方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        //获取目标对象
        Class<?> classTarget = proceedingJoinPoint.getTarget().getClass();
        //获取目标对象类型
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Class[] parameterTypes = signature.getParameterTypes();

        Method method = classTarget.getMethod(methodName, parameterTypes);
        ExtTransation declaredAnnotation = method.getDeclaredAnnotation(ExtTransation.class);
        return  declaredAnnotation;
    };
    
    public static void main(String[] args){

    }
}
*/
