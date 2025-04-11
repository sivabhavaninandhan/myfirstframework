package screenshotday_04;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screenshotintro {
	
	WebDriver driver;
	
	public void screen(WebDriver driver,String name)  throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\ASUS\\OneDrive\\photolu\\"+name+".png");
		FileHandler.copy(src, trg);
	}

}
