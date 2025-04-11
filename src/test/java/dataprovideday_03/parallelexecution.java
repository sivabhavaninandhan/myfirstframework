package dataprovideday_03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parallelexecution {
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@Test(dataProvider="logdata")
	public void verification(String usnm,String pwd)
	{
		driver.findElement(By.name("username")).sendKeys(usnm);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/child::img")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
	}

	@DataProvider
	public Object[][] logdata()
	{
		Object[][] data= {{"Admin","admin123"},{"Admin","test123"},{"dfrc","qwer123"},{"kluty","optyr1223"},{"qasdf","asdf123"},{"Admin","admin123"}};
		return data;
	}
}
