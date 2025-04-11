package screenshotday_08;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class baseimgone {
	
	static WebDriver driver;
	public static void setpic()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void captureimg(String imgname) throws IOException
	{
		Date dt=new Date();
		String timestamp=dt.toString().replace(":", "_").replace(" ", "");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcscrn=ts.getScreenshotAs(OutputType.FILE);
		File dstscrn=new File("C:\\Users\\ASUS\\OneDrive\\photos\\"+imgname+timestamp+".png");
		FileHandler.copy(srcscrn, dstscrn);
	}
} 
