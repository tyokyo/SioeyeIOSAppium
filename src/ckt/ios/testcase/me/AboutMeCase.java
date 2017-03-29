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
		MobileElement textView = MePage.getTextView();
		setText(textView, strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText();
		Assert.assertEquals(activeString, strInput, "char-10");
	}
	//max length is 35
	@Test
	public void testSignature25c(){
		MeAction.navToSignature();
		String strInput=getRandomString(25);
		MobileElement textView = MePage.getTextView();
		setText(textView, strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText();
		Assert.assertEquals(activeString, strInput, "char-25");
	}
	@Test
	public void testSignature24c(){
		MeAction.navToSignature();
		String strInput=getRandomString(24);
		MobileElement textView = MePage.getTextView();
		setText(textView, strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText();
		Assert.assertEquals(activeString, strInput, "char-24");
	}
	@Test
	public void testSignature100c(){
		MeAction.navToSignature();
		String strInput=getRandomString(100);
		MobileElement textView = MePage.getTextView();
		setText(textView, strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		wait(10);
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText();
		String expectString = strInput;
		String uIAStaticText_ValueString = MePage.getTextView().getText();
		log(activeString.length()+"");
		log(expectString.length()+"");
		//Assert.assertEquals(activeString, expectString.substring(0, 25), "char-100");
	}
	@Test
	public void testSignature26c(){
		MeAction.navToSignature();
		String strInput=getRandomString(26);
		MobileElement textView = MePage.getTextView();
		setText(textView, strInput);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		wait(10);
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText();
		String expectString = strInput;
		log(activeString.length()+"");
		log(expectString.length()+"");
		//Assert.assertEquals(activeString, expectString.substring(0, 25), "char-100");
	}
	@Test
	public void testSignatureZeroc(){
		MeAction.navToSignature();
		MobileElement textView = MePage.getTextView();
		textView.clear();
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp();
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText();
		//Assert.assertEquals(activeString, "", "char-61");
	}
}
