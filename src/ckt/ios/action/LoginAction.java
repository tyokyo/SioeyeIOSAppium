package ckt.ios.action;

import ckt.App.Util.Property;
import ckt.App.Util.VP;
import ckt.ios.page.LoginPage;
import ckt.ios.page.MainPage;

public class LoginAction extends VP {
	//是否是处于登录状态
	public static boolean isLogin(){
		MainPage.clickMe_btn();
		boolean logintStatus=true;
		if (text_exist("登录")) {
			logintStatus=false;
			LoginPage.clickCancel_btn();
		}
		return  logintStatus;
	}
	//注销账号
	public static void logOutAccount(){
		iosdriver.closeApp();
		iosdriver.launchApp();
		if (isLogin()) {
			iosdriver.closeApp();
			iosdriver.launchApp();
			MeAction.navToAccountAndSecurity();
			LoginPage.clickLogOut_btn();
			MainPage.clickAskToSure_btn();
			wait(3);
		}
	}
	//登录账号
	public static void loginAccount(String userName,String password){
		iosdriver.closeApp();
		iosdriver.launchApp();
		wait(5);
		MainPage.clickMe_btn();
		LoginPage.clickLogin_btn();
		getElementByClassName("UIATextField").clear();
		getElementByClassName("UIATextField").setValue(userName);
		getElementByClassName("UIASecureTextField").setValue(password);
		LoginPage.clickLoginAccount_btn();
		wait(5);
	}
	public static void inLoginStatus(){
		String emial = Property.getValueByKey(accountPath, "sioeye_id");
		String passwd = Property.getValueByKey(accountPath, "sioeye_password");
		
		boolean islogin = isLogin();
		if (!islogin) {
			loginAccount(emial, passwd);
		}else {
			logger.info("App account is login ");
		}
	}
}
