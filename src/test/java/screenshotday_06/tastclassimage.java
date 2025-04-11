package screenshotday_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(screenshotday_06.ITestListenerimage.class)
public class tastclassimage extends baseimg{
	
	@BeforeTest
	public void setdata()
	{
		setimag();
		
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();;
	}
	@Test
  public void testorange()
  {
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  String acttit=driver.getTitle();
	  String exptit="OrangeHRM";
	  Assert.assertEquals(acttit, exptit);
  }
  @Test
	public void testgooglee()
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
