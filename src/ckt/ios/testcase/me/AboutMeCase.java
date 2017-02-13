package ckt.ios.testcase.me;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import ckt.App.Util.VP;
import ckt.ios.action.LoginAction;

public class AboutMeCase extends VP {
	private static String configPath = "properties/account.properties";
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		startAppium();
	}
	@AfterClass
	public void afterClass() {
		stopAppium();
	}
	@BeforeTest
	public void BeforeTest(){
		LoginAction.inLoginStatus();
	}
	
	
	
}
