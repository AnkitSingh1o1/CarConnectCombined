package com.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.exception.InvalidCredentialException;
import com.model.Login;
import com.service.LoginService;

public class LoginTest {
	LoginService loginService = new LoginService();
	@Test
	public void login(){
		String username = "admin";
		String password = "admin123";
		try {
			Login actualUserLogin = loginService.login(username,password);
			Login expectedUser = new Login(31,"admin","admin123","admin");
			
			Assert.assertEquals(expectedUser, actualUserLogin);
			
		}
		catch(InvalidCredentialException e) { } catch (SQLException e) {
			
			
		}
// Test - 2
		
		 username = "anjali_customer";
		 password = "passwordvwx";
		try {
			Login actualUserLogin = loginService.login(username,password);
			Login expectedUser = new Login(11,"anjali_customer","passwordvwx","customer");
			
			Assert.assertEquals(expectedUser, actualUserLogin);
			
		}
		catch(InvalidCredentialException e) { } catch (SQLException e) {
			
			
		}
// Test - 3

		 username = "arjun_vendor";
		 password = "passwordjkl";
		try {
			Login actualUserLogin = loginService.login(username,password);
			Login expectedUser = new Login(22,"arjun_vendor","passwordjkl","vendor");
			
			Assert.assertEquals(expectedUser, actualUserLogin);
			
		}
		catch(InvalidCredentialException e) { } catch (SQLException e) {
			
			
		}
// Test - 4

		username = "vendor";
		password = "passwordjkl";
		try {
		    Login actualUserLogin = loginService.login(username, password);
		    Login expectedUser = new Login(22, "arjun_vendor", "passwordjkl", "vendor");
		    Assert.assertEquals(expectedUser, actualUserLogin);
		}
		catch (InvalidCredentialException e) {
		    Assert.assertEquals("Invalid Credentials", e.getMessage());
		}
		catch (SQLException e) {
	
		}
	}
}
