package dataproviderindataformaterDay_10;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataformationone {
	@DataProvider
	public String[][] verify() throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\ganga.xlsx";
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rw=sheet.getPhysicalNumberOfRows();
		int cl=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] passvalues=new String[rw-1][cl];
		
		for(int r=0;r<rw-1;r++)
		{
			for(int c=0;c<cl;c++)
			{
				DataFormatter df=new DataFormatter();
				
				passvalues[r][c]=df.formatCellValue(sheet.getRow(r+1).getCell(c));
			}
		}
		fis.close();
		return passvalues;

	}

}
