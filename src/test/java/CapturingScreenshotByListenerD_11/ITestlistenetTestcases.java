package CapturingScreenshotByListenerD_11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ITestlistenetTestcases extends BaseTestone{
	
	@Test
	
	public void testDynamicTable()
	{
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy (0,800)");
		
		List<WebElement> optns=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[1]"));
		System.out.println(optns.size());
		
		for(int r=1;r<=optns.size();r++)
		{
			WebElement name=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+r+"]/td[1]"));
			if(name.getText().equals("Chrome"))
			{
				String cpuvalue=driver.findElement(By.xpath("//td[normalize-space()='Chrome']/following-sibling::*[contains(,'')]")).getText();
				String value=driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				if(value.contains(cpuvalue))
				{
					System.out.println("the cpu value is equal");
				}
				else
				{
					System.out.println("the cpu value is not equal");
				}
			}
		}
	}

}
