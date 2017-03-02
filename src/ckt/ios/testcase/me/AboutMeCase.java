package ckt.ios.testcase.me;

import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;

import javax.xml.ws.BindingType;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ckt.App.Util.VP;
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
		resetApp();
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
	public void testSignature300c(){
		MeAction.navToSignature();
		String strInput=getRandomString(300);
		MobileElement textView = MePage.getUIATextView();
		setText(textView, strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
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
	public void testSignature400c(){
		MeAction.navToSignature();
		String strInput=getRandomString(1200);
		MobileElement textView = MePage.getUIATextView();
		setText(textView, strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getUIATextView();
		String activeString = textView.getText();
		String expectString = strInput;
		log(activeString);
		log(strInput);
		
		log(activeString.length()+"");
		log(expectString.length()+"");
		Assert.assertEquals(activeString, expectString, "char-61");
	}
	
}
