package ckt.ios.page;

import ckt.App.Util.VP;

public class MePage extends VP{
	//点击-我
	public static void clickMe_btn(){
		iosdriver.findElementByName("我").click();
	}
}
