package ckt.ios.testcase.discover;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ckt.App.Util.IElement;
import ckt.App.Util.VP4;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MainAction;
import ckt.ios.action.VideoAction;
import ckt.ios.page.DiscoverPage;

public class NewCase extends VP4 {
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
	/*New主页，
	 * 随机选择一个视频
	 * 观看视频
	 * 验证-观看数+1-*/
	@Test
    public void testWatchVideo() {
		MainAction.navToNew();
		IElement cellEem = DiscoverPage.getNewCell();
		
		//String beforeString=DiscoverPage.getWatchCount(cellEem.getXpath());
	}
	/*New主页，
	 * 随机选择一个视频
	 * 观看视频
	 * 点赞
	 * 验证-点赞数+1-*/
	@Test
    public void testZanVideo() {
		
	}
	/*New主页，
	 * 随机选择一个视频
	 * 观看视频
	 * 评论
	 * 验证-评论数+1-*/
	@Test
    public void testCommentVideo() {
		
	}
}
