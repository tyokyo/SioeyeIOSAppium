package ckt.ios.testcase.discover;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ckt.App.Util.Property;
import ckt.App.Util.VP4;
import ckt.ios.action.DiscoverAction;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MainAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.DiscoverPage;
import ckt.ios.page.MainPage;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/*发现
播放视频
滑动视频
验证推荐列表
 * */
public class DiscoverCase extends VP4 {
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
		iosdriver.launchApp();
		LoginAction.inLoginStatus();
	}
	/**
	 * case1、单击搜索图标
	 * */
	@Test
	public void testOneClickSearch() throws IOException {
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
	}

	@Test
	/**
	 *case3、下拉刷新、在discover界面手指从上往下滑动
	 * 思路：通过判断刷新前后的推介列表的头像昵称是否相同来判定是否刷新，因为刷新后，
	 * 第一个头像的昵称是不一样的
	 */
	public void testFlush() {
		MainAction.navToDiscover();
		for (int i = 0; i < 10; i++) {
			DiscoverPage.fresh();
		}
		waitUntilFind(By.name("Who to follow"), 20);
	}

	@Test
	/**
	 *
	 *case4.来回频繁切换主界面
	 *Result：观察APP响应情况， APP迅速响应对应操作
	 */
	public void testSwipe() {
		MainAction.navToDiscover();
		for (int i = 0; i < 5; i++) {
			MainPage.clickDevice_btn();
			MainPage.clickDiscover_btn();
			MainPage.clickLive_btn();
			MainPage.clickMe_btn();
		}
	}

	//play the first video in discover page
	@Test
	public void testViewVideo() {
		MainAction.navToDiscover();
		DiscoverAction.watchVideo();
		wait(6);
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		DiscoverPage.watchBack();
	}

	@Test
	/**
	 * 未登陆点击输入框
	 * 1、未登录状态下在discover界面点击任意视频进入观看
	 * 2、点击输入框
	 * Result:弹出登陆界面
	 * */
	public void testClickInput() {
		//未登录状态
		LoginAction.logOutAccount();

		MainAction.navToDiscover();
		DiscoverAction.watchVideo();
		wait(6);
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		waitUntilByFind(By.className("TextField"), 10);
		DiscoverAction.clickCommentInput_btn();
		//弹出登录界面
		boolean logIn = text_exist("Log in");
		Assert.assertEquals(logIn, true,"need to log in");

	}

	@Test
	/**
	 * 已登录点击输入框
	 *1、已登录状态下在discover界面点击任意视频进入观看，点击输入框
	 * Result：正常弹出输入字符界面
	 * */
	public void testClickInputSuccess() {
		MainAction.navToDiscover();
		DiscoverAction.watchVideo();
		wait(6);
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		String cmt = getRandomString(10);
		waitUntilByFind(By.className("TextField"), 10);
		setText(getElementByClassName("TextField"),cmt);
		MainPage.clickSend();
	}

	@Test
	/**
	 * 未登陆点击关注主播
	 *1.未登陆状态下，在观看视频界面点击关注主播
	 *Result:弹出登陆界面
	 * */
	public void testUnLoginFollowAnchor() {
		//未登录状态
		LoginAction.logOutAccount();

		MainAction.navToDiscover();
		DiscoverAction.watchVideo();
		wait(6);
		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		DiscoverPage.clickAnchor();
		DiscoverPage.clickFollowAnchor();
		//弹出登录界面
		waitUntilByFind(By.name("Log in"), 10);
		boolean logIn = text_exist("Log in");
		Assert.assertEquals(logIn, true,"need to log in");
	}

	@Test
	/**
	 *
	 *1.已登录状态下，在观看界面点击任意键关注主播
	 *Result:
	 * */
	public void testLoginFollowAnchor() {
		MainAction.navToDiscover();
		//获取推荐列表
		List<MobileElement> rmdList = DiscoverPage.getRecommandList();
		if (rmdList.size()>=1) {
			rmdList.get(0).click();
			DiscoverPage.clickRecommandFollow();
		}
	}

	@Test
	/**
	 * 单击广告封面
	 *1、点击广告封面
	 *Result:跳转至广告链接，在网络良好的情况下不应卡顿，延迟
	 * */
	public void testClickAD()  {
		MainAction.navToDiscover();
		DiscoverPage.clickAdvertisement();
	}

	@Test
	/**
	 * 广告内容页面点返回上级
	 *1、点击广告页面里的返回键
	 *Result：迅速响应，返回上一级界面
	 * */
	public void testClickADBack() {
		MainAction.navToDiscover();
		DiscoverPage.clickAdvertisement();
		resetApp(0);
	}

	@Test
	/**
	 * 未登录点击follow
	 *1、点击任一推荐对象，点击follow
	 *Result:弹出登陆界面
	 * */
	public void testUnLoginClickFollow()  {
		//未登录状态
		LoginAction.logOutAccount();
		MainAction.navToDiscover();
		//获取推荐列表
		List<MobileElement> rmdList = DiscoverPage.getRecommandList();
		if (rmdList.size()>=1) {
			rmdList.get(0).click();
			DiscoverPage.clickRecommandFollow();
			//弹出登录界面
			waitUntilByFind(By.name("Log in"), 10);
			boolean logIn = text_exist("Log in");
			Assert.assertEquals(logIn, true,"need to log in");
		}
	}

	@Test
	/**
	 *未登陆单击推荐人头像
	 *1、点击推荐头像
	 *Result:唤出对应对象的个人资料页面
	 * */
	public void testUnLoginClickAvatar()  {
		//未登录状态
		LoginAction.logOutAccount();
		MainAction.navToDiscover();
		//获取推荐列表
		List<MobileElement> rmdList = DiscoverPage.getRecommandList();
		if (rmdList.size()>=1) {
			MobileElement cell = rmdList.get(0);
			String name = DiscoverPage.getRecommandName(cell);
			cell.click();
			waitUntilByFind(By.name(name), 10);
			boolean logIn = text_exist(name);
			Assert.assertEquals(logIn, true,"personal page");
		}
	}

	@Test
	/**
	 *向上迅速滑动视频列表
	 *1、迅速滑动推荐视频列表
	 *Result:APP响应迅速不会出现延迟卡顿carsh闪退现象
	 * */
	public void testSwipeUpQuickly()  {
		MainAction.navToDiscover();
		for (int i = 0; i < 5; i++) {
			swipeToUp(iosdriver, 2000, 5);
			swipeToDown(iosdriver, 2000, 5);
		}
		swipeToBegin(iosdriver, 30);
	}
	@Test
	/**
	 *进入搜索界面，检查默认推荐联系人状态
	 *1、已经关注的不再显示在默认推荐人列表
	 * */
	public void testCheckDefaultRecommendListStatus() {
		MainAction.navToDiscover();
		//获取推荐列表
		List<MobileElement> rmdList = DiscoverPage.getRecommandList();
		if (rmdList.size()>=1) {
			MobileElement select = rmdList.get(0);
			select.click();
			String name = DiscoverPage.getRecommandName(select);
			DiscoverPage.clickRecommandFollow();
			resetApp(0);
			DiscoverPage.fresh();
			waitUntilByNotFind(By.name(name), 30);
			//check 
			Assert.assertEquals(text_contains(name),false);
		}
	}

	@Test
	/**
	 *1.进入搜索界面
	 *2.输入邮箱地址后点击搜索
	 *Result:结果匹配搜索内容，成功搜索出该ID的联系人
	 * */
	public void testToSearchByEmail() {
		String emial = Property.getValueByKey(accountPath, "email");
		String sioeye_id = Property.getValueByKey(accountPath, "sioeye_id");
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
		DiscoverAction.searchFollower(emial);
		waitUntilByFind(By.name(sioeye_id), 30);
		boolean actual = text_exist(sioeye_id);
		Assert.assertEquals(actual, true,"search result contains -"+sioeye_id);
		DiscoverPage.clickCancel();
	}

	@Test
	/**
	 *1.进入搜索界面
	 *2.输入Sioeye Id后点击搜索
	 *Result:结果匹配搜索内容，成功搜索出该ID的联系人
	 * */
	public void testToSearchBySioeyeID() {
		String sioeye_id = Property.getValueByKey(accountPath, "sioeye_id");
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
		DiscoverAction.searchFollower(sioeye_id);
		waitUntilByFind(By.name(sioeye_id), 30);
		boolean actual = text_exist(sioeye_id);
		Assert.assertEquals(actual, true,"search result contains -"+sioeye_id);
		DiscoverPage.clickCancel();
	}

	@Test
	/**
	 *1.进入搜索界面
	 *2.输入昵称后点击搜索
	 *Result:结果匹配搜索内容，成功搜索出该ID的联系人
	 * */
	public void testToSearchByNickname() {
		String sioeye_id = Property.getValueByKey(accountPath, "sioeye_id");
		//获取昵称名字
		String nickname = MeAction.getNickName();
		
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
		DiscoverAction.searchFollower(nickname);
		waitUntilByFind(By.name(sioeye_id), 30);
		boolean actual = text_exist(sioeye_id);
		Assert.assertEquals(actual, true,"search result contains -"+sioeye_id);
		DiscoverPage.clickCancel();
	}

	@Test
	/**
	 *1.进入搜索界面
	 *2.输入手机号码后点击搜索
	 *Result:结果匹配搜索内容，成功搜索出该ID的联系人
	 * */
	public void testToSearchByPhoneNumber() {
		String phone_number = Property.getValueByKey(accountPath, "phone_number");
		String sioeye_id = Property.getValueByKey(accountPath, "phone_number_sioeye_id");
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
		DiscoverAction.searchFollower(phone_number);
		waitUntilByFind(By.name(sioeye_id), 30);
		boolean actual = text_exist(sioeye_id);
		Assert.assertEquals(actual, true,"search result contains -"+sioeye_id);
		DiscoverPage.clickCancel();
		resetApp(0);
		LoginAction.logOutAccount();
	}
	@Test
	/**
	 *1.在搜索界面点击Video切换到视频搜索
	 *Result:成功切换到视频搜索
	 * */
	public void testToSearchVideo(){
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
		DiscoverAction.searchVideo("t");
		waitUntilByNotFind(By.name("Loading"),60);
		List<MobileElement> cells = getElementsByClassName("Cell");
		if (cells.size()==0) {
			Assert.assertEquals(false, true,"search failed");
		}
		DiscoverPage.clickCancel();
	}

	@Test
	/**
	 *1.在搜索输入框输入一些数据
	 *2.点击输入框中的×按钮清空数据
	 *Result:成功清空输入的数据，返回推荐
	 * */
	public void testToSearchByData() {
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
		MobileElement element = getElementByClassName("SearchField");
		element.clear();
		element.setValue(getRandomString(8));
		DiscoverPage.deleteInput();
		element = getElementByClassName("SearchField");

		Assert.assertEquals(element.getText()+"","null","delete success");
		DiscoverPage.clickCancel();
	}

	@Test
	/**
	 *1.在搜索界面点击取消按钮
	 *Result:退出搜索界面，返回到上一界面
	 * */
	public void testToSearchClickCancle()  {
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
		clickByClassName("SearchField");
		DiscoverPage.clickCancel();
		Assert.assertEquals(text_contains("Trending"),true,"cancel success");
	}

	@Test
	/**
	 *1.在输入界面输入视频名称
	 *2.点击搜索
	 *Result:成功搜索出该名称的视频，绿色高亮显示
	 * */
	public void testToSearchByVideoName() {
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
		DiscoverAction.searchVideo("a");
		waitUntilByNotFind(By.name("Loading"),60);
		List<MobileElement> cells = getElementsByClassName("Cell");
		if (cells.size()==0) {
			Assert.assertEquals(false, true,"search failed");
		}
		DiscoverPage.clickCancel();
	}

	@Test
	/**
	 *1.在输入框输入随意字符
	 *Result:自动匹配出包含这些字符的视频，匹配字符绿色高亮显示
	 * */
	public void testToSearchByRandChar() {
		MainAction.navToDiscover();
		//点击搜索按钮
		DiscoverPage.clickReLoad_btn();
		wait(4);
		for (int i = 0; i < 2; i++) {
			DiscoverAction.searchVideo(getRandomString(1).toLowerCase());
			waitUntilByNotFind(By.name("Loading"),60);
			List<MobileElement> cells = getElementsByClassName("Cell");
			if (cells.size()==0) {
				Assert.assertEquals(false, true,"search failed");
			}
			DiscoverPage.clickCancel();
		}
	}
}


