package ckt.ios.page;

import org.openqa.selenium.By;

import ckt.App.Util.VP4;

public class MainPage extends VP4{
	public static void toHome(){
		
	}
	//输入法 returen button
	public static void clickReturn(){
		if (text_exist("return")) {
			clickByName("return");
			wait(1);
		}
	}

	//点击-发现
	public static void clickDiscover_btn(){
		//clickByName("发现");
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[1]");
		wait(1);
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]");
	}

	//点击-关注
	public static void clickLive_btn(){
		//clickByName("关注");
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[2]");
		wait(1);
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]");
	}
	//点击-我
	public static void clickMe_btn(){
		//clickByName("我");
		wait(1);
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[3]");
		//                        XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[3]
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]");
		wait(1);
	}
	//点击-设备
	public static void clickDevice_btn(){
		//clickByName("相机");
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[4]");
		wait(1);
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]");
	}
	//点击-确认按钮
	public static void clickAskToSure_btn(){
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]");
		clickByName("确认");
	}
	//点击-确认按钮
	public static void clickAskToCancel_btn(){
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		clickByName("取消");
	}
	//点击-返回按钮
	public static void clickBack_btn(){
		iosdriver.findElement(By.className("NavigationBar")).findElement(By.name("返回")).click();
	}
}
