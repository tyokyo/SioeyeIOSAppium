package ckt.ios.action;

import org.openqa.selenium.By;

import ckt.App.Util.Log;
import ckt.App.Util.Property;
import ckt.App.Util.VP;
import ckt.ios.page.LoginPage;
import ckt.ios.page.MainPage;

public class LoginAction extends VP {
	//是否是处于登录状态
	public static boolean isLogin(){
		waitUntilFind(By.name("Sioeye"), 15);
		MainPage.clickMe_btn();
		boolean logintStatus=true;
		if (text_exist("Log in")) {
			logintStatus=false;
			LoginPage.clickCancel_btn();
		}
		return  logintStatus;
	}
	//注销账号
	public static void logOutAccount(){
		resetApp(0);
		if (isLogin()) {
			resetApp(0);
			MeAction.navToAccountAndSecurity();
			LoginPage.clickLogOut_btn();
			MainPage.clickAskToSure_btn();
			wait(3);
		}
	}
	//登录账号
	public static void loginAccount(String userName,String password){
		resetApp(0);
		wait(5);
		MainPage.clickMe_btn();
		LoginPage.clickLogin_btn();
		getElementByClassName("UIATextField").clear();
		getElementByClassName("UIATextField").setValue(userName);
		getElementByClassName("UIASecureTextField").setValue(password);
		MainPage.clickReturn();
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
			Log.info("App account is login ");
		}
	}
}
