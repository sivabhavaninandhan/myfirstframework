package screenshotday_06;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class baseimg {
	
	static WebDriver driver;
	
	public static void setimag()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void captureImg(String methodname) throws IOException
	{
		Date d=new Date();
		String timestamp=d.toString().replace(":", "_").replace(" ","");
		System.out.println(timestamp);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File dstfile=new File("C:\\Users\\ASUS\\OneDrive\\imgg\\"+methodname+timestamp+".png");
		FileHandler.copy(srcfile, dstfile);
		
	}

}
