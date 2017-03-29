package ckt.main;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import ckt.App.Util.VP;
import ckt.inspector.CutXml;

public class TestMain extends VP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startAppium();
		CutXml.repXml(iosdriver.getPageSource().replaceAll("\n", ""));
		//Draw.takeScreenShot();

		//方向接受参数：Right, Left, Up, Down
		
		//scrollToFind("890");
		wait(5);
		//clickByXpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");
		wait(5);
		iosdriver.findElement(By.name("我")).click();
		wait(2);
		iosdriver.findElement(By.name("发现")).click();
		wait(2);
		MobileElement s = (MobileElement) iosdriver.findElement(By.className("TabBar"));
		s.findElement(By.name("相机")).click();
		wait(2);
		stopAppium();
	}

}
