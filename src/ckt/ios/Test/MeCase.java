package ckt.ios.Test;

import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ckt.App.Util.VP;
import ckt.ios.action.LoginAction;

public class MeCase extends VP {
	@BeforeTest
	public void BeforeTest(){
		LoginAction.inLoginStatus();
	}
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
			
			
			
			/* WebElement webElement=iosdriver.findElementByIosUIAutomation(".tableViews()[1].cells().withPredicate(\" any staticTexts.name == '" + orgName + "'\")");
		      tap(iosdriver,webElement);
		      se2.waitTime(se2.sec);
		      iosdriver.scrollTo("x55mgp2u_2, x55mgp2u_2@reg186.cn, reg186.cn");*/
		        
		        
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
