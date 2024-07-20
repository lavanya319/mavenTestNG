package practiceExtentReport;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddSystemOrEnvironmentToExtentReports {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new  ChromeDriver();
		
		/*Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getBrowserVersion());
		driver.quit();*/
		
		//System.getProperties().list(System.out); //it will give all System properties
		System.out.println("os name "+System.getProperty("os.name"));
		System.out.println("java "+System.getProperty("java.version"));
	}

}
