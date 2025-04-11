package screenshotExtentReportday_02;

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

public class BaseTesttwo {
	
	public  static WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	
	public void screencaptured(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				screen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

	
	public void screen(String filename) throws IOException
	{ 
		Date dt=new Date();
	    String timestamp=dt.toString().replace(":", "_").replace(" ", "");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screen4/"+filename+timestamp+ ".png");
		FileUtils.copyFile(src, dest);	
	}
}


