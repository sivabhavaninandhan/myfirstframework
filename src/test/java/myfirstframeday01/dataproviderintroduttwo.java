package myfirstframeday01;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataproviderintroduttwo {
  @DataProvider(name="value")
	public String[][] log() throws IOException {
String path="C:\\Users\\ASUS\\OneDrive\\provide.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("enter");
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();
		
		System.out.println(rows+"   "+cols);
		String[][] data=new String[rows][cols];
		
		for(int r=1;r<=rows;r++)
		{
			for(int c = 0 ;c<cols;c++)
			{
		 data[r-1][c]=sheet.getRelationId(sheet);
			}
			 
				}
		
				{
		
				return data;
		
			//System.out.println();
		}
  //  workbook.close();
   //fis.close();
  //  return data;

	}

}
