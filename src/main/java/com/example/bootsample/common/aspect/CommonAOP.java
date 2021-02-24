package com.example.bootsample.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class CommonAOP {

    private static final Logger logger = LoggerFactory.getLogger(CommonAOP.class);

    @Around("execution(* com.example.bootsample.biz.member.controller.MemberController.*(..)) || "
                + "execution(* com.example.bootsample.biz.file.controller.FileController.*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable{

        logger.info("========== CommonAOP.logging Start ==========");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        // AOP 가 적용된 메소드를 수행하고 리턴되는 데이터 담기
        Object result = joinPoint.proceed();

        logger.info("Request URL : " + request.getRequestURL());

        logger.info("========== CommonAOP.logging End ==========");

        return result;
    }
}
