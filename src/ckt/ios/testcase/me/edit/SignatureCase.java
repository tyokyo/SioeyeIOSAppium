package ckt.ios.testcase.me.edit;

import io.appium.java_client.MobileElement;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ckt.App.Util.VP;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.MePage;

public class SignatureCase extends VP {
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
		resetApp(0);
		LoginAction.inLoginStatus();
	}
	@Test
	public void testSignature10c(){
		MeAction.navToSignature();
		String strInput=getRandomString(10);
		MobileElement textView = MePage.getTextView();
		setText(textView, strInput,false);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp(0);
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
		setText(textView, strInput,false);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp(0);
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
		setText(textView, strInput,false);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp(0);
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText();
		Assert.assertEquals(activeString, strInput, "char-24");
	}
	@Test
	public void testSignature100c(){
		MeAction.navToSignature();
		String expectString=getRandomString(100);
		MobileElement textView = MePage.getTextView();
		setText(textView, expectString,false);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		wait(10);
		resetApp(0);
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText();
		log(activeString.length()+"");
		Assert.assertEquals(activeString, expectString.substring(0, 60), "max-char-60");
	}
	@Test
	public void testSignature60c(){
		MeAction.navToSignature();
		String strInput=getRandomString(60);
		MobileElement textView = MePage.getTextView();
		setText(textView, strInput,false);
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		wait(10);
		resetApp(0);
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText();
		String expectString = strInput;
		Assert.assertEquals(activeString, expectString, "char-60");
	}
	@Test
	public void testSignatureZeroc(){
		MeAction.navToSignature();
		MobileElement textView = MePage.getTextView();
		textView.clear();
		MePage.clickSaveBtn();
		//验证签名是否修改成功
		resetApp(0);
		MeAction.navToSignature();
		textView = MePage.getTextView();
		String activeString = textView.getText()==null?"":"na-null";
		Assert.assertEquals(activeString, "", "char-61");
	}
}
