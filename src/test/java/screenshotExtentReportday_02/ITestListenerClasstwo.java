package screenshotExtentReportday_02;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClasstwo extends BaseTesttwo implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			screen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
