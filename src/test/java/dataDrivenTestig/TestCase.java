package dataDrivenTestig;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase {

	WebDriver driver;
	
	@Test(dataProvider="logindata")
	public void loginDDT(String name ,String paasword) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys(paasword);
		driver.findElement(By.name("btnLogin")).click();
		
		
		driver.quit();
	}
	@DataProvider(name="logindata")
	public String[][] xldata() throws IOException {
		String Path= "C:\\Users\\Dell\\Desktop\\java\\mavenTestNG\\Files\\inetBanking.xlsx";
		XLUtils xl=new XLUtils(Path);
		int rowC=xl.getRowCount("Sheet1");
		int ColuC=xl.getCellCount("Sheet1", 1);
		
		String data[][]=new String[rowC][ColuC];
		for(int i=1; i<=rowC; i++) {
			for(int j=0; j<ColuC; j++) {
				data[i-1][j]=xl.getCellData("Sheet1", i, j);
				System.out.println(xl.getCellData("Sheet1", i, j));
			}
		}
		return data;
	}
}
