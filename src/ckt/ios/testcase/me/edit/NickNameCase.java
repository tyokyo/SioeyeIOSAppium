package ckt.ios.testcase.me.edit;

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
		resetApp(0);
		LoginAction.inLoginStatus();
	}
	@Test
	public void testNickName10c(){
		MeAction.navToNickName();
		String strInput=getRandomString(10);
		MobileElement textField = MePage.getTextField();
		setText(textField, strInput);
		MePage.clickSaveBtn();
		//验证是否修改成功
		resetApp(0);
		MeAction.navToNickName();
		textField = MePage.getTextField();
		String activeString = textField.getText();
		Assert.assertEquals(activeString, strInput, "char-10");
	}
	@Test
	public void testNickName30c(){
		MeAction.navToNickName();
		String strInput=getRandomString(30);
		MobileElement textField = MePage.getTextField();
		setText(textField, strInput);
		MePage.clickSaveBtn();
		//验证是否修改成功
		resetApp(0);
		MeAction.navToNickName();
		textField = MePage.getTextField();
		String activeString = textField.getText();
		Assert.assertEquals(activeString, strInput, "char-30");
	}
	@Test
	public void testNickName100c(){
		MeAction.navToNickName();
		String strInput=getRandomString(100);
		MobileElement textField = MePage.getTextField();
		setText(textField, strInput);
		MePage.clickSaveBtn();
		//验证是否修改成功
		resetApp(0);
		MeAction.navToNickName();
		textField = MePage.getTextField();
		String activeString = textField.getText();
		Assert.assertEquals(activeString, strInput.substring(0,30), "char-30");
	}
	@Test
	public void testNickNameisEnable(){
		MeAction.navToNickName();
		MobileElement textField = MePage.getTextField();
		textField.clear();
		//保存 isEnable = false
		boolean isEnable=getElementByName("保存").isEnabled();
		Assert.assertEquals(isEnable, false, "不能设置为空");
	}
	@Test
	public void testNickNameModifyNotSave(){
		MeAction.navToNickName();
		String strInput=getRandomString(10);
		MobileElement textField = MePage.getTextField();
		setText(textField, strInput);
		MePage.clickSaveBtn();
		//验证是否修改成功
		resetApp(0);
		MeAction.navToNickName();
		textField = MePage.getTextField();
		String activeString = textField.getText();
		Assert.assertEquals(activeString, strInput, "char-10");
	}
	
}
