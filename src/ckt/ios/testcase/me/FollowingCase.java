package ckt.ios.testcase.me;

import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ckt.App.Util.VP4;
import ckt.ios.action.DiscoverAction;
import ckt.ios.action.FollowerAction;
import ckt.ios.action.FollowingAction;
import ckt.ios.action.LoginAction;
import ckt.ios.page.DiscoverPage;
import ckt.ios.page.FollowerPage;
import ckt.ios.page.FollowingPage;
import ckt.ios.page.MainPage;

public class FollowingCase extends VP4{
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
	}
	//取消关注
	@Test
	public void testCancelFollowing(){
		FollowingAction.navToFollowing();
		List<MobileElement> elements = FollowingAction.getAllCells();
		MobileElement toClickElement ; 
		if (elements.size()>=1) {
			toClickElement=elements.get(0);
			String name = FollowerPage.getFollowName(toClickElement);
			toClickElement.click();
			wait(3);
			//取消关注
			FollowingAction.clickAddFollow();
			//back
			MainPage.clickBack_btn();
			//find name
			Assert.assertEquals(text_exist(name), false,"to find - "+name);
		}
		
	}
	//任意选择一个关注者，观看视频-评论
	@Test
	public void testDoWatchComment(){
		FollowingAction.navToFollowing();
		List<MobileElement> elements = FollowingAction.getAllCells();
		MobileElement toClickElement ; 
		if (elements.size()>=1) {
			toClickElement=elements.get(0);
			toClickElement.click();
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
	//任意选择一个关注者，观看视频-点赞
	@Test
	public void testDoWatchZan(){
		FollowingAction.navToFollowing();
		List<MobileElement> elements = FollowingAction.getAllCells();
		MobileElement toClickElement ; 
		if (elements.size()>=1) {
			toClickElement=elements.get(0);
			toClickElement.click();
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
				//返回
				DiscoverPage.watchBack();
			}
		}
	}
	
}
