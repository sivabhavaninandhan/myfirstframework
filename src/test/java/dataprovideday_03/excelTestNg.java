package dataprovideday_03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class excelTestNg {
	
	WebDriver driver;
	@BeforeClass
	public void setup()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	
}
	@Test(dataProvider="use",dataProviderClass= dataprovideExcelUtil.class)
	
	public void result(String usnm,String pswd)
	{
				
		driver.findElement(By.name("username")).sendKeys(usnm);
		driver.findElement(By.name("password")).sendKeys(pswd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/child::img")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
		
		}
	}



