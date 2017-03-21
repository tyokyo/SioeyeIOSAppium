package ckt.App.Listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by qiang.zhang on 2017/1/7.
 */
public class ITestListenerAdapter extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
    }
}
