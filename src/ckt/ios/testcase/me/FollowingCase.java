package ckt.ios.testcase.me;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ckt.App.Util.VP4;
import ckt.ios.action.LoginAction;

public class FollowingCase extends VP4{
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
	//取消关注
	@Test
	public void testCancelFollowing(){
		
	}
	//任意选择一个关注者，观看视频-评论
	@Test
	public void testDoWatchComment(){
		
	}
	//任意选择一个关注者，观看视频-点赞
	@Test
	public void testDoWatchZan(){
		
	}
	
}
