package com.shivam.Login_user.service;

import com.shivam.Login_user.dao.UserDao;
import com.shivam.Login_user.entity.User;

public class UserService {
	
	UserDao dao=new UserDao();
	
	public boolean checkPassword(User user) {
		String password = user.getPassword();
		if((password.length()>8 && password.length()<15)&&(password.matches("^[a-zA-Z0-9]*$"))){
			User user2=dao.insertNewUser(user);
			if(user2!=null) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean loginUser(String userName, String password) {
		User user= dao.getUserByPassword(userName);
		if(user!=null) {
			return user.getPassword().equals(password);
		}
		else {
			return false;
		}
	}

}
