package ckt.ios.action;

import ckt.App.Util.VP;
import ckt.ios.page.MePage;

public class LoginAction extends VP {
	public static boolean isLogin(){
		MePage.clickMe_btn();
		return text_exist("登录");
	}
}
