package com.itnetBanking.testCases.java;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.itnetBanking.pageobjects.java.LoginPage;

public class TC_login_001 extends Baseclass{

	@Test
	public void login() throws IOException, InterruptedException {



		LoginPage lp = new LoginPage(driver);
		
		logger.info("URL is opened");
		
		lp.UserID(userId);
		logger.info("Username Entered");
		
		lp.Password(Password);
		logger.info("Password Entered");
		
		lp.clicklogin();
		
		Thread.sleep(3000);

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureSreenshot(driver , "login");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}


}
