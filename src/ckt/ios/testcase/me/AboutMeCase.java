package ckt.ios.testcase.me;

import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ckt.App.Util.VP;
import ckt.App.Util.VP3;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.MePage;

public class AboutMeCase extends VP {
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
		MeAction.navToSignature();
		String strInput=getRandomString(10);
		MobileElement textView = MePage.getUIATextView();
		textView.setValue(strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getUIATextView();
		String activeString = textView.getText();
		Assert.assertEquals(activeString, strInput, "char-10");
	}
	@Test
	public void testSignature60c(){
		MeAction.navToSignature();
		String strInput=getRandomString(60);
		MobileElement textView = MePage.getUIATextView();
		textView.setValue(strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getUIATextView();
		String activeString = textView.getText();
		Assert.assertEquals(activeString, strInput, "char-60");
	}
	@Test
	public void testSignature61c(){
		System.out.println(iosdriver.getPageSource());
		MeAction.navToSignature();
		String strInput=getRandomString(150);
		MobileElement textView = MePage.getUIATextView();
		textView.setValue(strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		wait(10);
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getUIATextView();
		String activeString = textView.getText();
		String expectString = strInput;
		log(activeString.length()+"");
		log(expectString.length()+"");
		Assert.assertEquals(activeString, expectString, "char-61");
		
	}
	@Test
	public void testSignature612c(){		
		MeAction.navToUserEdit();
		
		VP.swipeToUp(iosdriver, 1000, 2);
		waitUntilFind(10, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[4]"));
		VP3.clickElementByPoint("爱好");
		wait(10);
		
		//wait(10);
		/*WebElement  element = iosdriver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[5]");
		HashMap<String, String> scrollObject = new HashMap<String, String>();  
		//scrollObject.put("direction", "Up");
		scrollObject.put("direction", "Up");
		iosdriver.execute("mobile: scroll", scrollObject);*/
		
	}
	
}
