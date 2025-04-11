import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataproviderday_06 {
   @DataProvider
	public String[][] getvalue()throws IOException {
		
		String path="C:\\Users\\ASUS\\OneDrive\\ganga.xlsx";
		FileInputStream fis=new FileInputStream(path);

		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int row=sheet.getPhysicalNumberOfRows();
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(row+"  "+col);
		String[][] data=new String[row-1][col];
		for(int r=0;r<row-1;r++)
		{
			for(int c=0;c<col;c++)
			{
				DataFormatter df=new DataFormatter();
			 data[r][c]=df.formatCellValue(sheet.getRow(r+1).getCell(c));
			}
		}
		
		workbook.close();
		fis.close();
		return data;
		/*(for(String[] dataarr:data)
		{
			System.out.println(Arrays.toString(dataarr));
		}
	}*/
  
   
}
}