package normalJavaProjeday_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassMouseOver {

	public static void main(String[] args) {
	     WebDriver driver=new ChromeDriver();
	     driver.get("https://tutorialsninja.com/demo/index.php?");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     
	     WebElement desktop=driver.findElement(By.xpath("//a[text()='Desktops']"));
	     WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
	     
	     Actions act=new Actions(driver);
	     act.moveToElement(desktop).moveToElement(mac).click().build().perform();
	     

	}

}
