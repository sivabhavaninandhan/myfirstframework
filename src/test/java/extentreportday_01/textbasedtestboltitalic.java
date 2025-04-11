package extentreportday_01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class textbasedtestboltitalic {

	public static void main(String[] args) throws IOException {
		ExtentReports extentreport=new ExtentReports();
		
		File file=new File("report.html");
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(file);
		extentreport.attachReporter(sparkreporter);
		
		extentreport
		.createTest("Text based Test")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "<b>info2</b>")
		.log(Status.INFO, "<i>info3</i>");
		
		extentreport.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());

	}

}
