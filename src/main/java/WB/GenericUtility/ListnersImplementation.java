package WB.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * @author SanjayGiri
 */
public class ListnersImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName+"---------Execution started--------");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName+"-----------PASS---------");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName+"----------FAIL----------");
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName+"-----------SKIPPED----------");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("----Suite execution started-----");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("-------Suite execution finished-------");
		
	}
	
	
	

}
