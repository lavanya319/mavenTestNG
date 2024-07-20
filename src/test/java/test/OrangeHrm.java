package test;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm {
	
	public static WebDriver driver;
	@Test
	public void logIn() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

		String ActualTitle=driver.getTitle();
		System.out.println("Title is "+ActualTitle);
		String OrangeHRM="OrangeHRM";
		assertEquals(ActualTitle, OrangeHRM ,"Title mismatch");
		driver.quit();
	}
	
	@Test
	public void Facebook() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("email")).sendKeys("HYR tutorial" ,  Keys.ENTER);
		
		SoftAssert softAssert=new SoftAssert();
		
		//Title Assertion
		String actualTitle=driver.getTitle();
		String expectedTitle="Log in to Facebook";
		softAssert.assertEquals(actualTitle, expectedTitle , "Title is mismatched");
		
		
		
		//URL assertion
		String actualuRL=driver.getCurrentUrl();
		String eexpectedURL="https://www.facebook.com/";
		softAssert.assertNotEquals(actualuRL , eexpectedURL , "URL is mismatched");
		
		//Text assertion
		String actualText=driver.findElement(By.name("email")).getText();
		String expectedText="";
		softAssert.assertEquals(actualText, expectedText , "Text is mismatched");
		
		//Border Assertion
		String actualBorder=driver.findElement(By.name("email")).getCssValue("border");
		String expectedBorder="0.666667px solid rgb(240, 40, 73)";//actual borde in hexa value"1px solid #f02849" we need to covert to rgb value 1px solid rgb(240, 40, 73)
		softAssert.assertEquals(actualBorder, expectedBorder , "Username border is mismatched");
		
		//ErrorMassege Assertion
		String actualMessage=driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
		String expectedMessage="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		softAssert.assertEquals(actualMessage, expectedMessage , "Error Message is Mismatched");
		
		//Message Color assertion
		String actualMessageColor=driver.findElement(By.xpath("//div[@class='_9ay7']")).getCssValue("color");
		String expectedmessageColor="rgba(240, 40, 73, 1)";
		softAssert.assertEquals(actualMessageColor, expectedmessageColor , "Messagecolor is Mismatched");
		
		driver.quit();
		softAssert.assertAll();
		

	}

}
