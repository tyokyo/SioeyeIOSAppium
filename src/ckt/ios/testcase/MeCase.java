package ckt.ios.testcase;

import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ckt.App.Util.VP;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;

public class MeCase extends VP {
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		startAppium();
	}
 
	@AfterClass
	public void afterClass() {
		stopAppium();
	}
	@Test
	public  void testLogout(){
		LoginAction.logOutAccount();
	}
	@Test
	public void WatchAndSignUp2() throws InterruptedException {
		//iosdriver.findElementByName("我").click();
		text_exist("登录");
		if (LoginAction.isLogin()) {
			iosdriver.findElement(By.name("登录")).click();
			iosdriver.hideKeyboard();
			System.out.println(iosdriver.getPageSource());
			MobileElement  mb = ((MobileElement)iosdriver.findElement(By.className("UIATextField")));
			Assert.assertEquals(true, false);
			
			System.out.println(mb.getText());
			//mb.swipe(SwipeElementDirection.LEFT, 2);
			
			mb.setValue("1212");
			//iosdriver.findElement(By.className("UIATextField")).sendKeys("");
			Thread.sleep(3000);
			
			//iosdriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]")).sendKeys("tyokyo");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertEquals(true, true);
		}
		
		//driver.findElementByName("Login").click();
	}
	@Test
	public void WatchAndSignUp1() throws InterruptedException {
		//iosdriver.findElementByName("我").click();
		text_exist("登录");
		if (LoginAction.isLogin()) {
			iosdriver.findElement(By.name("登录")).click();
			iosdriver.hideKeyboard();
			System.out.println(iosdriver.getPageSource());
			MobileElement  mb = ((MobileElement)iosdriver.findElement(By.className("UIATextField")));
			Assert.assertEquals(true, false);
			
			System.out.println(mb.getText());
			//mb.swipe(SwipeElementDirection.LEFT, 2);
			
			mb.setValue("1212");
			//iosdriver.findElement(By.className("UIATextField")).sendKeys("");
			Thread.sleep(3000);
			
			//iosdriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]")).sendKeys("tyokyo");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertEquals(true, true);
		}
		
		//driver.findElementByName("Login").click();
	}

}
