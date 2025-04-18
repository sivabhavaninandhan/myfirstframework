package DataDriventestingfour;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataformaterfour {
	
	@DataProvider
	public String[][] testing() throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\gangathree.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
	
		int rws=sheet.getPhysicalNumberOfRows();
		int cels=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] values=new String[rws-1][cels];
		for(int r=0;r<rws-1;r++)
		{
			for(int c=0;c<cels;c++)
			{
				XSSFRow row=sheet.getRow(0);
        		XSSFCell result=row.createCell(2);
            try
            {
				DataFormatter df=new DataFormatter();
				values[r][c]=df.formatCellValue(sheet.getRow(r+1).getCell(c));
				result.setCellValue("valid data");
            }
            catch(Exception e)
            {
            	result.setCellValue("invalid data");
            }
			}
		}
	    
		FileOutputStream fos=new FileOutputStream(path);
		workbook.write(fos);
		return values;
	}

}

