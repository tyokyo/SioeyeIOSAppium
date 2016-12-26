package ckt.ios.action;

import ckt.App.Util.VP;

public class MeAction  extends VP{
	//点击-我
	public static void clickMe_btn(){
		iosdriver.findElementByName("我").click();
	}
}
