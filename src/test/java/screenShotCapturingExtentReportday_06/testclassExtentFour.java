package screenShotCapturingExtentReportday_06;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testclassExtentFour extends BaseClassExtentFour{
	@Test(testName="TestOrangeHRM" , groups= {"smoke"})
	  public void testorange()
	  {
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 extentTest.info("navigation to URL");
		  String acttit=driver.getTitle();
		  String exptit="OrangeHRM";
		  Assert.assertEquals(acttit, exptit);
		  extentTest.info("Assertion is passed for webpage title");
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
