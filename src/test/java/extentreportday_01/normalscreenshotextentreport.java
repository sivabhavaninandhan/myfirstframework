package extentreportday_01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class normalscreenshotextentreport {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		 ExtentReports extentreport=new ExtentReports();
		 File file=new File("report.html");
		 ExtentSparkReporter sparkReporte=new ExtentSparkReporter(file);
		 extentreport.attachReporter(sparkReporte);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.google.co.in/");
		 Thread.sleep(3000);
		
		 String path=capturing("google.png");
		 driver.get("https://www.facebook.co");
		 String path1=capturing("facebook.png");
        extentreport.createTest("screenshot Test1" ,"this is for attach the screens")
        .info("This is a info msg")
        .addScreenCaptureFromPath(path);
        extentreport.createTest("Screenshot Test2","this is for attach the screen")
        .info("This is info msg")
        .addScreenCaptureFromPath(path,"google homepage");
        extentreport.createTest("Screenshot Test3","this is for attach the screen")
        .info("This is info msg")
        .addScreenCaptureFromPath(path1);
        extentreport.createTest("Screenshot Test4","this is for attach the screen")
        .info("This is info msg")
        .addScreenCaptureFromPath(path1,"facebook homepage");
        extentreport.flush();
        
        driver.quit();
        Desktop.getDesktop().browse(new File("report.html").toURI());
	}
  public static String capturing(String file) throws IOException
  {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File destpath=new File("C:\\Users\\ASUS\\OneDrive\\newphoto"+file);
	  FileUtils.copyFile(src, destpath);
	  return destpath.getAbsolutePath();
  }
}
