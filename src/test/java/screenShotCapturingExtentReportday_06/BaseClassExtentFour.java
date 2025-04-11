package screenShotCapturingExtentReportday_06;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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

public class BaseClassExtentFour {
	
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
	
	public void InitiliseExtentReports()
	{
		ExtentSparkReporter sparkReporter_all=new ExtentSparkReporter("AllTests.html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);
		
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		
	}
	@AfterSuite
	
	public void ganareateReport() throws IOException
	{
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
	}

	@AfterMethod
	public void checkstatus(Method m,ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotpath=null;
		screenshotpath=capturingScreen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
		extentTest.addScreenCaptureFromPath(screenshotpath);
		extentTest.fail(result.getThrowable());		
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.pass(m.getName()+"This Test Is Passed");
		}
		
	}
	
	public String capturingScreen(String imgpic)
	{
		{
	 		if(screenshotsubfolder==null)
			{
				 LocalDateTime myDateObj = LocalDateTime.now();
				    //System.out.println("Before formatting: " + myDateObj);
				   DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
	               screenshotsubfolder = myDateObj.format(myFormatObj);
				    //System.out.println("After formatting: " + formattedDate);
			}
			String path="./Screenshot7/"+screenshotsubfolder+imgpic;
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcimg=ts.getScreenshotAs(OutputType.FILE);
			File destimg=new File(path);
			
			try {
				FileUtils.copyFile(srcimg, destimg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("screenshot saved successfully");
			return path;
			
		
		}
	}
}
