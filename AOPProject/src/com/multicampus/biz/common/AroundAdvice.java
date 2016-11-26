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
		
		System.out.println(method + "() 메소드 수행에 걸린 시간 : " + 
		(end - start) + "(ms)초");		
		return obj;
	}
}





