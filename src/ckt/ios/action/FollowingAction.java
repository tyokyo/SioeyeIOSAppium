package ckt.ios.action;

import io.appium.java_client.MobileElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import ckt.App.Util.VP4;
import ckt.ios.page.FollowingPage;
import ckt.ios.page.MainPage;

public class FollowingAction  extends VP4{
	public static void navToFollowing(){
		MainPage.clickMe_btn();
		FollowingPage.clickFollowing_btn();
	}
	public static List<MobileElement> getAllCells(){
		List<MobileElement> enableCells=new ArrayList<MobileElement>();
		List<MobileElement> all =getElementsByClassName("Cell");
		for (MobileElement mobileElement : all) {
			if (mobileElement.isDisplayed()) {
				enableCells.add(mobileElement);
			}
		}
		System.out.println("enable cells find - "+enableCells.size());
		return enableCells;
	}
	//添加关注
	public static void clickAddFollow(){
		log("click cancel follow button");
		wait(5);
		clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeButton[3]");
	}
}
