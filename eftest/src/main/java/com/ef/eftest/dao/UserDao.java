package com.ef.eftest.dao;

import com.ef.eftest.entity.User;

public interface UserDao {
	
	public User findUserById(int id);
	
	public User findUserByName(String name);
}
