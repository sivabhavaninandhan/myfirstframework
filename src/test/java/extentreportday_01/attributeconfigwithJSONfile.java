package extentreportday_01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class attributeconfigwithJSONfile {

	public static void main(String[] args) throws IOException {
		 ExtentReports extentReports=new ExtentReports();
		 File file=new File("report.html");
		 ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		 
		 ExtentSparkReporterConfig config=sparkReporter.config();
		 
		 sparkReporter.loadJSONConfig(new File("./src/test/resources/extent-reports-config-json"));
		 extentReports
			.createTest("Test 1")
			.assignAuthor("bhavani")
			.assignCategory("smoke")
			.assignDevice("Chrome 99")
			.pass("This is a PassedTest");
			
			extentReports
			.createTest("Test 2")
			.assignAuthor("ganag","bhavani","mani")
			.assignCategory("smoke","sanity")
			.assignDevice("Chrome 99","Edge 94")
			.fail("This is a Failed Test");
         
		 extentReports.attachReporter(sparkReporter);
		 extentReports.flush();
		 Desktop.getDesktop().browse(new File("report.html").toURI());
		 
	}

}
