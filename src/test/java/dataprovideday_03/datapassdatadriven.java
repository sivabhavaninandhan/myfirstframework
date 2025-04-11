package dataprovideday_03;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class datapassdatadriven {
	
	@DataProvider
	public Object[][] values() throws IOException
	{
		excelutil eu=new excelutil("C:\\Users\\ASUS\\OneDrive\\data2.xlsx", "Sheet1");
		
	int rr=eu.getrow();
	int cc=eu.getcol();
	
	Object data[][]=new Object[rr-1][cc];
	
	for(int r=0;r<rr;r++)
	{
		for(int c=0;c<cc;c++)
		{
			String celdata=eu.getcelldata(r, c);
		System.out.println(r+"    "+c);
		}
	}
	
	
	
	return data;
	
	}

}
