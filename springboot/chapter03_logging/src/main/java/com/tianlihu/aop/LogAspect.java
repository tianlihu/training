package com.tianlihu.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.lang.reflect.Method;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(public * com.tianlihu.controller.*Controller.*(..))")
    public void controllerLogPointcut() {
    }

    @Around("controllerLogPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Logger log = LoggerFactory.getLogger(method.getDeclaringClass());
        Object[] args = joinPoint.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object proceed = joinPoint.proceed();

            log.debug(method.getName() +"方法被执行，参数是：\n{}\n执行结果是：\n{}\n", mapper.writeValueAsString(args), mapper.writeValueAsString(proceed));

            return proceed;
        } catch (Throwable e) {
            StringWriter writer = new StringWriter();
            log.error(method.getName() +"方法被执行，参数是：\n"+mapper.writeValueAsString(args)+"\n", e);
            throw e;
        }
    }
}
