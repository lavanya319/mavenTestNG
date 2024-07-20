package practiceExtentReport;

import static org.testng.Assert.fail;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AttributesInExtendsReport {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentReports= new ExtentReports();
		ExtentSparkReporter Spark=new ExtentSparkReporter("reporter2.html");
		extentReports.attachReporter(Spark);
		
		extentReports.createTest("Test attributes1")
		.assignAuthor("jhon")
		.assignCategory("Regression")
		.assignDevice("chrome 99");
		
		extentReports
		.createTest("Test1")
		.assignAuthor("jhon","rebacca","merry","luice")
		.assignCategory("regression","sanity","smoke")
		.assignDevice("chrome 99","firefox 100","Edge 102");
		
		extentReports
		.createTest("Test2")
		.assignAuthor( new String[]{"rebacca" ,"merry"})
		.assignCategory(new String[] {"regression" , "sanity", "smoke"})
		.assignDevice(new String[] {"chrome 99","firefox 100","Edge 102"})
		.fail("This test is failed");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("reporter2.html").toURI());

	}

}
