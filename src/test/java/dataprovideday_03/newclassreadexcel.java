package dataprovideday_03;

import java.io.IOException;

public class newclassreadexcel {

	public static void main(String[] args, String sheetname) throws IOException {
		
		
		
		
		String path="C:\\Users\\ASUS\\OneDrive\\data2.xlsx";
		excelutil ex=new excelutil(path,sheetname);
		ex.getrow();
		ex.getcelldata(0, 0);

	}

}
