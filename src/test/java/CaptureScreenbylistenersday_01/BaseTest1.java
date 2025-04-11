package CaptureScreenbylistenersday_01;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest1 {
	public static WebDriver driver;
	public static String screenshotsubfolder;
	
	@BeforeTest
	public void setup()
	{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	@AfterMethod
	public void screencapture(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			captureScreen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
		}
		
	}
	@AfterTest
	public void teardown()
	{
	driver.quit();		
	}
	
public void captureScreen(String imgs) throws IOException
{
	if(screenshotsubfolder==null)
	{
		LocalDateTime myDateObj = LocalDateTime.now();
	   // System.out.println("Before formatting: " + myDateObj);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
	    screenshotsubfolder = myDateObj.format(myFormatObj);
	   // System.out.println("After formatting: " + formattedDate);
	}
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File srs=ts.getScreenshotAs(OutputType.FILE);
	File dts=new File("./Screen25/"+screenshotsubfolder+imgs);
	
	FileUtils.copyFile(srs, dts);
	
	
}
}
