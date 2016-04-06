package com.future.dao;

import com.future.model.User;

public interface LoginDBAccess {
	public User getUserInfor(String userName, String password);

}
