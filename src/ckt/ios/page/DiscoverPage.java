package ckt.ios.page;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.dom4j.Element;
import org.openqa.selenium.By;

import ckt.App.Util.Draw;
import ckt.App.Util.IElement;
import ckt.App.Util.VP4;

public class DiscoverPage extends VP4 {
	//click 主播
	public static void clickAnchor(){
		clickByName("anchor");
		wait(3);
	}
	//click 
	public static void clickRoom(){
		clickByName("chat room");
	}
	public static IElement  getCharRoom(){
		MobileElement sElement = (MobileElement) iosdriver.findElements(By.className("ScrollView")).get(1);
		return MobileElementToIElement(sElement);
	}
	public static IElement  getCell(){
		int h = iosdriver.manage().window().getSize().height;
		int w = iosdriver.manage().window().getSize().width;
		IElement findeElement = null;
		swipeToUp(iosdriver, 1000, 5);
		List<Element> ems = getPageXmlElements();
		List<IElement> tms = toIElements(ems);
		for (IElement iElement : tms) {
			if ("XCUIElementTypeCell".equals(iElement.getClassName())) {
				int x =(int)iElement.getX();
				int y =(int)iElement.getY();
				if (0<=x &&x<=h) {
					if (0<=y &&y<=w) {
						System.out.println(iElement.getXpath());
						findeElement =iElement;
						break;
					}
				}
			}
		}
		return findeElement;
	}
	public static String getWatchCount(String cellpath){
		String watchSubXpath = "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
		String xpath = cellpath+watchSubXpath;
		IElement watchElement = getIElementByXpath(xpath);
		if (watchElement!=null) {
			log("find element with cellpath");
			String name = watchElement.getName();
			log(" get watch count ="+name);
			return name;
		}else {
			log(" get watch count failed");
			return null;
		}
	}
	public static String getHomeWatchCount(String cellpath){
		String watchSubXpath = "/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]";
		String xpath = cellpath+watchSubXpath;
		IElement watchElement = getIElementByXpath(xpath);
		if (watchElement!=null) {
			log("find element with cellpath");
			String name = watchElement.getName();
			log(" get watch count ="+name);
			return name;
		}else {
			log(" get watch count failed");
			return null;
		}
	}
	
	public static String getZanCount(String cellpath){
		String zanSubXpath = "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText";
		String xpath = cellpath+zanSubXpath;
		IElement zanElement = getIElementByXpath(xpath);
		if (zanElement!=null) {
			log("find element with cellpath");
			return zanElement.getName();
		}else {
			log(" not find element with cellpath");
			return null;
		}
	}
	public static String getHomeZanCount(String cellpath){
		String zanSubXpath = "/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[3]";
		String xpath = cellpath+zanSubXpath;
		IElement zanElement = getIElementByXpath(xpath);
		if (zanElement!=null) {
			log("find element with cellpath");
			return zanElement.getName();
		}else {
			log(" not find element with cellpath");
			return null;
		}
	}
	public static void watchBack(){
		//getIElementByXpath(xpath)
		wait(7);
		clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]");
		getElementBySubXpath(getElementByClassName("NavigationBar"), "/XCUIElementTypeButton[1]").click();
		wait(7);
	}
	public static void clickZan(){
		clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]");
		log("click zan ");
	}
}
