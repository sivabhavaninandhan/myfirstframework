package dataproviderRealday_10;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutiltwo {
	
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public excelutiltwo(String excelpath,String sheetname) throws IOException
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
		int cellcnt=0;
		cellcnt=sheet.getRow(0).getPhysicalNumberOfCells();
		return cellcnt;
	}
	
	public String getcelldata(int rowNum,int cellNum)
	{
		String celldata;
		celldata=sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return celldata;
	}
}
