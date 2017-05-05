package ckt.ios.testcase.me;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ckt.App.Util.VP4;
import ckt.ios.action.LoginAction;

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
	//任意选择一视频观看 评论
	//任意选择一视频观看 点赞
	
}
