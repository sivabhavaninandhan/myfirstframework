package pageFactoryDay_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPageone {
	
	WebDriver driver;
	
	public LogInPageone(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);
	}

	//Repository
	
	@FindBy (name="username") WebElement username;
	@FindBy (name="password") WebElement password;
	@FindBy (xpath="//button[@type='submit']") WebElement loginbutton;
	
	public void Url()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	public void enterUserName(String usrnm)
	{
		username.sendKeys(usrnm);
	}
	public void enterPassWord(String pswd)
	{
		password.sendKeys(pswd);
	}
	public void ClickOnlogIn()
	{
		loginbutton.click();
	}
}
