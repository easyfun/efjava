package com.ef.eftest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ef.eftest.common.Tool;
import com.ef.eftest.dao.UserDao;
import com.ef.eftest.entity.User;
import com.ef.eftest.service.UserService;
import com.ef.eftest.service.UserService2;

@Service
public class UserServiceImpl2 implements UserService2 {
	@Resource
//	@Autowired
//	@Qualifier("userDao")
	private UserDao userDao;
	
	public void findUserById(int id) {
		Tool.wait(Tool.before_wait_seconds);
		User userInfo=userDao.findUserById(id);
		System.out.println(userInfo);
		Tool.wait(Tool.after_wait_seconds);
		
//		findUserByName("caocao");
	}

	public void findUserByName(String name) {
		Tool.wait(Tool.before_wait_seconds);
		User userInfo=userDao.findUserByName(name);
		System.out.println(userInfo);
		Tool.wait(Tool.after_wait_seconds);
	}

}
