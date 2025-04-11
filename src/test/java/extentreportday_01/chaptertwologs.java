package extentreportday_01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class chaptertwologs {

	public static void main(String[] args) throws IOException {
		 ExtentReports extentreport=new ExtentReports();
		
		 File file=new File("report.html");
		 
		 ExtentSparkReporter sparkreporter=new ExtentSparkReporter(file);
		 extentreport.attachReporter(sparkreporter);
		 
		 extentreport
		 .createTest("Test 1")
		 .log(Status.INFO, "info1")
		 .log(Status.INFO, "info2")
		 .log(Status.FAIL, "fail1")
		 .log(Status.FAIL, "fail2")
		 .log(Status.PASS, "pass1")
		 .log(Status.PASS, "pass2")
		 .log(Status.WARNING, "warning1")
		 .log(Status.SKIP, "skip1");
		 
		 extentreport.flush();
		 Desktop.getDesktop().browse(new File("report.html").toURI());
		 

	}

}
