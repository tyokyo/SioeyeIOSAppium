package ckt.ios.action;

import org.openqa.selenium.By;

import ckt.App.Util.VP;
import ckt.ios.page.MainPage;

public class MainAction extends VP{
	public static void navToDiscover(){
		MainPage.clickDiscover_btn();
	}
	public static void navToPopular(){
		MainPage.clickDiscover_btn();
		clickByName("Popular");
	}
	public static void navToNew(){
		MainPage.clickDiscover_btn();
		clickByName("New");
		waitUntilByNotFind(By.name("Loading"), 10);
	}
	public static void navToMe(){
		MainPage.clickMe_btn();
	}
	//输入法->搜索按钮
	public static void clickKeyBoardSearch(){
		try {
			log("click keyboard search button");
			iosdriver.findElement(By.className("Keyboard")).findElement(By.className("Button").name("Search")).click();
			//clickByClassNameAndName("Button", "Search");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//输入法->搜索按钮
	public static void clickKeyBoardReturn(){
		try {
			log("click keyboard search return");
			iosdriver.findElement(By.className("Keyboard")).findElement(By.className("Button").name("return")).click();
			//clickByClassNameAndName("Button", "Search");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//输入法->搜索按钮
	public static void clickKeyBoardDone(){
		try {
			log("click keyboard search return");
			iosdriver.findElement(By.className("Keyboard")).findElement(By.className("Button").name("Done")).click();
			//clickByClassNameAndName("Button", "Search");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//输入法->搜索按钮
	public static void clickKeyBoardSend(){
		try {
			log("click keyboard search return");
			iosdriver.findElement(By.className("Keyboard")).findElement(By.className("Button").name("Send")).click();
			//clickByClassNameAndName("Button", "Search");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
