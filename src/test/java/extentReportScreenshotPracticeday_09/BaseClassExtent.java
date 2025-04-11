package extentReportScreenshotPracticeday_09;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClassExtent {
	

	public static WebDriver driver;
	public static String screenshotsubfolder;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	@BeforeClass
	public void setup(ITestContext context)
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Capabilities capabilities=((RemoteWebDriver) driver).getCapabilities();
		String device=capabilities.getBrowserName()+capabilities.getBrowserVersion();
		String author=context.getCurrentXmlTest().getParameter("author");
		
		extentTest=extentReports.createTest(context.getName());
		extentTest.assignAuthor(author);
		extentTest.assignDevice(device);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

	@BeforeSuite
	public void initializeExtentReport()
	{
		ExtentSparkReporter sparkreport_All=new ExtentSparkReporter("AllTests.html");
		extentReports =new ExtentReports();
		extentReports.attachReporter(sparkreport_All);	
	    extentReports.setSystemInfo("OS",System.getProperty("os.name"));
	    extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	@AfterSuite
	public void generateExtentReport() throws IOException, URISyntaxException
	{
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
	}
	@AfterMethod
	public void checkStataus(Method m,ITestResult result)
	{
		if(result.getStatus()==result.FAILURE)
		{
			String screenshotpath=null;
			screenshotpath=captureScreen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
			extentTest.addScreenCaptureFromPath(screenshotpath);
			extentTest.fail(result.getThrowable());
		}
		else if(result.getStatus()==result.SUCCESS)
		{
			extentTest.pass(m.getName()+"  This Test Is Passed");
		}
	}
	
	public String captureScreen(String imgphoto)
	{
		if(screenshotsubfolder==null)
		{
			 LocalDateTime myDateObj = LocalDateTime.now();
			   // System.out.println("Before formatting: " + myDateObj);
			    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

			    screenshotsubfolder = myDateObj.format(myFormatObj);
			  //  System.out.println("After formatting: " + formattedDate);
		}
		String path="./Scrrenshot10/"+screenshotsubfolder+imgphoto;
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcpic=ts.getScreenshotAs(OutputType.FILE);
		File destpic=new File(path);
		
		try {
			FileUtils.copyFile(srcpic, destpic);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("screenshot saved successfully");
		return path;
		
		
		
	}
}
