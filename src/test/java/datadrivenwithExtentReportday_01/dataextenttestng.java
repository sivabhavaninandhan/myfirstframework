package datadrivenwithExtentReportday_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataproviderindataformaterDay_10.dataformationone;

public class dataextenttestng extends BaseDatadriverdemo{
	
	/*WebDriver driver;
	@BeforeClass
	public void setup()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	
}*/
	@Test(testName="TestORNGHRM",dataProvider="verify",dataProviderClass=dataformationone.class)
	
	public void testOrangeHRMone(String usnm,String pswd)
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(usnm);
		driver.findElement(By.name("password")).sendKeys(pswd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/child::img")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
	}
	
	 @Test(testName="TestGoogle",groups= {"smoke","regression"})
		public void testgooglee()
		{
		driver.get("https://www.google.co.in/");
		extentTest.info("navigate to browser");
		driver.findElement(By.name("q")).sendKeys("Hyderabad");
	  String exptitle="Googlee";
		String acttitle=driver.getTitle();
		Assert.assertEquals(exptitle,acttitle);
		extentTest.fail("Assertion is failed for webpage title");
		}
		@Test(testName="TestFaceBook",groups= {"sanity"})
		public void testfacebooks()
		{
			driver.get("https://www.facebook.com/");
			extentTest.info("navigate to URL");
			String exptitle="Facebooku – log in or sign up";
			String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle,exptitle);
		extentTest.info("Assertion is failed for webpage title verfication");
			
		}



}
