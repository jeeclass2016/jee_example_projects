package com.future.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.future.dao.LoginDBAccess;
import com.future.model.User;
import com.future.utils.DBUtils;

public class LoginDBAccessImpl implements LoginDBAccess{
	
	public User getUserInfor(String userName, String password) {
		String sql = "SELECT * FROM USER_TBL WHERE username=? AND password=?";
		User user = new User();
		
		Connection conn = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserName(rs.getString("username"));
				user.setAge(rs.getString("age"));
				user.setMobile(rs.getString("mobile"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeConnection(conn);
		}
		
		return user;
	}
	

}
