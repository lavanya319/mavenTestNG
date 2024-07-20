package practiceExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentReports=new ExtentReports();//this class will start the report
		
		//1 way for giving file path
		
		//File file=new File("./ExtentReport/report.html")
		//ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		
		//2nd way for giving file path using string type
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("report.html");//which is a type of reporter that  we want to create
		extentReports.attachReporter(sparkReporter);//Attaching reporter type to ExtentReporter class
		
		ExtentTest test1 = extentReports.createTest("Test1");
		test1.pass("This is passed");
		
		ExtentTest test2 = extentReports.createTest("Test2");
		test2.log(Status.FAIL, "This is Failed");
		
		extentReports.createTest("Test3").skip("this is skipped");
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("report.html").toURI());//this will open the report directly after execution

	}
	

}
