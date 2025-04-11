 package dataprovideday_03;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutil {
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public excelutil(String excelpath,String sheetname) throws IOException
	{
		projectpath=System.getProperty("user.dir");
		workbook=new XSSFWorkbook(excelpath);
		sheet=workbook.getSheet(sheetname);
	}

	public int getrow()
	{ 
		try {
		int rowcnt;
		 rowcnt=sheet.getLastRowNum();
		//System.out.println(rowcnt);
		 return rowcnt;}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
		
	}
	public int getcol()
	{
		try {
		int colcnt;
		 colcnt=sheet.getRow(1).getLastCellNum();
		//System.out.println(colcnt);
		return colcnt;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
	public String getcelldata(int rowNum,int colNum)
	{
		String celldata;
	 celldata=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
   //System.out.println(celldata);
	 return celldata;
	}

}
