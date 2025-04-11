package pageFactoryDay_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	WebDriver driver;
	public loginpage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);		
	}
   //Repository
	
	@FindBy (name="username") WebElement username;
	@FindBy (name="password") WebElement passwrd;
	@FindBy (xpath="//button[@type='submit']") WebElement loginbutn;
	
	public void Url()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	public void enterUserName(String us)
	{
		username.sendKeys(us);
	}
	public void enterPassWord(String psw)
	{
		passwrd.sendKeys(psw);
	}
	public void clickOnLogIn()
	{
		loginbutn.click();
	}
}
