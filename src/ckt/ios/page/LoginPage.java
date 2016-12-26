package ckt.ios.page;

import ckt.App.Util.VP;

public class LoginPage extends VP {
	//点击- 注册
	public static void clickSignIn_btn(){
		clickByName("注册");
	}
	//点击-  注销
	public static void clickSignOut_btn(){
		clickByName("注销");
	}
	//点击-  登录
	public static void clickLogin_btn(){
		clickByName("登录");
	}
	//点击-  微信
	public static void clickWeiXin_btn(){
		clickByName("微信");
	}
	//点击-  微博
	public void clickWeiBo_btn(){
		clickByName("微博");
	}
	//点击-  登录
	public void clickQQ_btn(){
		clickByName("QQ");
	}

}
