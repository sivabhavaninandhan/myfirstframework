package datadrivernTestngPagefactoryone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageFactoryDay_01.loginpage;
import pageFactoryDay_01.logoutpage;

public class validationdata {
	
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void verify() throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\gangaone.xlsx";
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		loginpage lgnpg=new loginpage(driver);
		  logoutpage lgutpg=new logoutpage(driver);
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println("total number of rows "+rows);
		
		for(int r=1;r<rows;r++)
		{
			XSSFRow rw=sheet.getRow(r);
			XSSFCell user=rw.getCell(0);
			XSSFCell pass=rw.getCell(1);
			XSSFCell result=rw.createCell(2);
			System.out.println("UserName------>"+user+"         password------>"+pass);
			try {
			 lgnpg.Url();
			 
			  lgnpg.enterUserName(user.toString());
			  lgnpg.enterPassWord(pass.toString());
			  lgnpg.clickOnLogIn();
			  
			  lgutpg.clickOnImg();
			  lgutpg.clickOnLogOut();
			  result.setCellValue("valid data");
			  System.out.println("valid data");
			}
			catch(Exception e)
			{
				System.out.println("inavalid data");
				String errormsg=driver.findElement(By.xpath("//div[@id='app']/descendant::p[1]")).getText();
				result.setCellValue(errormsg);
			}
			  
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(path);
		workbook.write(fos);
		
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
