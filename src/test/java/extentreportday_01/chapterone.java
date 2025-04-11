package extentreportday_01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class chapterone {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentreports=new ExtentReports();
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("report.html");
        extentreports.attachReporter(sparkReporter);
      ExtentTest test1=extentreports.createTest("Test 1");
      test1.pass("This Is Passed");
      ExtentTest test2=extentreports.createTest("Test 2");
      test2.log(Status.FAIL, "This Is Failed");
      extentreports.createTest("Test 3").skip("This Is Skipped");
        extentreports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
