package CapturescreenITestlistenerday_06;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataDriventestCase {
	
	@DataProvider
	public String[][] validdata() throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\gangasix.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rws=sheet.getPhysicalNumberOfRows();
		int cls=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] exceldata=new String[rws-1][cls];
		
		for(int r=0;r<rws-1;r++)
		{
			for(int c=0;c<cls;c++)
			{
				DataFormatter df=new DataFormatter();
				exceldata[r][c]=df.formatCellValue(sheet.getRow(r+1).getCell(c));
			}
		}
		fis.close();
		return exceldata;
	}

}
