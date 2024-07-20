package practiceExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentDiffLogs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
		extentReports.attachReporter(spark);
		
		extentReports
		.createTest("bold test")
		.log(Status.INFO, "<b> this is bold message </b>")
		.log(Status.INFO, "<i> italik </i>")
		.log(Status.INFO , "<i><b>italic</b></i>")
		.log(Status.INFO , "<strong>Strong</strong>")
		.log(Status.INFO , "<em>emphasis</em>")
		.log(Status.INFO , "<mark>mark</mark>")
		.log(Status.INFO , "<small>Smaller text</small>")
		.log(Status.INFO , "<del>Deleted text</del>")
		.log(Status.INFO , "<ins>Inserted text</ins>")
		.log(Status.INFO , "Text <sub> Subscript text</sub>")
		.log(Status.INFO , "Text <sup> Superscript text</sup>");
		
		String XMLdata="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<note>\r\n"
				+ "    <to>Tove</to>\r\n"
				+ "    <from>Jani</from>\r\n"
				+ "    <heading>Reminder</heading>\r\n"
				+ "    <body>Don't forget me this weekend!</body>\r\n"
				+ "</note>";
		
		String Jsondata="{\r\n"
				+ "  \"first_name\": \"John\",\r\n"
				+ "  \"last_name\": \"Smith\",\r\n"
				+ "  \"is_alive\": true,\r\n"
				+ "  \"age\": 27,\r\n"
				+ "  \"address\": {\r\n"
				+ "    \"street_address\": \"21 2nd Street\",\r\n"
				+ "    \"city\": \"New York\",\r\n"
				+ "    \"state\": \"NY\",\r\n"
				+ "    \"postal_code\": \"10021-3100\"\r\n"
				+ "  },\r\n"
				+ "  \"phone_numbers\": [\r\n"
				+ "    {\r\n"
				+ "      \"type\": \"home\",\r\n"
				+ "      \"number\": \"212 555-1234\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"type\": \"office\",\r\n"
				+ "      \"number\": \"646 555-4567\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"children\": [\r\n"
				+ "    \"Catherine\",\r\n"
				+ "    \"Thomas\",\r\n"
				+ "    \"Trevor\"\r\n"
				+ "  ],\r\n"
				+ "  \"spouse\": null\r\n"
				+ "}";
		
		extentReports
		.createTest("XML test data")
		.info(MarkupHelper.createCodeBlock(XMLdata , CodeLanguage.XML));
		
		extentReports
		.createTest("Json test data")
		.info(MarkupHelper.createCodeBlock(Jsondata , CodeLanguage.JSON));
		
		//Collection set ,List, Map Interfaces
		List<String> listData = new ArrayList<String>();
		listData.add("anaya");
		listData.add("addition");
		listData.add("subtraction");
		
		Map<Integer , String> mapData = new HashMap<Integer , String>();
		mapData.put( 100, "john");
		mapData.put( 101, "merry");
		mapData.put( 102, "alna");
		
		Set<Integer> setData = mapData.keySet();
		
		extentReports
		.createTest("List collection Data")
		.info(MarkupHelper.createUnorderedList(listData))
		.info(MarkupHelper.createOrderedList(listData));
		
		extentReports
		.createTest("Map Data")
		.info(MarkupHelper.createUnorderedList(mapData))
		.info(MarkupHelper.createOrderedList(mapData));
		
		extentReports
		.createTest("Set Collection Data")
		.info(MarkupHelper.createUnorderedList(setData))
		.info(MarkupHelper.createOrderedList(setData));

		//exceptions
		
		try {
			int i=5/0;
		}
		catch(Exception e) {
			extentReports
			.createTest("Exception Test1")
			.info(e);
		}
		
		Throwable t= new RuntimeException("create custom Exception");
		extentReports
		.createTest("exception Test2")
		.info(t);
		
		
		
		extentReports
		.createTest("Highlet log Test")
		.info(MarkupHelper.createLabel("This is Highleted message", ExtentColor.PURPLE));
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());

	}

	
		
	}


