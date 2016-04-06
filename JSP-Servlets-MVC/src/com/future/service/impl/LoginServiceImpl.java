package com.future.service.impl;

import com.future.dao.LoginDBAccess;
import com.future.dao.impl.LoginDBAccessImpl;
import com.future.model.User;
import com.future.service.LoginService;

public class LoginServiceImpl implements LoginService{

//	final String CORRECT_NAME = "admin";
//	final String CORRECT_PASSWORD = "admin";

	@Override
	public boolean validate(String userName, String password) {
//		return CORRECT_NAME.equals(userName) && CORRECT_PASSWORD.equals(password);
		LoginDBAccess loginDBAccess = new LoginDBAccessImpl();
		User user = loginDBAccess.getUserInfor(userName, password);
		if (user.getUserName() != null) {
			return true;
		}
		
		return false;
	}

}
