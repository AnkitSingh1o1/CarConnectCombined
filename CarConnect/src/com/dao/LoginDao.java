package com.dao;

import java.sql.SQLException;

import com.model.Login;


public interface LoginDao {

	Login login(String username, String password) throws SQLException;
	int resetPassword(String user, String newPassword) throws SQLException;

}
