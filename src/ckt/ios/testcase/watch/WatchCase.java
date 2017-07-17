package ckt.ios.testcase.watch;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ckt.App.Util.IElement;
import ckt.App.Util.VP4;
import ckt.ios.action.DiscoverAction;
import ckt.ios.action.LoginAction;
import ckt.ios.page.DiscoverPage;
import ckt.ios.page.MainPage;

public class WatchCase extends VP4 {
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		startAppium();
	}

	@AfterClass
	public void afterClass() {
		stopAppium();
	}	
	@BeforeMethod
	public void BeforeTest(){
		resetApp();
		LoginAction.inLoginStatus();
		MainPage.clickDiscover_btn();
	}
	/*主页，观看视频-视频观看数+1*/
	@Test
	public void testWatchVideo(){
		MainPage.clickWatch_btn();
		
		IElement cellEem = DiscoverPage.getCell();
		String beforeString=DiscoverPage.getWatchCount(cellEem.getXpath());
		log(beforeString);
		int beforeWatch = DiscoverPage.kToInt(beforeString);
		
		cellEem.click();
		wait(6);
		waitUntilGone(30,By.className("ActivityIndicator"));

		DiscoverPage.watchBack();
		
		String afterString=DiscoverPage.getWatchCount(cellEem.getXpath());
		log(beforeString);
		int afterWatch = DiscoverPage.kToInt(afterString);
		if (beforeWatch<1000) {
			Assert.assertEquals(afterWatch, beforeWatch+1,"watch video");
		}
	}
	/*主页，观看视频-点赞-点赞数+1*/
	@Test
	public void testClickZan(){
		IElement cellEem = DiscoverPage.getCell();
		
		String beforeString=DiscoverPage.getZanCount(cellEem.getXpath());
		log(beforeString);
		int beforeWatch = DiscoverPage.kToInt(beforeString);
		
		cellEem.click();
		wait(6);
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		DiscoverPage.clickZan();

		DiscoverPage.watchBack();
		String afterString=DiscoverPage.getZanCount(cellEem.getXpath());
		log(afterString);
		int afterWatch = DiscoverPage.kToInt(afterString);
		
		if (beforeWatch<1000) {
			Assert.assertEquals(afterWatch, beforeWatch+1,"zan video");
		}
	}
	/*主页，观看视频-主播-视频观看数+1*/
	@Test
	public void testHomeWatchVideo(){
		MainPage.clickWatch_btn();
		
		IElement cellEem = DiscoverPage.getCell();
		String beforeString=DiscoverPage.getWatchCount(cellEem.getXpath());
		log(beforeString);
		int beforeWatch = DiscoverPage.kToInt(beforeString);
		
		cellEem.click();
		waitUntilGone(30,By.className("ActivityIndicator"));
		//主播
		DiscoverPage.clickAnchor();
		
		String roomXpath = DiscoverPage.getCharRoom().getXpath();
		
		String afterString=DiscoverPage.getHomeWatchCount(roomXpath);
		log(afterString);
		int afterWatch = DiscoverPage.kToInt(afterString);

		DiscoverPage.watchBack();
		
		if (beforeWatch<1000) {
			Assert.assertEquals(afterWatch, beforeWatch+1,"Anchor watch video count + 1 ");
		}
	}
	/*主页，观看视频-点赞-主播-点赞数+1*/
	@Test
	public void testHomeClickZan(){
		IElement cellEem = DiscoverPage.getCell();
		
		String beforeString=DiscoverPage.getZanCount(cellEem.getXpath());
		log(beforeString);
		int beforeZan = DiscoverPage.kToInt(beforeString);
		
		cellEem.click();
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		DiscoverPage.clickZan();
		//主播
		DiscoverPage.clickAnchor();
		String roomXpath = DiscoverPage.getCharRoom().getXpath();
		
		String afterString=DiscoverPage.getHomeZanCount(roomXpath);
		log(afterString);
		int afterZan = DiscoverPage.kToInt(beforeString);
		
		DiscoverPage.watchBack();
		if (beforeZan<1000) {
			Assert.assertEquals(afterZan, beforeZan+1,"room  video zan  count + 1 ");
		}
	}
	@Test
	public void testComments(){
		IElement cellEem = DiscoverPage.getCell();
		String bwatch=DiscoverPage.getZanCount(cellEem.getXpath());
		log(bwatch);
		cellEem.click();
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		String cmt =  getRandomString(8);
		setText(getElementByClassName("TextField"),cmt);
		MainPage.clickSend();
		DiscoverPage.clickVieNewMessage();
		Assert.assertEquals(text_exist(cmt), true,"New message at the bottom");
		DiscoverPage.watchBack();
	}
}

