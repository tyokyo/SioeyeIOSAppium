package ckt.ios.page;

import java.util.List;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;

import ckt.App.Util.VP4;

public class DiscoverPage extends VP4 {
	
	public static MobileElement  getCell(){
		int h = iosdriver.manage().window().getSize().height;
		int w = iosdriver.manage().window().getSize().width;
		MobileElement findeElement = null;
		List<MobileElement> cells=(List<MobileElement>) iosdriver.findElements(By.className("Cell"));
		for (MobileElement mobileElement : cells) {
			int x =Integer.parseInt( mobileElement.getAttribute("x"));
			int y =Integer.parseInt( mobileElement.getAttribute("y"));
			if(0<=x&&x<=w){
				if (0<=y&&y<=h) {
					findeElement =  mobileElement;
					break;
				}
			}
		}
		return findeElement;
	}
}
