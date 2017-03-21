package ckt.App.Listeners;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * Created by qiang.zhang on 2017/1/7.
 */
public class IIHookable implements IHookable {
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        //运行原始测试方法逻辑
        //iHookCallBack.runTestMethod(iTestResult);
    }
}
