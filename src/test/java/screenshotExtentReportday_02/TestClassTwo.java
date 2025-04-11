package screenshotExtentReportday_02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassTwo extends BaseTesttwo{
	
	@Test
	public void testgoogles()
	{
	driver.get("https://www.google.co.in/");
	driver.findElement(By.name("q")).sendKeys("Hyderabad");
    String exptitle="Googlee";
	String acttitle=driver.getTitle();
	Assert.assertEquals(exptitle,acttitle);
	}
	@Test
	public void testfacebooks()
	{
		driver.get("https://www.facebook.com/");
		String exptitle="Facebooku – log in or sign up";
		String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle,exptitle);
		
	}

	@Test
	public void testorangahrms()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.getTitle().contains("welcome"));
		
	}

}
