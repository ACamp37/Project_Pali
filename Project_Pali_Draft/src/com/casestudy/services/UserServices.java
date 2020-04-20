package com.casestudy.services;

import com.casestudy.dao.UserDAO;
import com.casestudy.models.User;

public class UserServices {

/*	public static void main(String[] args) {
//		testGetUserByIdService();
		testCreateUserService();

	} */  
	
	public int createUserService(User newUser) {
		UserDAO userDao = new UserDAO();
		int result = userDao.addUser(newUser);
		return result;
	}
	
	public void testCreateUserService() {
		int result = createUserService(new User(1, "Arc618", "Password", "Aaron", null));
		System.out.println("This is the result value " + result);
		switch(result) {
		case 0: 
			System.out.println("ERROR");
			break;
		case 1: System.out.println("User Created"); 
			break;
			default : break;
		}
	} 
	
	public User getUserByIdService(int userId) {
		UserDAO userDao = new UserDAO();
		User foundUser = userDao.getUserByid(userId);
		return foundUser;
	}
	
	public User getUserFromDAOService(User getUser) {
		UserDAO userDao = new UserDAO();
		User foundUser = userDao.getUser(getUser);
		return foundUser;
	}
	
/*	public static void testGetUserByIdService() {
		int getUser = 1;
		User foundUser = getUserByIdService(getUser);
		if(foundUser==null) {
			System.out.println("ERROR: User does not exist");
		} else {
			System.out.println("User Found = " + foundUser.toString());
		}
	} */
}
