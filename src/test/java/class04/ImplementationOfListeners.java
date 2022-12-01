package class04;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ImplementationOfListeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The Test has Passed: "+result.getName()+" / "+result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The Test has Failed: "+result.getName()+" / "+result.getTestName());
    }
}
