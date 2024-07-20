package practiceExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogScreenShotToExtendReport {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExtentReports extendReports = new ExtentReports();
		ExtentSparkReporter sparkReport = new ExtentSparkReporter("report1.HTML");
		extendReports.attachReporter(sparkReport);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.co.nz/");
		
		String path = captureSreenshot("report.jpg");
		
		String base64Screenshot = captureSreenshot();
		
		
		extendReports//single screenshot
		.createTest("Test level Screen shot1" , "This Screenshot taken by File Type")
		.info("Google")
		.addScreenCaptureFromPath(path);
		
		extendReports //multiple screenshots
		.createTest("Test level Screen shot2" , "This Screenshot taken by File Type")
		.info("Google")
		.addScreenCaptureFromPath(path , "google home page")
		.addScreenCaptureFromPath(path , "google home page")
		.addScreenCaptureFromPath(path , "google home page")
		.addScreenCaptureFromPath(path , "google home page");
	///////////	
		extendReports
		.createTest("Test level screen shot3"  ,  "Base64 Screen shot")
		.info("Googlebase64")
		.addScreenCaptureFromBase64String(base64Screenshot , "google home page")
		.addScreenCaptureFromBase64String(base64Screenshot , "google home page")
		.addScreenCaptureFromBase64String(base64Screenshot , "google home page")
		.addScreenCaptureFromBase64String(base64Screenshot , "google home page");
		
		extendReports
		.createTest("Log level ScreenShot1" , "verify google home page")
		.info("Google home page")
		.fail(com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build())
		.fail(com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot, "google homepage").build());
		
		extendReports
		.createTest("Log Level ScreenShot2" , "Verify google home page")
		.pass(com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.pass(com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(path , "google home page").build());
		
		extendReports.flush();
		
		driver.quit();
		
		
		
		

	}
	
	
	public static String captureSreenshot(String FileName) {
		
		TakesScreenshot takesSreenshot = (TakesScreenshot)driver;
		File srcfile= takesSreenshot.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("./SreenShot/"+FileName);
		
		try {
			FileUtils.copyFile(srcfile, dstFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("screenshot is saved sucssesfull ");
		
		return dstFile.getAbsolutePath();
	}
	
public static String captureSreenshot() {
		
		TakesScreenshot takesSreenshot = (TakesScreenshot)driver;
		String Base64= takesSreenshot.getScreenshotAs(OutputType.BASE64);
		
		System.out.println("screenshot is saved sucssesfull ");

		return Base64;
	}
	

}
