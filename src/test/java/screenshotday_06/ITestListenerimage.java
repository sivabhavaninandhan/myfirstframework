package screenshotday_06;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerimage extends baseimg implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			captureImg(result.getName()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("screen shot saved");
	}

}
