package utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners_refill extends Basecls implements ITestListener {

	public static ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		System.out.println("***Test Started****");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		System.out.println("***Test Passed****");
	}

	public void onTestFailure(ITestResult result)
	{
		ExtentTest img;
		try {
			img = test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.INFO, "Image example :" + img);
			test.fail(result.getThrowable());
			System.out.println("***Test Failed -- Screenshot captured !!!***");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("***Test Skipped!!!***");
	}
}
