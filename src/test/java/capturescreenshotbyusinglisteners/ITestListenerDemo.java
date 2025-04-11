package capturescreenshotbyusinglisteners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerDemo extends BaseTest implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			capturescreen(result.getMethod().getMethodName()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
