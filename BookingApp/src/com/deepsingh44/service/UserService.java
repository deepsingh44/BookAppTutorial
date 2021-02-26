package com.deepsingh44.service;

import com.deepsingh44.dao.UserDao;
import com.deepsingh44.model.User;

public class UserService {

	// singleton design pattern
	private static UserService userService = new UserService();

	private UserService() {
	}

	public static UserService getUserService() {
		return userService;
	}

	public String register(User user) {
		String msg = "";
		try {
			msg = (UserDao.getUserDao().register(user) > 0) ? "Successfully Registeration" : "Registration Failed";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}
	
	public User login(String email,String pass) {
		User user=null;
		try {
			 return UserDao.getUserDao().login(email,pass);
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

}
