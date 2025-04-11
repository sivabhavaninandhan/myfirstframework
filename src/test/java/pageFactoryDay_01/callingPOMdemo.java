package pageFactoryDay_01;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class callingPOMdemo {

	public static void main(String[] args) {
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  loginpage lgnpg=new loginpage(driver);
		  logoutpage lgutpg=new logoutpage(driver);
		  
		  lgnpg.Url();
		 
		  lgnpg.enterUserName("Admin");
		  lgnpg.enterPassWord("admin123");
		  lgnpg.clickOnLogIn();
		  
		  lgutpg.clickOnImg();
		  lgutpg.clickOnLogOut();

	}

}
