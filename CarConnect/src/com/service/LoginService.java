package com.service;

import java.sql.SQLException;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.exception.InvalidCredentialException;
import com.model.Login;


public class LoginService {
	
	// creating a polymorphic object of class LoginDao
	
	LoginDao loginDao = new LoginDaoImpl();
	
	public Login login(String username, String password) throws SQLException, InvalidCredentialException {
		
		Login loginUser = loginDao.login(username, password);
		
		//if the any of the entered credentials are incorrect it throws an InvalidCredentialException
		if(loginUser == null) {
			throw new InvalidCredentialException("Invalid Credentials");
		}
		
		return loginUser;
	}

	public int resetPassword(String user, String newPassword) throws  SQLException {
	
		return loginDao.resetPassword(user, newPassword);
	}

	public boolean validatePassword(String password) {
		
		if(password.length() < 8 && password.length() <= 16) {
			return false;
		}
		boolean checkDigit = false;
		for(char ch : password.toCharArray()) {
			if(Character.isDigit(ch)) {
				checkDigit = true;
				break;
			}
		}
		if(!checkDigit) {
			return false;
		}
		
		boolean checkUpperCase = false;
		for(char ch : password.toCharArray()) {
			if(Character.isUpperCase(ch)) {
				checkUpperCase = true;
				break;
			}
		}
		if(!checkUpperCase) {
			return false;
		}
		
		boolean checkSpecialChar = false;
		String specialCharacter = "#$@*";
		for(char ch : specialCharacter.toCharArray()) {
			for(char c : password.toCharArray()) {
				if(ch == c) {
					checkSpecialChar = true;
					break;
				}
				if(checkSpecialChar) {
					break;
				}
			}
		}
		if(!checkSpecialChar) {
			return false;
		}
		
		
		return true;
	}

}
