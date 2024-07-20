package com.itnetBanking.pageobjects.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement UserID;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="btnLogin")
	WebElement Login;
	
	@FindBy(linkText="Log out")
	WebElement logoutbotton;

	public void UserID(String userid) {
		UserID.sendKeys(userid);
	}
	public void Password(String password) {
		Password.sendKeys(password);
	}
	public void clicklogin() {
		Login.click();
	}
	public void clicklogout() {
		logoutbotton.click();
	}
}
