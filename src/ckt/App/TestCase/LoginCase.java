package ckt.App.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import ckt.App.Util.VP;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import java.net.MalformedURLException;

public class LoginCase extends VP {
	
	@Test
	public void WatchAndSignUp1() throws InterruptedException {
			
		iosdriver.findElementByName("我").click();
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
		//driver.findElementByName("Login").click();
	}
	@Test
	public void WatchAndSignUp2() {
		iosdriver.findElementByName("Me").click();
		iosdriver.hideKeyboard();
		System.out.println(iosdriver.getPageSource());
		iosdriver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]").click();
		//iosdriver.findElementByName("Broadcasts").click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		WebElement element1 =  iosdriver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");
		
		System.out.println("height:"+element1.getLocation().getX());
		System.out.println("height:"+element1.getLocation().getY());
		System.out.println("height:"+element1.getSize().height);
		System.out.println("height:"+element1.getSize().width);
		
		TouchAction action = new TouchAction(iosdriver);
		//int startX1 = 3*element1.getLocation().x/4;
		//int startY1 = element1.getLocation().getY();
		//int startX2 = element1.getRect().width/4;
		//int startY2 = element1.getLocation().getY();
		//action.press(startX2, startY2).waitAction(2000).moveTo(startX1, startY1).release().perform();
		//action.press(240, 239).waitAction(2000).moveTo(80, 239).release().perform();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//iosdriver.findElement(By.name("Sign up")).click();
		Assert.assertEquals(true, true);
		//driver.findElementByName("Login").click();
	}
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		startAppium();
	}
 
	@AfterClass
	public void afterClass() {
		stopAppium();
	}

}
