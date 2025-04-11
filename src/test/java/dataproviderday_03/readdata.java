package dataproviderday_03;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readdata {

	public static void main(String[] args) throws IOException {
		String path="C:\\Users\\ASUS\\OneDrive\\provide.xlsx";

		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("enter");

		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();

		System.out.println(rows+"   "+cols);
		//String[][] data=new String[rows-1][cols];

		for(int r=1;r<=rows;r++)
		{
			try {

				XSSFRow rr=sheet.getRow(r);
				XSSFCell cc=rr.getCell(0);
				XSSFCell cc1=rr.getCell(1);
				System.out.println(cc+"  "+cc1);}
			catch(Exception e)
			{
				System.out.println(e);
			}

		}

		{

			//return data;

			//System.out.println();
		}
		//  workbook.close();
		// fis.close();
		//  return data;

	}


}


