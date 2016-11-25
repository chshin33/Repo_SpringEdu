package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 4. Service ���� Ŭ����
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAOSpring userDAO;

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}