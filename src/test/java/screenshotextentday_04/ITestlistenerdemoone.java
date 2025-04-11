package screenshotextentday_04;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestlistenerdemoone extends baseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestContext().getName()+"_"+result.getName()+".png");
		capturescreen(result.getTestContext().getName()+"_"+result.getName()+".png");
		
	}

}
