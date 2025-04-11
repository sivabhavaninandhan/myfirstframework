package day_02datadriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamictableone {

	public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/admin/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
			WebElement us=driver.findElement(By.id("input-username"));
			us.clear();
			us.sendKeys("demo");
			WebElement pwd=driver.findElement(By.id("input-password"));
			pwd.clear();
			pwd.sendKeys("demo");
			
			driver.findElement(By.xpath("//button[@type='submit']/child::i")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//ul[@id='menu']/li[5]")).click();
			
			driver.findElement(By.xpath("//ul[@class='collapse show']/li[1]/a")).click();
			Thread.sleep(3000);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1900)");
			Thread.sleep(3000);
			
	String totalpage=driver.findElement(By.xpath("//div[contains(text(),' Pages')]")).getText();
	System.out.println(totalpage);
	String currentpage=totalpage.substring(25 ,28);
	System.out.println(currentpage);
	//int pages=Integer.parseInt(totalpage.substring(totalpage.indexOf("(")+1),totalpage.indexOf("Pages")-1);
	//System.out.println("total pages are :"+pages);
			int page=Integer.parseInt(currentpage); 
			
			for(int p=1;p<=5;p++)
			{
				if(p>1)
				{
				WebElement activepage=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				activepage.click();
				Thread.sleep(3000);
			}
   int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
   
   for(int r=1;r<rows;r++)
   {
	String custmordata=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
	String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
	String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[4]")).getText();
	
	System.out.println(custmordata+"    "+email+"   "+status);
	Thread.sleep(3000);
   }
	}

}
}