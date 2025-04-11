package extentreportday_01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreportXMLJSONbased {

	public static void main(String[] args) throws IOException {
		 ExtentReports extentreport=new ExtentReports();
		 File file=new File("report.html");
		 ExtentSparkReporter sparkreporter=new ExtentSparkReporter(file);
		 extentreport.attachReporter(sparkreporter);
		 
		 String xmlData="<menu id=\"file\" value=\"File\">\r\n"
		 		+ "  <popup>\r\n"
		 		+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
		 		+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
		 		+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
		 		+ "  </popup>\r\n"
		 		+ "</menu>";
		 String jsonData="{\"menu\": {\r\n"
		 		+ "  \"id\": \"file\",\r\n"
		 		+ "  \"value\": \"File\",\r\n"
		 		+ "  \"popup\": {\r\n"
		 		+ "    \"menuitem\": [\r\n"
		 		+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
		 		+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
		 		+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
		 		+ "    ]\r\n"
		 		+ "  }\r\n"
		 		+ "}}";
		 
		 extentreport.createTest("XML based Test")
		 .info(MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
		 extentreport.createTest("JSON based Test")
		 .log(Status.FAIL,MarkupHelper.createCodeBlock(jsonData,CodeLanguage.JSON));
		 
		List<String> listData=new ArrayList<>();
		listData.add("rose");
		listData.add("beaut");
		listData.add("flower");
		
		Map<Integer,String> mapData=new HashMap<>();
		mapData.put(101,"jasmin");
		mapData.put(102,"hybiscus");
		mapData.put(103,"rosy");
		
		Set<Integer> setdata=mapData.keySet();
		
		extentreport.createTest("List based Test")
		.info(MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));
		
		extentreport.createTest("map based Test")
		.info(MarkupHelper.createOrderedList(mapData));
		
		extentreport.createTest("set based Test")
		.info(MarkupHelper.createOrderedList(setdata));
		
		extentreport.createTest("Highlight log Test")
		.info(MarkupHelper.createLabel("this is highlight message", ExtentColor.ORANGE));
		
		try {
			int i=5/0;}
			catch(Exception e )
			{
			extentreport.createTest("Exception Test1")
			.info(e);
		}
		
		Throwable t=new RuntimeException("This is custom Exception");
		extentreport.createTest("Exception Test2")
		.info(t);
		
		
		 extentreport.flush();
		 Desktop.getDesktop().browse(new File("report.html").toURI());	 

	}

}
