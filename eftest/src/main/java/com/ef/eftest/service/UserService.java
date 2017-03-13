package com.ef.eftest.service;

public interface UserService {
	
	public void findUserById(int id);
	
	public void findUserByName(String name);
	
	public void test2Tx();

	public UserService2 getService2();


}
