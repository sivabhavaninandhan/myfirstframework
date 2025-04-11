package screenshotCapturingInExtentReportday_o4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screentexp {
	
	public static String getScreen(WebDriver driver) throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\imgpic"+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileUtils.copyFile(source, dest);
		
		return path;
	}


}
