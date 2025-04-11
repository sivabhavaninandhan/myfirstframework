package extentreportday_01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class differentAttributesinextentReport {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Capabilities capabilities=((RemoteWebDriver) driver).getCapabilities();
		ExtentReports extentReports=new ExtentReports();
		File file=new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		
		ExtentSparkReporterConfig config=sparkReporter.config();
		config.setTheme(Theme.DARK);
		config.setReportName("Report Name");
		config.setDocumentTitle("Doc Title");
		config.setTimeStampFormat("dd-mm-yyyy  hh:mm:ss");
		config.setCss(".badge-primary{background-color: #df658c}");
		config.setJs("document.getElementsByClassName('logo')[0].style.display='none';\r\n");
		
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Browser", capabilities.getBrowserName()+capabilities.getBrowserVersion());
		extentReports.setSystemInfo("user Name", "www.ganga@gmail.com");
		extentReports.setSystemInfo("password", "12345");
				
				
		extentReports.attachReporter(sparkReporter);
				
		
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
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("report.html").toURI());
		
		

	}

}
