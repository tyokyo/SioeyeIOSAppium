package ckt.ios.page;

import ckt.App.Util.VP;

public class MainPage extends VP{

	//点击-发现
	public static void clickDiscover_btn(){
		clickByName("发现");
		wait(1);
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]");
	}

	//点击-关注
	public static void clickLive_btn(){
		clickByName("关注");
		wait(1);
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]");
	}
	//点击-我
	public static void clickMe_btn(){
		//clickByName("我");
		wait(1);
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]");
		wait(1);
	}
	//点击-设备
	public static void clickDevice_btn(){
		clickByName("设备");
		wait(1);
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]");
	}
	//点击-确认按钮
	public static void clickAskToSure_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]");
		//clickByName("确定");
	}
	//点击-确认按钮
	public static void clickAskToCancel_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		//clickByName("取消");
	}
}
