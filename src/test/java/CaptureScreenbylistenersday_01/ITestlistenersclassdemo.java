package CaptureScreenbylistenersday_01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ITestlistenersclassdemo extends BaseTest1 {

	
		
		@Test(testName="TestGoogle")
		public void testgoogle()
		{
			driver.get("https://www.google.co.in/");
			String Acttit=driver.getTitle();
			String Exptit="goooleee";
			Assert.assertEquals(Acttit,Exptit );
		}
		@Test(testName="TestFaceBook")
		public void testfacebook()
		{
			driver.get("https://www.facebook.com/");
			String acttit=driver.getTitle();
			String exptit="faceeeboook";
			Assert.assertEquals(acttit, exptit);
		}
		
	}

