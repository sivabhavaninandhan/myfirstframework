package capturescreenbylistenersday_02;

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

public class BaseTest3 {
	
	public static WebDriver driver;
	
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
		capturescreen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
	}
/* @AfterTest
 public void teardown()
 {
	 driver.quit();
 }*/
 
 public void capturescreen(String pic) throws IOException
 {
	 Date dt=new Date();
	 String timestamp=dt.toString().replace(":", "_").replace(" ","");
	 
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File ssr=ts.getScreenshotAs(OutputType.FILE);
	 File dds=new File("./screen31/"+timestamp+pic);
	 
	 FileUtils.copyFile(ssr, dds); 
	 
 }
}
