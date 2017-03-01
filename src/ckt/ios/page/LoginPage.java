package ckt.ios.page;

import ckt.App.Util.VP;
import ckt.App.Util.VP4;

public class LoginPage extends VP4 {
	//点击- 注册
	public static void clickSignIn_btn(){
		clickElementByName("注册");
	}
	//点击-  注销
	public static void clickSignOut_btn(){
		clickElementByName("注销");
	}
	//点击-  登录
	public static void clickLogin_btn(){
		clickElementByName("登录");
	}
	//点击-  微信
	public static void clickWeiXin_btn(){
		clickElementByName("微信");
	}
	//点击-  微博
	public void clickWeiBo_btn(){
		clickElementByName("微博");
	}
	//点击-  登录
	public void clickQQ_btn(){
		clickElementByName("QQ");
	}
	//登录界面-cancel
	public static void clickCancel_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
	}
	//登录界面-cancel
	public static void clickLogOut_btn(){
		clickByName("退出登录");
	}
	//登录
	public static void clickLoginAccount_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
	}
	//忘记密码
	public static void clickForgotPassword_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	}
}
