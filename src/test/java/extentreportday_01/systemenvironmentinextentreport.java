package extentreportday_01;

import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class systemenvironmentinextentreport {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Capabilities capabilities=((RemoteWebDriver) driver).getCapabilities();
		
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getBrowserVersion());

	}

}
