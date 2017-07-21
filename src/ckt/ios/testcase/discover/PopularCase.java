package ckt.ios.testcase.discover;

import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.util.ArrayList;
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
import ckt.ios.action.LoginAction;
import ckt.ios.action.MainAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.DiscoverPage;

/**
 * Created by user on 2016/11/05   .
 */
public class PopularCase extends VP4 {
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

    @Test
    /**case1 单击推荐列表头像
     * 唤出对应对象的个人资料页面；
     * 单击推送列表好友后检查弹窗好友信息
     */
    public void testSingleClickRecommendList0()  {
    	MainAction.navToDiscover();
		//获取推荐列表
		List<MobileElement> rmdList = DiscoverPage.getRecommandList();
		if (rmdList.size()>=1) {
			MobileElement select = rmdList.get(0);
			String name = DiscoverPage.getRecommandName(select);
			select.click();
			DiscoverPage.clickRecommandFollow();
			resetApp();
			DiscoverPage.fresh();
			waitUntilByNotFind(By.name(name), 30);
			//check 
			Assert.assertEquals(text_contains(name),false);
		}
    }
    @Test
    /**case3添加推荐列表第一个为好友
     * 检查该用户followers有没有增加;
     * 检查自己好友列表有没有增加该好友
     */
    public void testAddDelFriendsRed() {
    	int before_add_follow = MeAction.getPersonalFollowingCount();
    	iosdriver.resetApp();
    	MainAction.navToDiscover();
		//获取推荐列表
		List<MobileElement> rmdList = DiscoverPage.getRecommandList();
		if (rmdList.size()>=1) {
			MobileElement select = rmdList.get(0);
			String name = DiscoverPage.getRecommandName(select);
			select.click();
			DiscoverPage.clickRecommandFollow();
			resetApp();
			//Followers + 1 
			int after_add_follow = MeAction.getPersonalFollowingCount();
			iosdriver.resetApp();
			Assert.assertEquals(after_add_follow, before_add_follow+1,"add follow count + 1");
		}
    }
  
    /**case4 滑动推荐列表后关注第二个推荐用户
     * 检查该用户followers有没有增加;
     *  并到Me关注好友去寻找是否添加成功
     */
    @Test
    public void testSwipeRecommendAD() {
    	int before_add_follow = MeAction.getPersonalFollowingCount();
    	iosdriver.resetApp();
    	MainAction.navToDiscover();
    	
		//获取推荐列表
		List<MobileElement> rmdList = DiscoverPage.getRecommandList();
		if (rmdList.size()>=1) {
			MobileElement select = rmdList.get(0);
			select.click();
			String name = DiscoverPage.getRecommandName(select);
			DiscoverPage.clickRecommandFollow();
			resetApp();
			//Followers + 1 
			int after_add_follow = MeAction.getPersonalFollowingCount();
			iosdriver.resetApp();
			Assert.assertEquals(after_add_follow, before_add_follow+1,"add follow count + 1");
		}
    }
  
    /**case6 刷新discover后检查推荐follow列表是否更新
     * 检查刷新前后，前三个用户是否完全一致，判断是否刷新成功
     */
    @Test
    public void testRefreshRecommendList() {
    	MainAction.navToDiscover();
		DiscoverPage.clickKillWhoToFollow();
		wait(4);
		DiscoverPage.fresh();
		//获取前三个推荐列表name
		//获取推荐列表
		List<MobileElement> rmdList = DiscoverPage.getRecommandList();
		int size = rmdList.size();
		ArrayList<String> recommandList = new ArrayList<String>();
		if (size>=1) {
			for (int i = 0; i < size; i++) {
				MobileElement select = rmdList.get(i);
				String name = DiscoverPage.getRecommandName(select);
				recommandList.add(name);
			}
		}
		DiscoverPage.clickReLoad_btn();
		List<MobileElement> elements = DiscoverAction.getRecommandListInSearchPage();
		//依次验证显示的推荐好友是否与搜索界面的推荐列表一致
		for (int i = 0; i < size; i++) {
			String expectName=recommandList.get(i);
			MobileElement cellElement = elements.get(i);
			String activeName=DiscoverAction.getRecommandCellName(cellElement);
			Assert.assertEquals(activeName,expectName,"index="+i);
		}
    }
  
    /**case 7 Follow一个推荐列表好友后，刷新discover，
     * 检查该好友是否从discover消失
     */
    public void testFollowThenRefresh() {
    	
    }
  
    /*
    关闭推荐列表
    点击推荐列表右上角关闭按钮
    检查推荐列表是否存在
     */
    @Test
    public void testCloseRedList() {
    	MainAction.navToDiscover();
		DiscoverPage.clickKillWhoToFollow();
		wait(4);
		DiscoverPage.fresh();
    }
  
    /*
    关闭推荐列表
    点击推荐列表右上角关闭按钮
    检查推荐列表是否存在
    刷新列表
    推荐列表恢复显示
     */
    @Test
    public void testRecoverRedList() {
    	MainAction.navToDiscover();
    	DiscoverPage.clickKillWhoToFollow();
    	waitUntilByNotFind(By.name("Who to follow"), 5);
    	//验证
    	Assert.assertEquals(text_exist("Who to follow"), false,"close who to follow");
    	DiscoverPage.fresh();
    	//验证
    	Assert.assertEquals(text_exist("Who to follow"), true,"refresh to view who to follow");
    }
}
