package dataproviderday_09;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class excelutildataprovider {
	
	
	@DataProvider
	public String[][] logdata() throws IOException
	{
		String path="C:\\Users\\ASUS\\OneDrive\\ganga.xlsx";
		
		exceltwo et=new exceltwo(path,"Sheet1");
		
		int rr=et.getRowCount();
		int cc=et.getCellCount();
		String[][] data=new String[rr-1][cc];
		for(int r=1;r<rr;r++)
		{
			for(int c=0;c<cc;c++)
			{
				String celldata=et.getcelldata(r, c);
				data[r-1][c]=celldata;
			}
		
		}
		return data;
	}

}
