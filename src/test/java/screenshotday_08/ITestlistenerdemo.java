package screenshotday_08;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestlistenerdemo extends baseimgone implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			captureimg(result.getName()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
