package amazonday_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_002 {

	public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.amazon.in/");
			
			driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'Need help')] ")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("  //a[normalize-space()='Forgot Password']")).click();
			
			String passcode="azsn hbuk rvhr rzci";
			String email="gangasatyakadali@gmail.com";
			
			driver.findElement(By.id("ap_email")).sendKeys(email);
			driver.findElement(By.id("continue")).click();
			
			
			 
			

	}

}
