package screenshotday_05;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(screenshotday_05. ITestListenerClass.class)
public class testclass extends basescrn {
	@BeforeClass
	public void setting()
	{
		initiliaze();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
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
	
	
}
