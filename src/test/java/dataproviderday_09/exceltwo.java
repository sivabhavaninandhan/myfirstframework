package dataproviderday_09;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceltwo {
	
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public exceltwo(String excelpath,String sheetname) throws IOException
	{
		projectpath=System.getProperty("user.dir");
		workbook=new XSSFWorkbook(excelpath);
		sheet=workbook.getSheet(sheetname);
	}
	public int getRowCount()
	{
		int rowcnt=0;
		rowcnt=sheet.getPhysicalNumberOfRows();
		return rowcnt;
	}

	public int getCellCount()
	{
		int celcnt=0;
		celcnt=sheet.getRow(0).getPhysicalNumberOfCells();
		return celcnt;
	}
	public String getcelldata(int rowNum,int celNum)
	{
		String celldata;
		celldata=sheet.getRow(rowNum).getCell(celNum).getStringCellValue();
		return celldata;
	}
}
