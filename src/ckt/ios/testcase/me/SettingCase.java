package ckt.ios.testcase.me;

import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ckt.App.Util.VP4;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.MainPage;
import ckt.ios.page.MePage;

//设置
public class SettingCase  extends VP4{
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
	public void testSeedFeedBack(){
		MeAction.navToFeedback();
		MobileElement textView = getElementByClassName("TextView");
		String feedback = getRandomString(20);
		setText(textView, feedback);
		MainPage.clickSend();
		waitForElementToLoad(30, By.name("Settings"));
	}
	@Test
	public void testSeedFeedBack200(){
		MeAction.navToFeedback();
		MobileElement textView = getElementByClassName("TextView");
		String feedback = getRandomString(200);
		setText(textView, feedback);
		MainPage.clickSend();
		waitForElementToLoad(30, By.name("Settings"));
	}
	@Test
	public void testSeedFeedBackCancel(){
		MeAction.navToFeedback();
		MobileElement textView = getElementByClassName("TextView");
		String feedback = getRandomString(200);
		setText(textView, feedback);
		MainPage.clickAskToCancel_btn();
		waitForElementToLoad(30, By.name("Settings"));
	}
	@Test
	public void testHelpTos(){
		MeAction.navToHelp_TOS();
	}
	@Test
	public void testHelpPrivacyPolicy(){
		MeAction.navToHelp_PrivacyPlolicy();
	}
	@Test
	public void testHelpEULA(){
		MeAction.navToHelp_EULA();
	}
	@Test
	public void testHelpHelp(){
		MeAction.navToHelp_Help();
		MePage.returnToSioeye();
	}
	@Test
	public void testAboutSioeye(){
		MeAction.navToAboutSioeye();
	}
}
