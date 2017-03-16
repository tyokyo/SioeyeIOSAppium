package ckt.ios.testcase.me;

import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ckt.App.Util.VP;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.MePage;

public class NickNameCase extends VP {
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
		resetApp();
		LoginAction.inLoginStatus();
	}
	@Test
	public void testNickName10c(){
		MeAction.navToNickName();
		String strInput=getRandomString(10);
		MobileElement textView = getElementByClassName("UIAStaticText");
		setText(textView, strInput);
		MePage.clickSaveBtn();
		//验证是否修改成功
		resetApp();
		MeAction.navToNickName();
		textView = MePage.getUIATextView();
		String activeString = textView.getText();
		Assert.assertEquals(activeString, strInput, "char-10");
	}
}
