package com.ef.eftest.service.impl;

import com.ef.eftest.common.Tool;
import com.ef.eftest.dao.UserDao;
import com.ef.eftest.entity.User;
import com.ef.eftest.service.UserService;
import com.ef.eftest.service.UserService2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
//	@Autowired
//	@Qualifier("userDao")
	private UserDao userDao;
	
	@Autowired
	private UserService2 service2;
	
	
	/*
	 * 对于REQUIRES_NEW的事务传播，一个对象的一个连接点调用这个对象的另一个连接点，
	 * 是不是这个对象的每个连接点都会新建一个事务？
	 * 
	 * 根据测试结果看到，只创建了一个事务
	 */
	public void findUserById(int id) {
		Tool.wait(Tool.before_wait_seconds);
		User userInfo=userDao.findUserById(id);
		System.out.println(userInfo);
		Tool.wait(Tool.after_wait_seconds);
		
		findUserByName("caocao");
	}

	public void findUserByName(String name) {
		Tool.wait(Tool.before_wait_seconds);
		User userInfo=userDao.findUserByName(name);
		System.out.println(userInfo);
		Tool.wait(Tool.after_wait_seconds);
	}

	public void test2Tx() {
		Tool.wait(Tool.before_wait_seconds);
		User userInfo=userDao.findUserById(1);
		System.out.println(userInfo);
		Tool.wait(Tool.after_wait_seconds);
		
		service2.findUserByName("caocao");
//		service2.findUserById(2);
	}

	@Override
	public UserService2 getService2() {
		return service2;
	}


}
