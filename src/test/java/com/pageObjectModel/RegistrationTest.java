package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest {
	
	@Test
	public void bookFlitTicket() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	RegisterPage regpage = new RegisterPage(driver);
	
	driver.get("https://demo.guru99.com/selenium/newtours/register.php");
	regpage.clickReg();
	regpage.Firstname("lavanya");
	regpage.Lastname("lavanya");
	regpage.Phone("1235241234");
	regpage.Email("lavanya123@gmail.com");
	regpage.Address("2/1/2");
	regpage.City("khammam");
	regpage.Province("telangana");
	regpage.Postalcode("12234");
	regpage.country("India");
	regpage.UserName("lavanya");
	regpage.Password("lavanya");
	regpage.confirmPassword("lavanya");
	regpage.Submitclick();
	
	//validation

	if(driver.getPageSource().contains("thank you for register")) {
		System.out.println("Registration is success");
	}
	else 
	{
		System.out.println("Registration is not success");

	}
	
	
	
	
	}
}
