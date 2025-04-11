package normalJavaProjeday_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicpagepractice {

	public static void main(String[] args) {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://testautomationpractice.blogspot.com/");
			
			int count=driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
			int rows=driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
			
			//System.out.println("total number of pages  "+count+"          totalnumber of rows  "+rows);
			for(int p=1;p<=count;p++)
			{
				for(int r=1;r<rows;r++)
				{
					driver.findElement(By.xpath("//ul[@id='pagination']/li["+p+"]")).click();
					driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td//input[@type='checkbox']")).click();
					//driver.findElement(By.xpath("//ul[@id='pagination']/li["+p+"]")).click();
				
				//driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td[4]")).click();
			}
			}
	}
	////table[@id='productTable']//tr//td[4]

}
