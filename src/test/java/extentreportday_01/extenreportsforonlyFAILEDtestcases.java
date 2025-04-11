package extentreportday_01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extenreportsforonlyFAILEDtestcases {

	public static void main(String[] args) throws IOException {
	       ExtentReports extentReports=new ExtentReports();
	       ExtentSparkReporter sparkReporter_All=new ExtentSparkReporter("All.html");
	       ExtentSparkReporter sparkReporter_pass=new ExtentSparkReporter("pass.html");
	       ExtentSparkReporter sparkReporter_Failed=new ExtentSparkReporter("Failed.html");
	       ExtentSparkReporter sparkReporter_SkipAndWarning=new ExtentSparkReporter("SkipAndWarning.html");
	       
	       sparkReporter_SkipAndWarning.filter().statusFilter().as(new Status[] {Status.SKIP,Status.WARNING}).apply();
	       sparkReporter_Failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
	       sparkReporter_pass.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
	       
	         
	       extentReports.attachReporter(sparkReporter_All,sparkReporter_pass,sparkReporter_Failed,sparkReporter_SkipAndWarning);
	       
	       extentReports
	       .createTest("Test 1")
	       .assignAuthor("Flower")
	       .assignCategory("Sanity")
	       .assignDevice("Chrome 98")
	       .pass("This is a Passed Test");
	       
	       extentReports
	       .createTest("Test 1")
	       .assignAuthor("Flower","jasmin")
	       .assignCategory("Sanity","Regression")
	       .assignDevice("Chrome 98")
	       .fail("This is Failed Test");

	       extentReports
	       .createTest("Test 3")
	       .assignAuthor("Flower","jasmin","rose")
	       .assignCategory("Sanity","Regression","smoke")
	       .assignDevice("Chrome 98")
	       .skip("This Is Skipped Test");
	       
	       extentReports
	       .createTest("Test 4")
	       .assignAuthor("ganga")
	       .assignCategory("Sanity","Regression","smoke")
	       .assignDevice("Chrome 98")
	       .warning("This Is Warning Test");
	       
	       extentReports
	       .createTest("Test 5")
	       .assignAuthor("bhavani")
	       .assignCategory("Sanity","Regression")
	       .assignDevice("Chrome 98")
	       .fail("This is Failed Test");
	       
	       extentReports
	       .createTest("Test 6")
	       .assignAuthor("ganga")
	       .assignCategory("Sanity","Regression","smoke")
	       .assignDevice("Chrome 98")
	       .skip("This Is skip Test");
	       
	       extentReports.flush();
	       Desktop.getDesktop().browse(new File("All.html").toURI());
	       Desktop.getDesktop().browse(new File("pass.html").toURI());
	       Desktop.getDesktop().browse(new File("Failed.html").toURI());
	       Desktop.getDesktop().browse(new File("SkipAndWarning.html").toURI());
	       
	       
	}

}
