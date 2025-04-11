package screenshotextentday_04;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class baseClass {
	
	public static WebDriver driver;
	public static String screenshotsubfolder;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
    @AfterMethod
	public void screen(ITestResult result)
	{
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    		capturescreen(result.getTestContext().getName()+"_"+result.getName()+".png");
    	}
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	public void capturescreen(String filename)
	{
		if(screenshotsubfolder==null)
		{
		LocalDateTime myDateObj = LocalDateTime.now();
	    //System.out.println("Before formatting: " + myDateObj);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

	    screenshotsubfolder= myDateObj.format(myFormatObj);
	    //System.out.println("After formatting: " + formattedDate);
		}
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./Screenshot11/"+screenshotsubfolder+filename);
		
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("screenshot saved successfully");
	}
}
