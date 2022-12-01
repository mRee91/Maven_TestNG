package class03;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The Test has Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The Test has Failed");
    }


}
