package dataprovideday_03;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataprovideExcelUtil {
	@DataProvider(name="use")
	public String[][] data() throws IOException
	{
	
	String path="C:\\Users\\ASUS\\OneDrive\\datapro.xlsx";
	
	excelutil ex=new excelutil(path,"Sheet1");
	
	int totalrows=ex.getrow();
	int totalcol=ex.getcol();
	
	String logdata[][]=new String[totalrows][totalcol];
	
	for(int i=1;i<totalrows;i++)
	{
		for(int j=0;j<totalcol;j++)
		{
			logdata[i-1][j]=ex.getcelldata(i, j);
			
		}
		
	}
	return logdata;

	
	}
}
