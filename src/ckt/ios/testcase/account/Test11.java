package ckt.ios.testcase.account;

import java.net.MalformedURLException;
import io.appium.java_client.MobileElement;
import org.dom4j.Element;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ckt.App.Util.MIElement;
import ckt.App.Util.VP4;
import ckt.ios.action.MainAction;

public class Test11 extends VP4 {
	@BeforeSuite
	public void BeforeSuite() throws MalformedURLException {
		startAppium();
	}
    
	@AfterSuite
	public void AfterSuite() {
		stopAppium();
	}

	@Test
	public void testError10(){
		//DiscoverPage.watchBack();
		MobileElement mobileElement  = (MobileElement) iosdriver.findElement(By.name("Me"));
		Element element = MobileElementToElement(mobileElement);
		System.out.println(element.getParent().elements("XCUIElementTypeButton").size());

		/*MobileElement mobileElement1  = (MobileElement) iosdriver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeButton"));
		MobileElementToElement(mobileElement1);*/

		searchElementByName("Me");

		System.out.println(mobileElement.getAttribute("rect"));

		MIElement iElement = new MIElement(mobileElement);
		System.out.println(iElement.getRect());
		System.out.println(iElement.getEnabled());
		System.out.println(iElement.getName());
		System.out.println(iElement.getType());
		
		MobileElementToIElement(mobileElement).click();
		
	}
	@Test
	public void testError(){
		MobileElement element=getElementByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView");
		for (int i = 0; i < 3; i++) {
			swipeTo(element, "LEFT");
			wait(5);
		}
	}
	@Test
	public void testAAA(){
		waitUntilByFind(By.name("Who to follow"), 10);
		
		MainAction.navToDiscover();
		
		Element other = getElement("Who to follow").getParent();
		String otherXpath = ElementToIElement(other).getXpath();
		String collectionXpath= otherXpath+"/XCUIElementTypeCollectionView";
		
		//waitUntilByNotFind(By.name("test 26"), 100);
	}
	@Test
	public void testAA(){
		iosdriver.launchApp();
		iosdriver.closeApp();
	}
}
