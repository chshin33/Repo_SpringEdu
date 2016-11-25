package com.multicampus.biz.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring IoC 컨테이너 구동
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring IoC 컨테이너로부터 UserServiceImpl 객체 Lookup.
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. Lookup한 객체 테스트
		UserVO vo = new UserVO();
		vo.setId("aaa");
		vo.setPassword("aaa");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}
	}
}
