package extentreportday_01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class screenextenreport {
	
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
   
	
	@BeforeMethod
	public void setup()
	{
		File file=new File("report.html");	
		ExtentSparkReporter esr=new ExtentSparkReporter(file);
		extent=new ExtentReports();
		extent.attachReporter(esr);
		logger=extent.createTest("logintest");
		
	}
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=screenshots.getScreen(driver);
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
		}
		extent.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
	@Test
	public void validation()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.co.in/");
		System.out.println("the title is" +driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("bhavani"));	
	}
	
	
}
