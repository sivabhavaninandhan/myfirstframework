package capturescreenshotbyusinglisteners;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	public static WebDriver driver;
	
	public static void initialize()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	public void capturescreen(String imgname) throws IOException
	{
		Date dt=new Date();
		String timestamp=dt.toString().replace(":","_").replace(" ", "");
		
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File("./Screen101/"+timestamp+imgname);
	  FileUtils.copyFile(source, dest);
	  
	}

}
