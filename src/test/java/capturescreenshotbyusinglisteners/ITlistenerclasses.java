package capturescreenshotbyusinglisteners;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(capturescreenshotbyusinglisteners.ITestListenerDemo.class)

public class ITlistenerclasses extends BaseTest{
	@BeforeTest
	public void setup()
	{
		initialize();
	}
	
	@Test
	public void testgoogle()
	{
		driver.get("https://www.google.co.in/");
		String Acttit=driver.getTitle();
		String Exptit="goooleee";
		Assert.assertEquals(Acttit,Exptit );
	}
	@Test
	public void testfacebook()
	{
		driver.get("https://www.facebook.com/");
		String acttit=driver.getTitle();
		String exptit="faceeeboook";
		Assert.assertEquals(acttit, exptit);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
