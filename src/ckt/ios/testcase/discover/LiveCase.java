package ckt.ios.testcase.discover;

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

public class LiveCase extends VP4 {
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
		IElement cellEem = DiscoverPage.getCell();
		int beforeWatch = Integer.parseInt(DiscoverPage.getWatchCount(cellEem.getXpath()));
		cellEem.click();
		wait(6);
		waitUntilGone(30,By.className("ActivityIndicator"));

		DiscoverPage.watchBack();
		int afterWatch = Integer.parseInt(DiscoverPage.getWatchCount(cellEem.getXpath()));
		Assert.assertEquals(afterWatch, beforeWatch+1,"watch video");
	}
	/*主页，观看视频-点赞-点赞数+1*/
	@Test
	public void testClickZan(){
		IElement cellEem = DiscoverPage.getCell();
		int beforeWatch = Integer.parseInt(DiscoverPage.getZanCount(cellEem.getXpath()));
		cellEem.click();
		wait(6);
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		DiscoverPage.clickZan();

		DiscoverPage.watchBack();
		int afterWatch = Integer.parseInt(DiscoverPage.getZanCount(cellEem.getXpath()));
		Assert.assertEquals(afterWatch, beforeWatch+1,"zan video");
	}
	/*主页，观看视频-主播-视频观看数+1*/
	@Test
	public void testHomeWatchVideo(){
		IElement cellEem = DiscoverPage.getCell();
		String bwatch=DiscoverPage.getZanCount(cellEem.getXpath());
		log(bwatch);
		int beforeWatch = Integer.parseInt(bwatch);
		cellEem.click();
		waitUntilGone(30,By.className("ActivityIndicator"));
		//主播
		DiscoverPage.clickAnchor();
		String roomXpath = DiscoverPage.getCharRoom().getXpath();
		String awatch = DiscoverPage.getHomeZanCount(roomXpath);
		log(awatch);
		int afterWatch = Integer.parseInt(awatch);		

		DiscoverPage.watchBack();
		Assert.assertEquals(afterWatch, beforeWatch+1,"Anchor watch video count + 1 ");
	}
	/*主页，观看视频-点赞-主播-点赞数+1*/
	@Test
	public void testHomeClickZan(){
		IElement cellEem = DiscoverPage.getCell();
		String bzan=DiscoverPage.getZanCount(cellEem.getXpath());
		log(bzan);
		int beforeWatch = Integer.parseInt(bzan);
		cellEem.click();
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		DiscoverPage.clickZan();
		//主播
		DiscoverPage.clickAnchor();
		String roomXpath = DiscoverPage.getCharRoom().getXpath();
		String azan = DiscoverPage.getHomeZanCount(roomXpath);
		log(azan);
		int afterWatch = Integer.parseInt(azan);		

		DiscoverPage.watchBack();
		Assert.assertEquals(afterWatch, beforeWatch+1,"room  video zan  count + 1 ");
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
