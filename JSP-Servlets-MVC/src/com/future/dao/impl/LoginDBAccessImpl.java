package com.future.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.future.dao.LoginDBAccess;
import com.future.utils.DBUtils;

public class LoginDBAccessImpl implements LoginDBAccess{
	
	public boolean checkLoginUser(String userName, String password) {
		String sql = "SELECT * FROM USER_TBL WHERE username=? AND password=?";
		
		Connection conn = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.getString("username") != null) {
				return true;
			} 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			DBUtils.closePreparedStatement(preparedStatement);
			DBUtils.closeConnection(conn);
		}
		
		return false;
	}

}
