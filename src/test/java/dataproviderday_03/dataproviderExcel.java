package dataproviderday_03;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataproviderExcel {
   @DataProvider(name="logdata")
	public String[][] getdata() throws IOException
	{
		
		String path="C:\\Users\\ASUS\\OneDrive\\datapro.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum();
     	int cols=sheet.getRow(1).getLastCellNum();
		
		System.out.println(rows+"   "+cols);
		String[][] data=new String[rows-1][cols];
		for(int r=0;r<rows-1;r++)
		{
			for(int c=0;c<cols;c++)
			{
				try {
			 DataFormatter df=new DataFormatter();
			 data[r-1][c]=df.formatCellValue(sheet.getRow(r+1).getCell(c));
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
			//System.out.println();
		}
    workbook.close();
    fis.close();
    return data;
    
   /* for(String[] dataarr:data)
    {
    	System.out.println(Arrays.toString(dataarr));
    }*/
	}
	

}
