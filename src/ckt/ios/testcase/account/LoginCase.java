package ckt.ios.testcase.account;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ckt.App.Util.Property;
import ckt.App.Util.VP;
import ckt.ios.action.LoginAction;
import ckt.ios.page.MainPage;

public class LoginCase extends VP {
	
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
		String emial = Property.getValueByKey(accountPath, "email");
		LoginAction.loginAccount(emial, "121212");
		wait(5);
		String alertTest = getElementByClassName("UIAStaticText").getText();
		Assert.assertEquals(alertTest, "Username or password error.", "错误的密码-登录失败");
	}
	@Test
	public void testLoginByEmail(){
		String emial = Property.getValueByKey(accountPath, "email");
		String passwd = Property.getValueByKey(accountPath, "email_password");
		
		LoginAction.logOutAccount();
		resetApp();
		LoginAction.loginAccount(emial, passwd);
		boolean discover_page = text_exist("Discover");
		Assert.assertEquals(discover_page, true, "discover page");
	}
	
	@Test
	public void testLoginByPhoneNumber(){
		String emial = Property.getValueByKey(accountPath, "phone_number");
		String passwd = Property.getValueByKey(accountPath, "phone_password");
		
		LoginAction.logOutAccount();
		resetApp();
		LoginAction.loginAccount(emial, passwd);
		boolean discover_page = text_exist("Discover");
		Assert.assertEquals(discover_page, true, "discover page");
	}
	@Test
	public void testLoginBySioeyeID(){
		String emial = Property.getValueByKey(accountPath, "sioeye_id");
		String passwd = Property.getValueByKey(accountPath, "sioeye_password");
		
		LoginAction.logOutAccount();
		resetApp();
		LoginAction.loginAccount(emial, passwd);
		boolean discover_page = text_exist("Discover");
		Assert.assertEquals(discover_page, true, "discover page");
	}
    /*测试注销账号*/
	@Test
	public void testLogOutAccount(){
		String emial = Property.getValueByKey(accountPath, "phone_number");
		String passwd = Property.getValueByKey(accountPath, "phone_password");
		
		LoginAction.logOutAccount();
		resetApp();
		LoginAction.loginAccount(emial, passwd);
		LoginAction.logOutAccount();
		boolean discover_page = text_exist("Discover");
		Assert.assertEquals(discover_page, true, "discover page");
		MainPage.clickMe_btn();
		
		boolean account_page = text_exist("Log in");
		Assert.assertEquals(account_page, true, "account_page");
		
	}
	
}
