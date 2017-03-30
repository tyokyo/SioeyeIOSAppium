package ckt.App.Util;


import org.dom4j.Element;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class ElementAction extends VP4{
	public static void scrollToFind(MobileElement element,String text){
		int x = element.getRect().getX();
		int y = element.getRect().getY();
		int width = element.getRect().getWidth();
		int height = element.getRect().getHeight();
		
	}
	public static void scrollToBegin(){
		
	}
}
