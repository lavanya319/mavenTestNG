package com.itnetBanking.utilities;


import java.io.File;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ReporGenerate_listeners   implements ITestListener{

	public static ExtentReports extentreports;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest extentTest;
	public static WebDriver driver;

	@Override
	public void onStart(ITestContext context) {//it is like beforeSuite
		LocalDateTime lDateTime = LocalDateTime.now();
		DateTimeFormatter DTFormate = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
		String DateTime=lDateTime.format(DTFormate);


		extentreports = new ExtentReports();
		//sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+DateTime+".html");
		sparkReporter = new ExtentSparkReporter("./extentReports/"+DateTime+"/Report.html");
		extentreports.attachReporter(sparkReporter);


		extentreports.setSystemInfo("os", System.getProperty("os.version"));
		extentreports.setSystemInfo("java version", System.getProperty("java.version"));
		extentreports.setSystemInfo("Host Name", "Local Host");
		extentreports.setSystemInfo("Environment", "QA");
		extentreports.setSystemInfo("User", "Lavanya");

		sparkReporter.config().setDocumentTitle("InetBanking Test Project");
		sparkReporter.config().setReportName("Functional Test Report");
		sparkReporter.config().setTheme(Theme.DARK);


	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest = extentreports.createTest(result.getName());
		extentTest.pass(MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}
	@Override
	public void onTestFailure(ITestResult result) {

		extentTest = extentreports.createTest(result.getName());
		extentTest.fail(MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

		String screenShotpath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";

		File f = new File(screenShotpath);
		if(f.exists())
		{
			
			extentTest.addScreenCaptureFromPath(screenShotpath);
		}

		extentTest.fail(result.getThrowable()); //add exception
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest = extentreports.createTest(result.getName());
		extentTest.skip(MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}


	@Override
	public void onFinish(ITestContext context) {
		extentreports.flush();

	}


}


