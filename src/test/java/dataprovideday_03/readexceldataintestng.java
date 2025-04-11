 package dataprovideday_03;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readexceldataintestng {
	
	
	@Test
	
	public void readdata() throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\datapro.xlsx";
		XSSFWorkbook workbook=new XSSFWorkbook(path);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows=sheet.getLastRowNum();
		System.out.println("the total rows "+rows);
		
		for(int r=1;r<=rows;r++)
		{
			XSSFRow rws=sheet.getRow(r);
			XSSFCell c1=rws.getCell(0);
			XSSFCell c2=rws.getCell(1);
			System.out.println(c1+"    "+c2);
		}
		
	}

}
