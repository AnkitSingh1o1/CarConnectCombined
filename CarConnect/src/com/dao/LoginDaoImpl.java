package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Login;

import com.utility.DBConnect;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Login login(String username, String password) throws SQLException {
		
		Connection con = DBConnect.dbConnect();
		String sql = "SELECT * FROM user WHERE user_username = ? AND user_password = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1,username);
		pstmt.setString(2,password);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			Login user = new Login();
			user.setId(rst.getInt("user_id"));
			user.setUsername(username);
			user.setPassword(password);   // password should not be displayed on the admin page menu console
			user.setRole(rst.getString("user_role"));
			DBConnect.dbClose();
			return user;
		}
		else {
			DBConnect.dbClose();
			return null;
		}
		
	}

	@Override
	public int resetPassword(String user, String newPassword) throws SQLException {
		Connection con = DBConnect.dbConnect();
		String sql = "UPDATE user SET user_password = ? WHERE user_username = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, newPassword);
        pstmt.setString(2,user );
		int status = pstmt.executeUpdate();
		DBConnect.dbClose();
		
		return status;
	}

}
