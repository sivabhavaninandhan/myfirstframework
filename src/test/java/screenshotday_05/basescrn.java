package screenshotday_05;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class basescrn {
	
	public static WebDriver driver;
	
	public static void initiliaze()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
  
	
	public void capturescreen(String FileName) throws IOException
	{
		Date d=new Date();
		String timestamp=d.toString().replace(":","_").replace(" ", "");
		
		System.out.println(timestamp);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
       	File dest=new File("C:\\Users\\ASUS\\OneDrive\\screens\\"+FileName+timestamp+".png");
		FileHandler.copy(src, dest);
	}
}
