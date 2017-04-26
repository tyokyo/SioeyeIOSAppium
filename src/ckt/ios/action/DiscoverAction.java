package ckt.ios.action;

import ckt.App.Util.VP4;

public class DiscoverAction extends VP4 {
	public static void waitForConnect(){
		waitUntilTextExist("说点什么吧", 60);
	}
}
