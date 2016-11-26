package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) 클래스
@Repository
public class UserDAOIbatis {
	@Autowired
	private SqlMapClientTemplate ibatis;

	// CRUD 기능 메소드
	// 회원 등록
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Ibatis 기반으로 getUser() 기능 처리");
		return (UserVO) ibatis.queryForObject("getUser", vo);
	}
}





