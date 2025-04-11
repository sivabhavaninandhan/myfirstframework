package myfirstframeday01;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datadriverintroduct {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String path="C:\\Users\\ASUS\\OneDrive\\newdata.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rows=sheet.getLastRowNum();
		System.out.println("the total rows are  :"+rows);
	
		for(int r=1;r<=rows;r++)
		{
			try {
			XSSFRow rrs=sheet.getRow(r);
			XSSFCell usernm=rrs.getCell(0);
			XSSFCell passwd=rrs.getCell(1);
			System.out.println(usernm+"     "+passwd);
		driver.findElement(By.name("username")).sendKeys(usernm.toString());
		driver.findElement(By.name("password")).sendKeys(passwd.toString());
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/child::img")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
			}
			catch(Exception e)
			{
				System.out.println("invaliddata");
			}
		}

		
workbook.close();
fis.close();
		
		
	
		}
	
}


