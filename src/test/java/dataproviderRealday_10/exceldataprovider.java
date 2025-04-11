package dataproviderRealday_10;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class exceldataprovider {

	@DataProvider
   public String[][] logdatas() throws IOException
   {
		String path="C:\\Users\\ASUS\\OneDrive\\bhavanione.xlsx";
		
		excelutiltwo ext=new excelutiltwo(path,"Sheet1");
		
		int rr=ext.getRowCount();
		int cc=ext.getCellCount();
		
		String[][] data=new String[rr-1][cc];
		for(int r=1;r<rr;r++)
		{
			for(int c=0;c<cc;c++)
			{
				String celldata=ext.getcelldata(r, c);
				data[r-1][c]=celldata;
			}
		}
		return data;
   }
}
