package dataproviderday_03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import myfirstframeday01.dataproviderintroduttwo;

public class integratedintoTestNgtwo {
	
	WebDriver driver;
	@BeforeClass
	
	public void setdata()
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(dataProvider="value",dataProviderClass=dataproviderintroduttwo.class)
	
	public void validation(String user,String pass)
	{
		driver.findElement(By.name("username")).sendKeys(user.toString());
		driver.findElement(By.name("password")).sendKeys(pass.toString());
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/child::img")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
	}

}
