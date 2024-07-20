package com.itnetBanking.testCases.java;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itnetBanking.pageobjects.java.LoginPage;
import com.itnetBanking.utilities.XLUtility;

public class TC_loginDDT_002 extends Baseclass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String usrname , String passw) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.UserID(usrname);
		lp.Password(passw);
		lp.clicklogin();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();//alert close
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//logout alert close
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {//user defined method to check alert is present or not
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/itnetBanking/TestData/inetBanking.xlsx";
	    // String path="C:\\Users\\Dell\\Downloads\\inetBanking.xlsx";
		//System.out.println(path);
		
		XLUtility Utils = new XLUtility(path);
		int Rownum=Utils.getRowCount("Sheet1");
		int ColCount=Utils.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[Rownum][ColCount];
		  for(int i=1; i<=Rownum; i++) {
			  for(int j=0;j<ColCount;j++) {
				  logindata[i-1][j]=Utils.getCellData("Sheet1",i,j);	//1 0
			}
		}
		return logindata;
	}
}
