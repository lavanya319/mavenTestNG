package com.itnetBanking.pageobjects.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(how=How.LINK_TEXT,using="New Customer")
	WebElement linkNewCustomer;
	
	@FindBy(how=How.NAME,using="name")
	WebElement customerName;
	
	@FindBy(how=How.NAME,using="rad1")
	WebElement rdgender;
	
	@FindBy(how=How.NAME,using="dob")
	WebElement dateofBirth;
	
	@FindBy(how=How.NAME,using="addr")
	WebElement address;
	
	@FindBy(how=How.NAME,using="city")
	WebElement city;
	
	@FindBy(how=How.NAME,using="state")
	WebElement state;
	
	@FindBy(how=How.NAME,using="pinno")
	WebElement pin;
	
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement mblnumber;
	
	@FindBy(how=How.NAME,using="emailid")
	WebElement email;
	
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	
	@FindBy(how=How.NAME,using="sub")
	WebElement btnSubmit;
	
	@FindBy(how=How.NAME,using="res")
	WebElement btnReset;
	
	public void NewcustomerLNK() {
		linkNewCustomer.click();
	}
	public void Name(String name) {
		customerName.sendKeys(name);
	}
    public void Gender() {
    	rdgender.click();
    }
    public void DOB(String mm,String dd,String yyyy) {
    	dateofBirth.sendKeys(mm);
    	dateofBirth.sendKeys(dd);
    	dateofBirth.sendKeys(yyyy);
	}
    public void address(String adrs) {
    	address.sendKeys(adrs);
	}
    public void customerCity(String City) {
    	city.sendKeys (City);
	}
    public void custsate(String st) {
    	state.sendKeys(st);
	}
    public void custpincode(String pn) {
    	pin.sendKeys(String.valueOf(pn));//it converts Value int to String
	}
    public void custMblNum(String Mnum) {
    	mblnumber.sendKeys(Mnum);
	}
    public void custEmail(String mail) {
    	email.sendKeys(mail);
	}
    public void custpassword(String pass) {
    	password.sendKeys(pass);
	}
    public void sbmit() {
    	btnSubmit.click();
	}
    public void reset() {
    	btnReset.click();
	}
	
}
