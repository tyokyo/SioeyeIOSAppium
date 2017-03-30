package ckt.ios.action;

import ckt.App.Util.VP;

public class MainAction extends VP{
	public static void navToDiscover(){
		clickByXpath("UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]");
	}
	public static void navToFollowing(){
		clickByXpath("UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]");
	}
	public static void navToMe(){
		clickByXpath("UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]");
	}
	public static void navToCamera(){
		clickByXpath("UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]");
	}
	
}
