package extentreportday_01;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class normalextentreport {

	public static void main(String[] args) {
		ExtentReports extentreport=new ExtentReports();
		
		ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Users\\ASUS\\OneDrive\\repors\\report.html");
		extentreport.attachReporter(spark);
		
		extentreport.flush();

	}

}
