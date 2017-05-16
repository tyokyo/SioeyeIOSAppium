package ckt.ios.testcase.discover;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import ckt.App.Util.VP4;
import ckt.ios.action.MainAction;
import ckt.ios.page.DiscoverPage;

/**
 * Created by user on 2016/11/05   .
 */
public class RecommendCase extends VP4 {

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
    /**case3添加推荐列表第一个为好友
     * 检查该用户followers有没有增加;
     * 检查自己好友列表有没有增加该好友
     */
    public void testAddDelFriendsRed() {
    	MainAction.navToDiscover();
		//获取推荐列表
		List<MobileElement> rmdList = DiscoverPage.getRecommandList();
		if (rmdList.size()>=1) {
			MobileElement select = rmdList.get(0);
			select.click();
			String name = DiscoverPage.getRecommandName(select);
			DiscoverPage.clickRecommandFollow();
			resetApp(0);
			//Followers + 1 
			
		}
    }
    @Test
    /**case4 滑动推荐列表后关注第二个推荐用户
     * 检查该用户followers有没有增加;
     *  并到Me关注好友去寻找是否添加成功
     */
    public void testSwipeRecommendAD() {
    	
    }
    @Test
    /**case6 刷新discover后检查推荐follow列表是否更新
     * 检查刷新前后，前三个用户是否完全一致，判断是否刷新成功
     */
    public void testRefreshRecommendList() {
    	
    }
    @Test
    /**case 7 Follow一个推荐列表好友后，刷新discover，
     * 检查该好友是否从discover消失
     */
    public void testFollowThenRefresh() {
    	
    }
    @Test
    /*
    关闭推荐列表
    点击推荐列表右上角关闭按钮
    检查推荐列表是否存在
     */
    public void testCloseRedList() {
    	MainAction.navToDiscover();
		DiscoverPage.clickKillWhoToFollow();
		wait(4);
		DiscoverPage.fresh();
		waitUntilFind(By.name("Who to follow"), 20);
    }
    @Test
    /*
    关闭推荐列表
    点击推荐列表右上角关闭按钮
    检查推荐列表是否存在
    刷新列表
    推荐列表恢复显示
     */
    public void testRecoverRedList() {
    	
    }
}
