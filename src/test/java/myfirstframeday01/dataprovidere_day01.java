package myfirstframeday01;

import org.testng.annotations.DataProvider;

public class dataprovidere_day01 {
	
	@DataProvider
	public Object[][] getdata()
	{
		Object data[][]= {{"Admin","admin123"},{"asdf","cv123"},{"klmn","98asd"},{"Admin","admin123"}};
		return data;
	}
	
}

		

