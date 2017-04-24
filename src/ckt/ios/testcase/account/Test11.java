package ckt.ios.testcase.account;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ckt.App.Util.MIElement;
import ckt.App.Util.VP4;
import ckt.ios.page.DiscoverPage;

public class Test11 extends VP4 {
	@BeforeMethod
	public void beforeTest(){
		startAppium();
	}

	@AfterMethod
	public void afterTest() {
		stopAppium();
	}

	@Test
	public void testError10(){
		//DiscoverPage.watchBack();
		MobileElement mobileElement  = (MobileElement) iosdriver.findElement(By.name("我"));
		System.out.println(mobileElement.getAttribute("rect"));
		MIElement iElement = new MIElement(mobileElement);
		System.out.println(iElement.getRect());
		System.out.println(iElement.getEnabled());
		System.out.println(iElement.getName());
		System.out.println(iElement.getType());
		
	}
}
