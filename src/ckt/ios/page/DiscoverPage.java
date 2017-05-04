package ckt.ios.page;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.dom4j.Element;
import ckt.App.Util.IElement;
import ckt.App.Util.VP4;

public class DiscoverPage extends VP4 {
	//处理观看数和点赞数K的情况
	public static int kToInt(String number){
		if (number.contains("K")) {
			String string = number.replace("K", "");
			return (int)Double.parseDouble(string)*1000;
		}else {
			return Integer.parseInt(number);
		}
	}
	//New message at the bottom
	public static void clickVieNewMessage(){
		if (text_exist("New message at the bottom")) {
			clickByName("New message at the bottom");
			wait(3);
		}
	}
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
		List<MobileElement> ems = getElementsByClassName("ScrollView");
		int size = ems.size();
		MobileElement sElement = (MobileElement)ems.get(size-1);
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
		String watchSubXpath2 = "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
		String watchSubXpath3 = "/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
		String xpath2 = cellpath+watchSubXpath2;
		String xpath3 = cellpath+watchSubXpath3;
		IElement watchElement2 = getIElementByXpath(xpath2);
		IElement watchElement3 = getIElementByXpath(xpath3);
		if (watchElement2!=null) {
			log("find element with cellpath");
			String name = watchElement2.getName();
			log(" get watch count ="+name);
			return name;
		}else if (watchElement3!=null) {
			log("find element with cellpath");
			String name = watchElement3.getName();
			log(" get watch count ="+name);
			return name;
		}else {
			log(" get watch count failed");
			return null;
		}
	}
	public static String getHomeWatchCount(String cellpath){
		String watchSubXpath2 = "/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]";
		String watchSubXpath3 = "/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]";
		String xpath2 = cellpath+watchSubXpath2;
		String xpath3 = cellpath+watchSubXpath3;
		IElement watchElemen2 = getIElementByXpath(xpath2);
		IElement watchElemen3 = getIElementByXpath(xpath3);
		if (watchElemen2!=null) {
			log("find element with cellpath");
			String name = watchElemen2.getName();
			log(" get watch count ="+name);
			return name;
		}else if (watchElemen3!=null) {
			log("find element with cellpath");
			String name = watchElemen3.getName();
			log(" get watch count ="+name);
			return name;
		}else {
			log(" get watch count failed");
			return null;
		}
	}
	
	public static String getZanCount(String cellpath){
		String zanSubXpath2 = "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText";
		String zanSubXpath3 = "/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText";
		String xpath2 = cellpath+zanSubXpath2;
		String xpath3 = cellpath+zanSubXpath3;
		IElement zanElement2 = getIElementByXpath(xpath2);
		IElement zanElement3 = getIElementByXpath(xpath3);
		if (zanElement2!=null) {
			log("find element with cellpath");
			return zanElement2.getName();
		}else if (zanElement3!=null) {
			return zanElement3.getName();
		}else {
			log(" not find element with cellpath");
			return null;
		}
	}
	public static String getHomeZanCount(String cellpath){
		String zanSubXpath2 = "/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[3]";
		String zanSubXpath3 = "/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[3]";
		String xpath2 = cellpath+zanSubXpath2;
		String xpath3 = cellpath+zanSubXpath3;
		IElement zanElement2 = getIElementByXpath(xpath2);
		IElement zanElement3 = getIElementByXpath(xpath3);
		if (zanElement2!=null) {
			log("find element with cellpath");
			return zanElement2.getName();
		}else if (zanElement3!=null) {
			log("find element with cellpath");
			return zanElement2.getName();
		}else {
			log(" not find element with cellpath");
			return null;
		}
	}
	public static void watchBack(){
		//getIElementByXpath(xpath)
		wait(3);
		if (class_exist("ActivityIndicator")) {
			clickByClassName("ActivityIndicator");
		}else {
			clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]");			
		}
		wait(2);
		getElementBySubXpath(getElementByClassName("NavigationBar"), "/XCUIElementTypeButton[1]").click();
		wait(7);
	}
	public static void clickZan(){
		log("click zan ");
		List<MobileElement> btns = getElementsByClassName("Button");
		int size = btns.size();
		btns.get(size-1).click();
		//clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]");
	}
}
