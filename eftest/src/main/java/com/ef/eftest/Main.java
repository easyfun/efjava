package com.ef.eftest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ef.eftest.service.UserService;


public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
		context.start();
		
		/*
		 * 使用了Java的动态代理技术，必须用接口类型 
		 */
//		UserServiceImpl userServiceImpl = context.getBean(UserServiceImpl.class);
		UserService userService=(UserService)context.getBean("userServiceImpl");
		
		
		
		/*
		 * 对于REQUIRES_NEW的事务传播，一个对象的一个连接点调用这个对象的另一个连接点，
		 * 是不是这个对象的每个连接点都会新建一个事务？
		 * 
		 * 根据测试结果看到，只创建了一个事务
		 * 
		 * 深入源码看是否是这样？
		 * 
		 */
//		userService.findUserById(1);
		
		/*
		 * 新建一个事务
		 */
//		userService.findUserByName("caocao");
		
		
		/*
		 * 对于REQUIRES_NEW的事务传播，一个对象的一个连接点调用另一个对象的一个连接点，
		 * 是不是这个对象的每个连接点都会新建一个事务？
		 * 
		 * 根据测试结果看到，创建了两个事务
		 * 
		 * 
		 */
		userService.test2Tx();
		
		
		/*
		 * 两个独立的事务
		 * 
		 * 此测试用例死锁，在命令行中手动创建事务for update也死锁，原因？
		 * 
		 * 连接1
		 * use test;
		 * begin;
		 * select * from user where id=1 for update;
		 * 
		 * 
		 * 连接2
		 * use test;
		 * begin;
		 * select * from user where name='caocao' for update;（锁住）
		 */
//		UserService2 userService2=(UserService2)context.getBean("userServiceImpl2");
//		userService2.findUserByName("caocao");
//		userService.findUserById(1);
		
		
		context.close();
	}
	
}
