package ckt.ios.testcase.account;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
		//System.out.println(DiscoverPage.getCell().toString());
	}
}
