package dataproviderday_03;

import java.io.IOException;

import dataproviderday_04.excelone;

public class readdatre {

	public static void main(String[] args) throws IOException {
		String path="C:\\Users\\ASUS\\OneDrive\\bhavani.xlsx";
		excelone eo=new excelone(path,"Sheet1");
		int rr=eo.rows();
		int cc=eo.cols();
		String values[][]=new String[rr][cc];
			
		for(int r=1;r<rr;r++)
		{
			for(int c=0;c<cc;c++)
			{
				String celldata=eo.getcelldata(r, c);
				System.out.println(celldata+" | ");
				//values[r-1][c]=eo.getcelldata(r, c);
			}
		}

	}

}
