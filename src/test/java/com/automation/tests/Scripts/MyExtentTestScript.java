package com.automation.tests.Scripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentTestScript {

	static ExtentTest test;
	public static void testscript1() {
		test.info("inside testcript 1");
	}

	public static void testscript2() {
		test.info("inside testcript 2");
	}

	public static void testscript3() {
		test.info("inside testcript 3");
	}

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		 extent.setSystemInfo("Host Name", "Salesforce");
	   	 extent.setSystemInfo("Environment", "Automation Testing");
	   	 extent.setSystemInfo("User Name", "Anusha");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/results/extentreport/MySpark.html");
		spark.config().setDocumentTitle("Test Execution Report");
	   	spark.config().setReportName("firebase regression tests");
	   	spark.config().setTheme(Theme.DARK);
	   	 
		extent.attachReporter(spark);
		
		test= extent.createTest("testscript1");
		test.info("my testcript1 has started");
		testscript1();
		test.info("my testcript1 has ended");
		
		
		test= extent.createTest("testscript2");
		test.info("my testcript2 has started.....................");
		testscript2();
		test.info("my testcript2 has ended");
		
		
		test= extent.createTest("testscript3");
		test.info("my testcript3 has started*************************");
		testscript3();
		test.info("my testcript3 has ended");
		extent.flush();
		System.out.println("completed");
	}

}
