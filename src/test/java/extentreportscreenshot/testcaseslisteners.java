package extentreportscreenshot;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testcaseslisteners extends BaseClass{

	@Test(groups= {"Smoke"})
	public void testgooglee()
	{
	driver.get("https://www.google.co.in/");
	extentTest.info("navigate to url");
	driver.findElement(By.name("q")).sendKeys("Hyderabad");
    String exptitle="Googlee";
	String acttitle=driver.getTitle();
	Assert.assertEquals(exptitle,acttitle);
	extentTest.fail("this is failed");
	}
	@Test(groups= {"Sanity","Regression"})
	public void testfacebooks()
	{
		driver.get("https://www.facebook.com/");
		extentTest.info("navigate to browser");
		String exptitle="Facebooku – log in or sign up";
		String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle,exptitle);	
		extentTest.fail("assertion is failed this is failed");
	}
	
	@Test(groups= {"smoke"})
	public void testorangahrms()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		extentTest.info("navigate in to browser");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String exptitle="OrangeHRm";
		String acttitle=driver.getTitle();
		Assert.assertEquals(exptitle, acttitle);
		
		
		
		
	}
}
