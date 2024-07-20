package com.itnetBanking.testCases.java;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.itnetBanking.pageobjects.java.AddCustomerPage;
import com.itnetBanking.pageobjects.java.LoginPage;

public class TC_AddCustomerTest_003 extends Baseclass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.UserID(userId);
		lp.Password(Password);
		lp.clicklogin();

		Thread.sleep(3000);

		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.NewcustomerLNK();
		
		Thread.sleep(5000);
		addcust.Name("lavanya");
		addcust.Gender();
		addcust.DOB("10", "10", "2024");

		Thread.sleep(3000);

		addcust.address("jhvcgfxfc");
		addcust.customerCity("thorrur");
		addcust.custsate("India");
		addcust.custpincode("102008");
		addcust.custMblNum("1234567556");

		String remail=randomString()+"@gmail.com";
		addcust.custEmail(remail);
		addcust.custpassword("12345678");
		addcust.sbmit();
		Thread.sleep(3000);

		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true) {
			Assert.assertTrue(true);
		}
		else
		{
			captureSreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

	}


}
