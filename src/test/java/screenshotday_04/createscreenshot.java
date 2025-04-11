package screenshotday_04;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import screenshotday_05.basescrn;

public class createscreenshot  {
	
	WebDriver driver;
	@BeforeClass
	public void set()
	{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	
	@Test
	
	public void validation() throws IOException, InterruptedException
	
	{

		screenshotintro sc=new screenshotintro();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		sc.screen(driver, "loginpage1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/child::img")).click();
		sc.screen(driver, "logoutpage2");
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
	    sc.screen(driver,"logoutpage");
	    
	}

}
