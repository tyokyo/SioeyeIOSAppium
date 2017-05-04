package ckt.ios.testcase.me.edit;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ckt.App.Util.Draw;
import ckt.App.Util.VP4;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.MePage;

public class LocationCase extends VP4 {
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
		resetApp(0);
		LoginAction.inLoginStatus();
	}
	@Test
	public void testSearch(){
		MeAction.navToLocation();
		MobileElement search = MePage.getSearchField();
		setText(search, "yibin");
		MeAction.clickKeyBoardSearch();
		waitUntilTextExist("宜宾", 10);;
		//验证是否修改成功
		Assert.assertEquals(true, text_exist("宜宾"), "search -yibin");
		Draw.takeScreenShotWithDraw("宜宾");
	}
}
