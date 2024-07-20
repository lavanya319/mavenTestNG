package com.itnetBanking.testCases.java;



import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.itnetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	ReadConfig readconfig = new ReadConfig ();

	public String Url=readconfig.geturl();

	public String userId=readconfig.username();
	public String Password=readconfig.password();

	public static Logger logger;
	public static WebDriver driver;


	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger=LogManager.getLogger();

		//logger=Logger.getLogger("eBanking");
		//PropertyConfigurator.configure("Log4j.Properties");
		

		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else{
			System.out.println("browse is not found");
		}


		driver.get(Url);
	}

	@AfterClass
	public void teardown() {
		System.out.println("teardown");
		driver.quit();
	}
	public  void captureSreenshot(WebDriver driver , String FileName) throws IOException {
		LocalDateTime localDateTime=LocalDateTime.now();//it gives yyyy-MM-ddTHH:mm:ss:ns formate
		DateTimeFormatter datetimeFormate=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String DT=localDateTime.format(datetimeFormate);


		TakesScreenshot takesSreenshot = (TakesScreenshot)driver;
		File srcfile= takesSreenshot.getScreenshotAs(OutputType.FILE);
		File dstFile = new File(System.getProperty("user.dir")+"/Sreenshots/"+ FileName+".png");

		FileUtils.copyFile(srcfile, dstFile);
		System.out.println("Screenshot is taken");
	}

	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(8);//this methos will give random 8 alphabetics 
		return generatedString;
	}
	public String randomNum() {
		String generetedStrig2=RandomStringUtils.randomNumeric(4);
		return generetedStrig2;
	}
}
