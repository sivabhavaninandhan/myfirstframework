package pageFactoryDay_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoutpage {
	
	WebDriver driver;
	
	public logoutpage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
//Repository
	
	@FindBy (xpath="//span[@class='oxd-userdropdown-tab']/child::img") WebElement imgpic;
	@FindBy (xpath="//ul[@class='oxd-dropdown-menu']/li[4]") WebElement LogOutBtn;
	
	public void clickOnImg()
	{
		imgpic.click();
	}
	public void clickOnLogOut()
	{
		LogOutBtn.click();
	}
	
}
