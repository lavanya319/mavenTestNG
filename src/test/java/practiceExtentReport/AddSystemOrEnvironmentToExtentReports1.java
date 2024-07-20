package practiceExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddSystemOrEnvironmentToExtentReports1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter Spark = new ExtentSparkReporter("report2.html");
		extentReports.attachReporter(Spark);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
		
		extentReports.setSystemInfo("os", System.getProperty("os.name"));
		extentReports.setSystemInfo("java version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Brower version" ,capabilities.getBrowserName()+""+capabilities.getBrowserVersion());
		extentReports.setSystemInfo("URl", "https://www.facebook.com/");
		extentReports.setSystemInfo("Name", "lavanya");
		extentReports.setSystemInfo("password", "12345");
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("report2.html").toURI());
	
	}

}
