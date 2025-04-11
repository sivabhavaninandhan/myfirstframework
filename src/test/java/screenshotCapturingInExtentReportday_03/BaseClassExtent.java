package screenshotCapturingInExtentReportday_03;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClassExtent {
	
	public static WebDriver driver;
	//public static String screenshotSubFollderName;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	@BeforeTest
	public void setup(ITestContext context)
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Capabilities capabilities=((RemoteWebDriver) driver).getCapabilities();
		String device=capabilities.getBrowserName()+"  "+capabilities.getBrowserVersion().substring(0,capabilities.getBrowserVersion().indexOf("."));
		String author=context.getCurrentXmlTest().getParameter("author");
		
		extentTest=extentReport.createTest(context.getName());
		extentTest.assignAuthor(author);
		extentTest.assignDevice(device);
		
		
	}
	
		
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	@BeforeSuite
	public void initiliseextentReports()
	{
		ExtentSparkReporter sparkreporter_all=new ExtentSparkReporter("AllTests.html");
		extentReport=new ExtentReports();
		extentReport.attachReporter(sparkreporter_all);
		
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("javaversion"));
		
	}
	@AfterSuite
	public void generateextentReports() throws IOException
	{
		extentReport.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
	}
	
	
	@AfterMethod
	
	public void checkstatus(Method m,ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=extentclassscreen.getScreen(driver);
			String path1=extentclassscreen.getScreen(driver);
		    //extentTest.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());	
			extentTest.fail(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
		    //extentTest.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(path1).build());
		    extentTest.addScreenCaptureFromPath(path);
		   // extentTest.addScreenCaptureFromPath(path1,"googlehomepage");
		    extentTest.fail(result.getThrowable());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.pass(m.getName()+"is passed");
		}
	
	}
	/*public static String getScreen(WebDriver driver) throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\imgpic"+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileUtils.copyFile(source, dest);
		
		return path;
	}*/

	
}
