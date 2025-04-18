package CaptureScreenITestlistenrday_05;

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

public class BaseTest5 {
	
	public static WebDriver driver;
	
	@BeforeTest
	
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
@AfterMethod
public void sceenshot(ITestResult result) throws IOException
{
	if(result.getStatus()==result.FAILURE)
	{
		CaptureScreen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
	}
}

@AfterTest
public void teardown()
{
	driver.quit();
}
public void CaptureScreen(String image) throws IOException
{
	Date dt=new Date();
	String timestamp=dt.toString().replace(":", "_").replace(" ", "");
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screen008/"+timestamp+image);
	
	FileUtils.copyFile(source, dest);
}
}

