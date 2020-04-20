package com.casestudy.dao;

import com.casestudy.models.User;

public interface UserDAOI {
	
	public int addUser(User newUser);
	public User getUserByid(int getUserById);
	public User getUser(User inputUser);
	
}
