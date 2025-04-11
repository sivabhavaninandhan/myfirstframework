package screenshotday_05;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class lTestListenerclassone extends basescrn implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			capturescreen(result.getMethod().getMethodName()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println("scerrn shot saved");
	}

}
