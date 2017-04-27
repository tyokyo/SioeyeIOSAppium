package ckt.ios.page;

import ckt.App.Util.VP4;

public class LoginPage extends VP4 {
	//点击- 注册
	public static void clickSignIn_btn(){
		clickByName("Sign up");
	}
	//点击-  注销
	public static void clickSignOut_btn(){
		clickByName("Log out");
	}
	//点击-  登录
	public static void clickLogin_btn(){
		clickByName("Log in");
	}
	//点击-  微信
	public static void clickWeiXin_btn(){
		clickByName("Weichat");
	}
	//点击-  微博
	public void clickWeiBo_btn(){
		clickByName("Weibo");
	}
	//点击-  登录
	public void clickQQ_btn(){
		clickByName("QQ");
	}
	//登录界面-cancel按钮
	public static void clickCancel_btn(){
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]");
	}
	//退出登录
	public static void clickLogOut_btn(){
		log("click login out button");
		clickByName("Log out");
		wait(2);
	}
	//登录
	public static void clickLoginAccount_btn(){
		log("click login in button");
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]");
	}
	//忘记密码
	public static void clickForgotPassword_btn(){
		//Change your password
		log("click forgot password button");
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]");
	}
}
