package screenshotday_09;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class capturescreen {
	
	static WebDriver driver;
	public static void setpic()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
 public void capture(String filename) throws IOException
 {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
	 String path="C:\\Users\\ASUS\\OneDrive\\screens"+filename+".png";
	 File dest=new File(path);
	 FileUtils.copyFile(src, dest);
	 
	 
 }

}
