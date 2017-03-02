package ckt.ios.testcase.me;

import io.appium.java_client.MobileElement;

import java.awt.Color;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.ios.action.LoginAction;

public class TC2 extends VP {
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		startAppium();
	}
	@AfterClass
	public void afterClass() {
		stopAppium();
	}
	@BeforeMethod
	public void BeforeTest(){
		LoginAction.inLoginStatus();
	}
	@Test
	public void testSignature60c(){
		//desired_caps['automationName'] = 'Uiautomator2'
		
//	    driver.startActivity("com.testerhome.webview", ".ToastActivity");
		/*iosdriver.findElementById("com.testerhome.webview:id/clickToToastActivity").click();
	    MobileElement toastButton = (MobileElement) iosdriver.findElementById("com.testerhome.webview:id/toast");
	    toastButton.click();
	    System.out.println(iosdriver.findElementByXPath(".//*[contains(@text,'Toast Test')]").getText());*/
	    ////UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]
	    
	    /*Assert.assertNotNull(wait.until(
	            ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'Toast Test')]"))));*/
	    //waitUntilFind(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]"), 10);
	   Draw.takeScreenShot(Color.RED);
	   Draw.takeScreenShot(Color.BLACK);
		WebDriverWait wait = new WebDriverWait(iosdriver, 10);
		 wait.until(ExpectedConditions.textToBe(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]"), "我我"));;
	}
}
