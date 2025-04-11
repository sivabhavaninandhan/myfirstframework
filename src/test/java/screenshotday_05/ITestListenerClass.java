package screenshotday_05;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import extentreportscreenshot.BaseClass;

public class ITestListenerClass extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) 
	{
	     System.out.println(result.getMethod().getMethodName());
			try {
				capturescreens(result.getName()+".jpg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
	}

}
