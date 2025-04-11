package dataproviderday_03;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import dataproviderday_04.excelone;

public class excelutildataprovider {
	@DataProvider(name="true")
	public String[][] data() throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\bhavani.xlsx";
		excelone eo=new excelone(path,"Sheet1");
		int rr=eo.rows();
		int cc=eo.cols();
		String values[][]=new String[rr-1][cc];
			
		for(int r=1;r<rr;r++)
		{
			for(int c=0;c<=cc;c++)
			{
				String celldata=eo.getcelldata(r, c);
				//System.out.println(celldata+" | ");
				values[r-1][c]=celldata;
			}
		}
		return values;
	}
 
	
}
