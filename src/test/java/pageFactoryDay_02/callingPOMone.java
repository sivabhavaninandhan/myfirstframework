package pageFactoryDay_02;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class callingPOMone {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LogInPageone lginpage=new LogInPageone(driver);
		
		logoutpageone lgoutpage=new logoutpageone(driver);
		
		lginpage.Url();
		lginpage.enterUserName("Admin");
		lginpage.enterPassWord("admin123");
		lginpage.ClickOnlogIn();
		
		lgoutpage.clickOnImg();
		lgoutpage.clickOnLogOut();

	}

}
