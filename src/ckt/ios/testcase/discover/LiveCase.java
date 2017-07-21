package ckt.ios.testcase.discover;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ckt.App.Util.IElement;
import ckt.App.Util.VP4;
import ckt.ios.action.DiscoverAction;
import ckt.ios.action.LoginAction;
import ckt.ios.action.VideoAction;
import ckt.ios.page.DiscoverPage;
import ckt.ios.page.MainPage;

public class LiveCase extends VP4 {
	@BeforeSuite
	public void BeforeSuite() throws MalformedURLException {
		startAppium();
	}

	@AfterSuite
	public void AfterSuite() {
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
		IElement cellEem = DiscoverPage.getCell();
		String beforeString=DiscoverPage.getWatchCount(cellEem.getXpath());
		log(beforeString);
		int beforeWatch = DiscoverPage.kToInt(beforeString);

		cellEem.click();
		wait(6);
		waitUntilGone(30,By.className("ActivityIndicator"));

		DiscoverPage.watchBackDsicover();

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

		DiscoverPage.watchBackDsicover();
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
		IElement cellEem = DiscoverPage.getCell();
		String beforeString=DiscoverPage.getWatchCount(cellEem.getXpath());
		int expectWatch = DiscoverPage.kToInt(beforeString);
		log("expect-watch is-"+expectWatch);
		
		cellEem.click();
		waitUntilGone(30,By.className("ActivityIndicator"));
		//主播页面显示的观看数
		int activeWatch=VideoAction.getAnchorWatchCount();
		log("active-watch is-"+activeWatch);
		DiscoverPage.watchBackDsicover();

		if (activeWatch<1000) {
			Assert.assertEquals(activeWatch, expectWatch+1,"Anchor watch video count + 1 ");
		}
	}
	/*主页，观看视频-点赞-主播-点赞数+1*/
	@Test
	public void testHomeClickZan(){
		IElement cellEem = DiscoverPage.getCell();
		//主页显示的点赞数
		String beforeString=DiscoverPage.getZanCount(cellEem.getXpath());
		int expectZan = DiscoverPage.kToInt(beforeString);
		log("expect-zan is-"+expectZan);
		cellEem.click();
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		DiscoverPage.clickZan();
		//主播页面显示的点赞数
		int activeZan=VideoAction.getAnchorLikeCount();
		log("active-zan is-"+activeZan);
		DiscoverPage.watchBackDsicover();
		if (activeZan<1000) {
			Assert.assertEquals(activeZan, expectZan+1,"room  video zan  count + 1 ");
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
		DiscoverPage.watchBackDsicover();
	}
}
