package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//@Service
@Aspect
public class AroundAdvice {      
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		Object obj = null;
		
		long start = System.currentTimeMillis();		
		obj = pjp.proceed();		
		long end = System.currentTimeMillis();
		
		System.out.println(method + "() �޼ҵ� ���࿡ �ɸ� �ð� : " + 
		(end - start) + "(ms)��");		
		return obj;
	}
}





