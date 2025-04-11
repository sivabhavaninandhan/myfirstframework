package extentreportscreenshot;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerclassfour extends BaseClass implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
	     System.out.println(result.getMethod().getMethodName());
			try {
				capturescreens(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
	}


}
