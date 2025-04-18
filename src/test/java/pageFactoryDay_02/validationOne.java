package pageFactoryDay_02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class validationOne {
	
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void verification() throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\gangafour.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		LogInPageone lginpage=new LogInPageone(driver);
		logoutpageone  lgoutpage=new logoutpageone (driver);
		
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println("the total number of rows "+rows);
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			XSSFCell user=row.getCell(0);
			XSSFCell password=row.getCell(1);
			XSSFCell result=row.createCell(2);
			
			System.out.println("username------->"+user+"            "+"password--------->"+password);
			try
			{
			lginpage.Url();
			lginpage.enterUserName(user.toString());
			lginpage.enterPassWord(password.toString());
			lginpage.ClickOnlogIn();
			
			lgoutpage.clickOnImg();
			lgoutpage.clickOnLogOut();
			
			result.setCellValue("valid data");
			System.out.println("valid data");
			}
			catch(Exception e)
			{
				result.setCellValue("invalid data");
				System.out.println("invalid data");
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
