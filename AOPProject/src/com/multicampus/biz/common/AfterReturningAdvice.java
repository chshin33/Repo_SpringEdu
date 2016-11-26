package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.multicampus.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {

	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println("##########################");
				System.out.println(user.getName() + "관리자님 환영합니다.");
				System.out.println("##########################");
			}
		}
		
		System.out.println("[사후 처리] " + method + 
			"() 메소드 수행 후 리턴 값 : " + returnObj.toString());
	}
}
