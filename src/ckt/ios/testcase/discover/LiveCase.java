package ckt.ios.testcase.discover;

import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ckt.App.Util.IElement;
import ckt.App.Util.VP4;
import ckt.ios.page.DiscoverPage;

public class LiveCase extends VP4 {
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		startAppium();
	}

	@AfterClass
	public void afterClass() {
		stopAppium();
	}	
	@Test
	public void testWatchLoveVideo(){
		IElement cellEem = DiscoverPage.getCell();
		System.out.println(DiscoverPage.getWatchCount(cellEem.getXpath()));
		System.out.println(DiscoverPage.geZanCount(cellEem.getXpath()));
		//String watchSubXpath = "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
		//String zanSubXpath = "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText";
	}
	public static void getX1(){
		System.out.println(getElementByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText").getText());
	}
	@Test
	public void test(){
		getX1();
		swipeToUp(iosdriver, 1000, 5);
		getX1();
	}
}
