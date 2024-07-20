package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(linkText="REGISTER")
	WebElement Register;
	
	@FindBy(name="firstName")
	WebElement FirstName;

	@FindBy(name="lastName")
	WebElement LastName;
	
	@FindBy(name="phone")
	WebElement Phone;
	
	@FindBy(name="userName")
	WebElement Email;
	
	@FindBy(name="address1")
	WebElement Address;
	
	@FindBy(name="city")
	WebElement City;
	
	@FindBy(name="state")
	WebElement Province;
	
	@FindBy(name="postalCode")
	WebElement PostalCode;
	
	@FindBy(name="country")
	WebElement Country;
	
	@FindBy(name="email")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="confirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(name="submit")
	WebElement Submit;


	
	public RegisterPage(WebDriver d) {
		//this.driver=driver;
		driver=d;
		PageFactory.initElements(d, this); //additional method
	}
	 public void clickReg() {
		 Register.click();
 }
	
	public void Firstname(String fstname) {
		FirstName.sendKeys(fstname);
		
	}
	public void Lastname(String lastname) {
		LastName.sendKeys(lastname);
	}
	public void Phone(String phone) {
		Phone.sendKeys(phone);
	}
	public void Email(String email) {
		Email.sendKeys(email);
	}
	public void Address(String address) {
		Address.sendKeys(address);
	}
	public void City(String city) {
		City.sendKeys(city);
	}
	public void Province(String state) {
		Province.sendKeys(state);
	}
	public void Postalcode(String postalcode) {
		PostalCode.sendKeys(postalcode);
	}
	public void country(String country) {
		Country.sendKeys(country);
	}
	public void UserName(String userName) {
		UserName.sendKeys(userName);
	}
	public void Password(String password) {
		Password.sendKeys(password);
	}
	public void confirmPassword(String CnfmPassword) {
		ConfirmPassword.sendKeys(CnfmPassword);
	}
	public void Submitclick() {
		Submit.click();
	}
}
