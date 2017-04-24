package ckt.ios.page;

import java.util.List;

import org.dom4j.Element;

import ckt.App.Util.IElement;
import ckt.App.Util.VP4;

public class DiscoverPage extends VP4 {
	
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
			return watchElement.getName();
		}else {
			log(" not find element with cellpath");
			return null;
		}
	}
	public static String geZanCount(String cellpath){
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
	public static void watchBack(){
		if (class_exist("ScrollView")) {
			log("find calssName=ScrollView ");
			String xpath = VP4.getXpathByClassName("ScrollView").getXpath();
			String subnavpath = xpath+"/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar";
			String subbtnpath = xpath+"/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar/XCUIElementTypeButton[1]";
			if (xpath_exist(subnavpath)) {
				getElementByXpath(subbtnpath).click();
				watchBack();
			}
		}else {
			log("can not find calssName=ScrollView ");
		}
	}
}
