package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	@Test
	public void TestGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.nz/");
		driver.findElement(By.name("q")).sendKeys("hyr tutorial" , Keys.ENTER);
		Thread.sleep(3000);		
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="hyr tutorial - Google Search";
		assertEquals(ActualTitle, ExpectedTitle);

		driver.quit();
	}
	@Test
	public void TestFacebook() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		
		driver.close();

	}
}
