package ckt.ios.testcase.account;

import java.net.MalformedURLException;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ckt.App.Util.Property;
import ckt.App.Util.VP;
import ckt.ios.action.LoginAction;
import ckt.ios.page.MainPage;

public class LoginCase extends VP {
	private static String configPath = "properties/account.properties";
	
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		startAppium();
	}
    
	@AfterClass
	public void afterClass() {
		stopAppium();
	}
    /*
    case 3：输入错误的账号或者密码后点击登录
    1.输入错误的密码，点击login
    2.错误的账号和密码。点击login
    无页面变化
     */
	@Test
	public void testErrorUseNameOrPassword(){
		LoginAction.logOutAccount();
		String emial = Property.getValueByKey(configPath, "email");
		LoginAction.loginAccount(emial, "121212");
		wait(5);
		String alertTest = getElementByClassName("UIAStaticText").getText();
		Assert.assertEquals(alertTest, "用户名或密码错误", "错误的密码-登录失败");
	}
	@Test
	public void testLoginByEmail(){
		String emial = Property.getValueByKey(configPath, "email");
		String passwd = Property.getValueByKey(configPath, "email_password");
		
		LoginAction.logOutAccount();
		iosdriver.closeApp();
		iosdriver.launchApp();
		LoginAction.loginAccount(emial, passwd);
		boolean discover_page = text_exist("发现");
		Assert.assertEquals(discover_page, true, "discover page");
	}
	
	@Test
	public void testLoginByPhoneNumber(){
		String emial = Property.getValueByKey(configPath, "phone_number");
		String passwd = Property.getValueByKey(configPath, "phone_password");
		
		LoginAction.logOutAccount();
		iosdriver.closeApp();
		iosdriver.launchApp();
		LoginAction.loginAccount(emial, passwd);
		boolean discover_page = text_exist("发现");
		Assert.assertEquals(discover_page, true, "discover page");
	}
	@Test
	public void testLoginBySioeyeID(){
		String emial = Property.getValueByKey(configPath, "sioeye_id");
		String passwd = Property.getValueByKey(configPath, "sioeye_password");
		
		LoginAction.logOutAccount();
		iosdriver.closeApp();
		iosdriver.launchApp();
		LoginAction.loginAccount(emial, passwd);
		boolean discover_page = text_exist("发现");
		Assert.assertEquals(discover_page, true, "discover page");
	}
    /*测试注销账号*/
	@Test
	public void testLogOutAccount(){
		String emial = Property.getValueByKey(configPath, "phone_number");
		String passwd = Property.getValueByKey(configPath, "phone_password");
		
		LoginAction.logOutAccount();
		iosdriver.closeApp();
		iosdriver.launchApp();
		LoginAction.loginAccount(emial, passwd);
		LoginAction.logOutAccount();
		boolean discover_page = text_exist("发现");
		Assert.assertEquals(discover_page, true, "discover page");
		MainPage.clickMe_btn();
		
		boolean account_page = text_exist("登录");
		Assert.assertEquals(account_page, true, "account_page");
		
	}
	
}
