package extentreportscreenshot;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	public static 	WebDriver driver;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	
	@BeforeTest
	
	public <RemoteWebDriver> void setup(ITestContext context)
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		String author=context.getCurrentXmlTest().getParameter("author");
		extentTest=extentReports.createTest(context.getName());
		extentTest.assignAuthor(author);
	}
	
	
	@AfterMethod
	
	public void screen(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			capturescreens(result.getTestContext().getName()+".jpg");
		}
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	@BeforeSuite
	
	public void initiliseExtentReports()
	{
		ExtentSparkReporter sparkReporter_all=new ExtentSparkReporter("AllTests.html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java version"));
	}
	
	@AfterSuite
	public void checkreports() throws IOException
	{
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
	}
	
	@AfterMethod
	
	public void checkstatus(Method m,ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotpath=null;
			screenshotpath=capturescreens(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
			extentTest.addScreenCaptureFromPath(screenshotpath);
			
			extentTest.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.pass(m.getName()+"is passed");
		}	
	}

	public String capturescreens(String FileName) throws IOException
		{
			Date d=new Date();
			String timestamp=d.toString().replace(":","_").replace(" ", "");
			String path="./Screen44/"+FileName+timestamp+".jpg";
			System.out.println(timestamp);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
	       	File dest=new File(path);
			FileHandler.copy(src, dest);
			return path;
			
		}
	}

