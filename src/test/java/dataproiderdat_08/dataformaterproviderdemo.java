package dataproiderdat_08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataformaterproviderdemo {
   @DataProvider
	public String[][] getdata() throws IOException {
		String filepath="C:\\Users\\ASUS\\OneDrive\\new.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rw=sheet.getPhysicalNumberOfRows();
		int cl=sheet.getRow(0).getPhysicalNumberOfCells();
	
		String[][] value=new String[rw-1][cl];
		
		for(int r=0;r<rw-1;r++)
		{
			for(int c=0;c<cl;c++)
			{
				XSSFRow row=sheet.getRow(r);
				XSSFCell result=row.createCell(2);
			try {
				
				DataFormatter df=new DataFormatter();
				value[r][c]=df.formatCellValue(sheet.getRow(r+1).getCell(c));
				result.setCellValue("valid data");
			}
			catch(Exception e)
			{
				System.out.println("invalid data");
			   result.setCellValue("invalid data");
				//result.setCellValue("inavlid data");
			}
			}
		}
	
			
		
		//workbook.close();
	    fis.close();
		FileOutputStream fos=new FileOutputStream(filepath);
		workbook.write(fos);
		return value;
			
		
   }
		

}

   
