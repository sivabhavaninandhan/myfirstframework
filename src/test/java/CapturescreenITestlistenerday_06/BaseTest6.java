package CapturescreenITestlistenerday_06;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest6 {
	
	public static WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	
	public void takesscreenshot(ITestResult result) throws IOException
	{
		if(result.getStatus()==result.FAILURE)
		{
		CaptureScreenShot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
		}
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void CaptureScreenShot(String filename) throws IOException
	{
		Date dt=new Date();
		String timestamp=dt.toString().replace(":", "_").replace(" ", "");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screen009/"+timestamp+filename);
		
		FileUtils.copyFile(src, dest);
		
		
	}
}
