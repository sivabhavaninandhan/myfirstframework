package pageFactoryDay_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoutpageone {
	
	WebDriver driver;
	
	public logoutpageone(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver,this);
	}
 
	//Repository
	@FindBy (xpath="//span[@class='oxd-userdropdown-tab']/child::img") WebElement profilepic;
	@FindBy (xpath="//ul[@class='oxd-dropdown-menu']/li[4]") WebElement logoutbutton;
	
	public void clickOnImg()
	{
		profilepic.click();
	}
	public void clickOnLogOut()
	{
		logoutbutton.click();
	}
}

