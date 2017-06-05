package ckt.App.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.log4testng.Logger;
import ckt.App.Util.AppiumBase;

public class TestngRetry implements IRetryAnalyzer {
	private static Logger logger = Logger.getLogger(TestngRetry.class);
	public  static  int retryCount = 1;
	private static int maxRetryCount;
	static {
		//外围文件配置最大运行次数
		maxRetryCount = AppiumBase.getMaxRunCount();
		logger.info("maxRunCount="+ (maxRetryCount));
	}

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message ="running retry for-" + result.getName() + "on class"+

					this.getClass().getName() + "Retrying "+ retryCount + " times";
					logger.info(message);
					Reporter.setCurrentTestResult(result);
					Reporter.log("RunCount=" + (retryCount + 1));
					retryCount++;
					return true;
		}
		return false;
	}

}