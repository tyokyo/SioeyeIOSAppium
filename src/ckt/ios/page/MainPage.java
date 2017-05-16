package ckt.ios.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import ckt.App.Util.VP4;

public class MainPage extends VP4{
	public static void toHome(){

	}
	public static boolean isInScreen(MobileElement element){
		boolean isScreen = false;
		int h = iosdriver.manage().window().getSize().height;
		int w = iosdriver.manage().window().getSize().width;
		int x = element.getRect().x;
		int y = element.getRect().y;
		int endX=x+element.getRect().width;
		int endY=y+element.getRect().height;
		if (x<=w&&y<=h) {
			if (endX<=w&&endY<=h) {
				isScreen=true;
				log("find element in screen");
			}
		}
		return isScreen;
	}
	//输入法 returen button
	public static void clickReturn(){
		if (text_exist("return")) {
			clickByName("return");
			wait(1);
		}
	}
	//输入法 send button
	public static void clickSend(){
		if (text_exist("Send")) {
			clickByName("Send");
			wait(1);
		}
	}
	//点击-发现(Discover)
	public static void clickDiscover_btn(){
		//clickByName("发现");
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[1]");
		wait(1);
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]");
	}

	//点击-关注(Watch)
	public static void clickLive_btn(){
		//clickByName("关注");
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[2]");
		wait(1);
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]");
	}
	//点击-我(Me)
	public static void clickMe_btn(){
		//clickByName("我");
		wait(1);
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[3]");
		//                        XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[3]
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]");
		wait(1);
	}
	//点击-设备(Remote)
	public static void clickDevice_btn(){
		//clickByName("相机");
		clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[4]");
		wait(1);
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]");
	}
	//点击-确认按钮
	public static void clickAskToSure_btn(){
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]");
		if (text_exist("OK")) {
			clickByName("OK");	
		}
	}
	//点击-确认按钮
	public static void clickAskToCancel_btn(){
		//clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]");
		clickByName("Cancel");
	}
	//点击-返回按钮
	public static void clickBack_btn(){
		log("click back button");
		try {
			iosdriver.findElement(By.className("NavigationBar")).findElement(By.name("Back")).click();
		} catch (Exception e) {
			// TODO: handle exception
			log("not find value with back-click firest button");
			getElementByClassName("NavigationBar").findElements(By.className("Button")).get(0).click();
		}
	}
}
