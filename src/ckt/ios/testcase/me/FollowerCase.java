package ckt.ios.testcase.me;

import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ckt.App.Util.VP4;
import ckt.ios.action.DiscoverAction;
import ckt.ios.action.FollowerAction;
import ckt.ios.action.LoginAction;
import ckt.ios.page.DiscoverPage;
import ckt.ios.page.FollowerPage;
import ckt.ios.page.FollowingPage;
import ckt.ios.page.MainPage;

/*粉丝*/
public class FollowerCase extends VP4{
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
		resetApp(0);
		LoginAction.inLoginStatus();
	}

	//添加关注
	@Test
	public void testAddFollower(){
		FollowerAction.navToFollower();
		MobileElement element = FollowerPage.swipToFindFollow(true);
		String name = FollowerPage.getFollowName(element);
		FollowerPage.clickAddFollow(element);
		//back
		MainPage.clickBack_btn();
		//enter Following
		FollowingPage.clickFollowing_btn();
		//find name
		//boolean toFind = scrollToFind(name);
		boolean toFind = text_exist(name);
		Assert.assertEquals(toFind, true,"to find - "+name);
	}
	//取消关注
	@Test
	public void testSubFollower(){
		FollowerAction.navToFollower();
		MobileElement cell = FollowerPage.swipToFindFollow(false);
		String name = FollowerPage.getFollowName(cell);
		FollowerPage.clickAddFollowByAvartar(cell);
		//back
		MainPage.clickBack_btn();
		//enter Following
		FollowingPage.clickFollowing_btn();
		//find name
		boolean toFind = scrollToFind(name);
		Assert.assertEquals(toFind, false,"to find - "+name);
	}
	//任意选择一视频(未关注)观看 评论
	@Test
	public void testWatchVideoFollower(){
		FollowerAction.navToFollower();
		MobileElement element = FollowerPage.swipToFindFollowWithVideo(true);
		if (element!=null) {
			element.click();
			//播放视频
			MobileElement choosElement = FollowerAction.chooseVideo();
			if (choosElement!=null) {
				choosElement.click();
				wait(6);
				//等待视频加载完成
				waitUntilGone(30,By.className("ActivityIndicator"));
				//等待聊天室连接成功
				DiscoverAction.waitForConnect();
				//评论
				String cmt =  getRandomString(8);
				setText(getElementByClassName("TextField"),cmt);
				MainPage.clickSend();
				DiscoverPage.clickVieNewMessage();
				Assert.assertEquals(text_exist(cmt), true,"New message at the bottom");
				//返回
				DiscoverPage.watchBack();
				
			}
		}
	}
	@Test
	//任意选择一视频观看 点赞(未关注)
	public void testZanVideoFollower(){
		FollowerAction.navToFollower();
		MobileElement element = FollowerPage.swipToFindFollowWithVideo(true);
		if (element!=null) {
			element.click();
			//播放视频
			MobileElement choosElement = FollowerAction.chooseVideo();
			if (choosElement!=null) {
				choosElement.click();	
				wait(6);
				//等待视频加载完成
				waitUntilGone(30,By.className("ActivityIndicator"));
				//等待聊天室连接成功
				DiscoverAction.waitForConnect();
				//点赞
				DiscoverPage.clickZan();
				//评论
				String cmt =  getRandomString(8);
				setText(getElementByClassName("TextField"),cmt);
				MainPage.clickSend();
				DiscoverPage.clickVieNewMessage();
				Assert.assertEquals(text_exist(cmt), true,"New message at the bottom");
				//返回
				DiscoverPage.watchBack();
			}
		}
	}
	@Test
	//任意选择一视频(已关注)观看 评论
	public void testWatchVideoFollowing(){
		FollowerAction.navToFollower();
		MobileElement element = FollowerPage.swipToFindFollowWithVideo(false);
		if (element!=null) {
			element.click();
			//播放视频
			MobileElement choosElement = FollowerAction.chooseVideo();
			if (choosElement!=null) {
				choosElement.click();
				wait(6);
				//等待视频加载完成
				waitUntilGone(30,By.className("ActivityIndicator"));
				//等待聊天室连接成功
				DiscoverAction.waitForConnect();
				//评论
				String cmt =  getRandomString(8);
				setText(getElementByClassName("TextField"),cmt);
				MainPage.clickSend();
				DiscoverPage.clickVieNewMessage();
				Assert.assertEquals(text_exist(cmt), true,"New message at the bottom");
				//返回
				DiscoverPage.watchBack();
			}
		}
	}	
	@Test
	//任意选择一视频观看(已关注) 点赞
	public void testZanVideoFollowing(){
		FollowerAction.navToFollower();
		MobileElement element = FollowerPage.swipToFindFollowWithVideo(false);
		if (element!=null) {
			element.click();
			//播放视频
			MobileElement choosElement = FollowerAction.chooseVideo();
			if (choosElement!=null) {
				choosElement.click();
				wait(6);
				//等待视频加载完成
				waitUntilGone(30,By.className("ActivityIndicator"));
				//等待聊天室连接成功
				DiscoverAction.waitForConnect();
				//点赞
				DiscoverPage.clickZan();
				//评论
				String cmt =  getRandomString(8);
				setText(getElementByClassName("TextField"),cmt);
				MainPage.clickSend();
				DiscoverPage.clickVieNewMessage();
				Assert.assertEquals(text_exist(cmt), true,"New message at the bottom");
				//返回
				DiscoverPage.watchBack();
			}
		}
	}	

}
