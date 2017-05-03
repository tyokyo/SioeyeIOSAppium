package ckt.App.Listeners;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;
import org.uncommons.reportng.Reporters;

import ckt.App.Util.AppiumBase;
import ckt.App.Util.Draw;
import ckt.App.Util.Log;
import ckt.main.TestNgXml;

public class TestngListener extends TestListenerAdapter {
	private static Logger logger = Logger.getLogger(TestngListener.class);

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		Log.info(tr.getName() + " Failure");
		takeScreenShot(tr);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		Log.info(tr.getName() + " Skipped");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		Log.info(tr.getName() + " Success");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		String className=tr.getTestClass().getName();
		String methodName=tr.getMethod().getMethodName();
		Log.info(" Start to Run:"+className+"#"+methodName);
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		//super.onFinish(testContext);
		Iterator<ITestResult> listOfFailedTests = iTestContext.getFailedTests().getAllResults().iterator();
		while (listOfFailedTests.hasNext()) {
			ITestResult failedTest = listOfFailedTests.next();
			ITestNGMethod method = failedTest.getMethod();
			if (iTestContext.getFailedTests().getResults(method).size() > 1) {
				listOfFailedTests.remove();
			} else {
				if (iTestContext.getPassedTests().getResults(method).size() > 0) {
					listOfFailedTests.remove();
				}
			}
		}
		Log.info("End to Run");
	}

	private void takeScreenShot(ITestResult tr) {
		int width = AppiumBase.iosdriver.manage().window().getSize().width;  
		int height = AppiumBase.iosdriver.manage().window().getSize().height;  

		String className=tr.getTestClass().getName();
		String methodName=tr.getMethod().getMethodName();
		String folderString = className+"."+methodName;
		System.out.println(folderString);
		folderString=folderString.replaceAll("['.']", "/");
		System.out.println(folderString);
		File folder = new File(TestNgXml.screenshotFolder+"/"+folderString);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		System.out.println(folder.getAbsolutePath());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String mDateTime = formatter.format(new Date());
		//String screenName = mDateTime+"_"+tr.getMethod().getMethodName()+".png";
		String screenName = mDateTime+".png";
		//String screenShotPath = location.getAbsolutePath()+File.separator+screenName;
		String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
		File screenShot = AppiumBase.iosdriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			Draw.takeDrawRect(screenShotPath, Color.RED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.setCurrentTestResult(tr);
		//Reporter.log("<img src=\"" + screenShotName + "/>");
		Reporters.logInfo("<br><img src=../screenshot/" + folderString+"/"+screenName + "  onclick='window.open(\"../screenshot/"+folderString+"/"+screenName+")'"+"  height='"+height+"'  width='"+width+"'/>");
		//Reporter.log("<img src=\"../screenshot/" +folderString+"/"+ screenName + "\"/>");
	}
}