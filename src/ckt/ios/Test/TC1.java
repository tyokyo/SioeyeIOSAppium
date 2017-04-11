package ckt.ios.Test;

import java.awt.Color;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.ios.action.LoginAction;

public class TC1 extends VP {
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
	public void testSignature10c(){
		Assert.fail("");
	}
	@Test(description ="test four")
	public void testSignature612c(){		
		Draw.takeScreenShot(Color.RED);
		/*MeAction.navToUserEdit();
		
		VP.swipeToUp(iosdriver, 1000, 2);
		waitUntilFind(10, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[4]"));
		VP3.clickElementByName("爱好");
		wait(10);*/
		
		//wait(10);
		/*WebElement  element = iosdriver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[5]");
		HashMap<String, String> scrollObject = new HashMap<String, String>();  
		//scrollObject.put("direction", "Up");
		scrollObject.put("direction", "Up");
		iosdriver.execute("mobile: scroll", scrollObject);*/
		
	}
}
