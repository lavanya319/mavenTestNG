package practiceExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReports1 {
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter Spark = new ExtentSparkReporter("report.html");
		extentReports.attachReporter(Spark);
		
		
		
		ExtentTest Test1=extentReports.createTest("test1" , "First Test");
		Test1.log(Status.PASS, "This Test Is Passed");
		Test1.assignAuthor("lavanya");
		Test1.assignCategory("Regrression");
		Test1.assignDevice("Chrome 99");
		
		extentReports.createTest("Test2" ,"Second Test")
		.log(Status.FAIL, "Test is Failled")
		.assignAuthor("lavanya" , "Jhon" ,"mery")
		.assignCategory("regrresion" , "sanity" ,"smoke")
		.assignDevice("chrome","msEdge","firefox");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.nz/");
		String filepath=captureSreenShot("google");
		String Base64Screeshot=captureScreenShot();
		
		extentReports.createTest("Test3")
		.info("verifying ggogle home page")
		.addScreenCaptureFromPath(filepath , "Google Home page");
		
		extentReports
		.createTest("Test 4" ,"about google home page")
		.info("base64")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(Base64Screeshot).build());
		
		Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
		extentReports.setSystemInfo("Browser Name", capabilities.getBrowserName());
		extentReports.setSystemInfo("Browser version", capabilities.getBrowserVersion());
		extentReports.setSystemInfo("Os",System.getProperty("os.name"));
		extentReports.setSystemInfo("java version", System.getProperty("java.version"));
		extentReports.setSystemInfo("username", "lavanya");
		extentReports.setSystemInfo("pass", "132");
		extentReports.setSystemInfo("url", "https://www.google.co.nz/");
		
		extentReports.flush();
		
		driver.quit();
		Desktop.getDesktop().browse(new File("report.html").toURI());
		
	}
	public static String captureSreenShot(String FileName) {		
		TakesScreenshot takeSreensot=(TakesScreenshot)driver;
		File scrFile = takeSreensot.getScreenshotAs(OutputType.FILE);
		File DscFile = new File("./SreenShot"+FileName);
		try {
			FileUtils.copyFile(scrFile, DscFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot is saved Successfully");
		return DscFile.getAbsolutePath();

	}
	public static String captureScreenShot() {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		String base64 = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		
		System.out.println("Screenshot is saved Successfully");
		return base64;
	}

}

