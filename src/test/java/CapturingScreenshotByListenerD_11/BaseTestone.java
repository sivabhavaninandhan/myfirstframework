package CapturingScreenshotByListenerD_11;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestone {
	
	public static WebDriver driver;
	public String screenshotsubfolder;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	
	public void screentakes(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Capturscreen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
		}
		
	}
 @AfterTest
 public void teardown()
 {
	 driver.quit();
 }

 public void Capturscreen(String imgname) throws IOException
 {
	 Date dt=new Date();
	 String timestamp=dt.toString().replace(":", "_").replace(" ", "");
	 
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
	 File dst=new File("./screen005/"+timestamp+imgname);
	 
	 FileUtils.copyFile(src, dst);
	 
 }
}
