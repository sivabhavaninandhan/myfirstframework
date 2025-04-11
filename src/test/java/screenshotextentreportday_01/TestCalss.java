package screenshotextentreportday_01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalss extends BaseTest{	
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
