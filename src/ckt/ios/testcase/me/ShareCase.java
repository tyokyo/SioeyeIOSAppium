package ckt.ios.testcase.me;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ckt.App.Util.Draw;
import ckt.App.Util.VP4;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;

//分享
public class ShareCase  extends VP4{
	@BeforeSuite
	public void BeforeSuite() throws MalformedURLException {
		startAppium();
	}
    
	@AfterSuite
	public void AfterSuite() {
		stopAppium();
	}
	@BeforeMethod
	public void BeforeTest(){
		resetApp();
		LoginAction.inLoginStatus();
	}
	@Test
	public void testShareClick(){
		MeAction.navToShare();
		Draw.takeScreenShot();
		Assert.assertEquals(text_contains("Friends"),true,"Friends");
		Assert.assertEquals(text_contains("Moments"),true,"Moments");
		Assert.assertEquals(text_contains("Weibo"),true,"Weibo");
		Assert.assertEquals(text_contains("More"),true,"Friends");
		Assert.assertEquals(text_contains("Q-zone"),true,"Friends");
	}
	
}
