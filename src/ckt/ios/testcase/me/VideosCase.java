package ckt.ios.testcase.me;

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
import ckt.ios.page.VideoPage;
/*直播*/
public class VideosCase extends VP4{
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
	//播放视频-主页观看数+1
	@Test
	public void testWatchVoideoHome(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		int watchBefore = VideoPage.getLiveWatchCount(cellEem);
		//观看视频
		cellEem.click();

		waitUntilGone(30,By.className("ActivityIndicator"));
		//返回
		DiscoverPage.watchBack();
		//刷新
		VideoPage.slipeToRefresh();
		int watchAfter = VideoPage.getLiveWatchCount(cellEem);
		//验证观看数目+1
		Assert.assertEquals(watchAfter, watchBefore+1,"watch video +1");
	}
	//播放视频-播放页面观看数+1
	@Test
	public void testWatchVoideoView(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		int watchBefore = VideoPage.getLiveWatchCount(cellEem);
		//观看视频
		cellEem.click();
		//等待加载完成
		waitUntilGone(30,By.className("ActivityIndicator"));
		//获取观看数
		int watchAfter =VideoAction.getAnchorWatchCount();
		DiscoverPage.watchBack();
		//观看数+1
		Assert.assertEquals(watchAfter, watchBefore+1,"watch video +1");
	}
	//评论(内容，评论数+1)
	@Test
	public void testCommentsHome(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		//获取评论数
		int commentBefore = VideoPage.getLiveCommentCount(cellEem);
		//观看视频
		cellEem.click();

		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		//评论
		String cmt =  getRandomString(8);
		setText(getElementByClassName("TextField"),cmt);
		MainPage.clickSend();
		DiscoverPage.clickVieNewMessage();
		
		//返回
		DiscoverPage.watchBack();
		//刷新
		VideoPage.slipeToRefresh();
		//获取评论数
		int commentAfter = VideoPage.getLiveCommentCount(cellEem);
		//验证评论数+1
		Assert.assertEquals(commentAfter, commentBefore+1,"comment count +1");
	}
	//评论(内容，评论数+1)-直播间评论数+1
	@Test
	public void testCommentsView(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		//获取评论数
		int commentBefore = VideoPage.getLiveCommentCount(cellEem);
		//观看视频
		cellEem.click();

		waitUntilGone(30,By.className("ActivityIndicator"));
		DiscoverAction.waitForConnect();
		//评论
		String cmt =  getRandomString(8);
		setText(getElementByClassName("TextField"),cmt);
		MainPage.clickSend();
		DiscoverPage.clickVieNewMessage();
		
		//进入直播间获取评论数
		int commentAfter =VideoAction.getAnchorCommentCount();
		DiscoverPage.watchBack();
		
		//验证评论数+1
		Assert.assertEquals(commentAfter, commentBefore+1,"comment count +1");
	}
	//点赞-主页点赞数+1
	@Test
	public void testZanHome(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		//获取点赞数
		int zanBefore = VideoPage.getLiveLikeCount(cellEem);
		//观看视频
		cellEem.click();
		//等待视频加载完成
		waitUntilGone(30,By.className("ActivityIndicator"));
		//点赞
		DiscoverPage.clickZan();
		//返回
		DiscoverPage.watchBack();
		//刷新
		VideoPage.slipeToRefresh();
		//获取点赞数
		int zanAfter = VideoPage.getLiveLikeCount(cellEem);
		//验证观看数目+1
		Assert.assertEquals(zanAfter, zanBefore+1,"like video +1");
	}
	//点赞-直播间观看数目+1
	@Test
	public void testZanView(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		//获取点赞数
		int watchBefore = VideoPage.getLiveLikeCount(cellEem);
		//观看视频
		cellEem.click();
		//等待加载完成
		waitUntilGone(30,By.className("ActivityIndicator"));
		//点赞
		DiscoverPage.clickZan();
		//获取点赞数
		int watchAfter =VideoAction.getAnchorLikeCount();
		DiscoverPage.watchBack();
		//观看数+1
		Assert.assertEquals(watchAfter, watchBefore+1,"like count +1");
	}
	//通过拍照修改
	@Test
	public void testSetCoverPlotCamera(){
		VideoAction.navToVideo();
		//设置视频public
		VideoAction.setVideoPublic();
		//滑动
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		VideoPage.swipToLeft(cellEem);
		//设置cover
		VideoPage.clickSettingCoverPlot();
		VideoAction.coverByCamera();
		
	}
	//相册选择照片修改
	@Test
	public void testSetCoverPlotAlbums(){
		VideoAction.navToVideo();
		//设置视频public
		VideoAction.setVideoPublic();
		//滑动
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		VideoPage.swipToLeft(cellEem);
		//设置cover
		VideoPage.clickSettingCoverPlot();
		VideoAction.coverByAlbums();
	}
	//取消修改
	@Test
	public void testSetCoverPlotCancel(){
		VideoAction.navToVideo();
		//设置视频public
		VideoAction.setVideoPublic();
		//滑动
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		VideoPage.swipToLeft(cellEem);
		//设置cover
		VideoPage.clickSettingCoverPlot();
		VideoAction.clickCancel();
	}
	//修改视频标题
	@Test
	public void testModifyVideoTitle(){
		VideoAction.navToVideo();
		if (VideoAction.cellsDisplayed()) {
			//获取直播视频
			IElement cellEem  = VideoPage.chooseFirstLiveStream();
			//获取title
			String titleBefore = VideoPage.getLiveTitle(cellEem);
			//修改title
			String titleInput=VideoAction.modifyTitle(cellEem);
			//实际title
			cellEem  = VideoPage.chooseFirstLiveStream();
			String titleActual = VideoPage.getLiveTitle(cellEem);
			//验证
			Assert.assertNotEquals(titleBefore, titleActual,"modify title-"+titleInput);
			Assert.assertEquals(titleActual, titleInput,"modify title-"+titleInput);
		}
	}
	//修改视频标题-不保存
	@Test
	public void testModifyVideoTitleCancel(){
		VideoAction.navToVideo();
		if (VideoAction.cellsDisplayed()) {
			//获取直播视频
			IElement cellEem  = VideoPage.chooseFirstLiveStream();
			//获取title
			String titleExpect = VideoPage.getLiveTitle(cellEem);
			//修改title
			String titleInput=VideoAction.modifyTitleCancel(cellEem);
			//实际title
			cellEem  = VideoPage.chooseFirstLiveStream();
			VideoPage.swipToRight(cellEem);
			String titleActual = VideoPage.getLiveTitle(cellEem);
			//验证
			Assert.assertEquals(titleActual, titleExpect,"modify title-cancel-"+titleInput);
		}
	}
	//设置为似有视频
	@Test
	public void testSetToPrivateVideo(){
		VideoAction.navToVideo();
		if (VideoAction.cellsDisplayed()) {
			VideoAction.setVideoPrivate();
		}
	}
	//设置为公开视频
	@Test
	public void testSetToOpenVideo(){
		VideoAction.navToVideo();
		if (VideoAction.cellsDisplayed()) {
			VideoAction.setVideoPublic();
		}
	}
	//分享
	@Test
	public void testShareVideo(){
		VideoAction.navToVideo();
		if (VideoAction.cellsDisplayed()) {
			//设置video public
			VideoAction.setVideoPublic();
			
			//获取直播视频
			IElement cellEem  = VideoPage.chooseFirstLiveStream();
			//滑动
			VideoPage.swipToLeftMore(cellEem);
			VideoPage.clickShareVideo();
			waitUntilTextExist("More", 30);
			Assert.assertEquals(text_exist("Friends"), true,"Friends");
			Assert.assertEquals(text_exist("Moments"), true,"Moments");
			Assert.assertEquals(text_exist("Weibo"), true,"Weibo");
			Assert.assertEquals(text_exist("Q-zone"), true,"Q-zone");
			VideoAction.clickCancel();
		}
	}
	//删除
	@Test
	public void testDelete(){
		VideoAction.navToVideo();
		if (VideoAction.cellsDisplayed()) {
			//获取直播视频
			IElement cellEem  = VideoPage.chooseFirstLiveStream();
			//修改title
			String titleModify=VideoAction.modifyTitle(cellEem);
			//删除视频
			cellEem  = VideoPage.chooseFirstLiveStream();
			VideoPage.swipToLeftMore(cellEem);
			//删除
			VideoPage.clickDeleteVideo();
			VideoAction.clickOk();
			//验证
			Assert.assertEquals(text_exist(titleModify), false,"delete-video with title-"+titleModify);
		}
		
	}
	//删除
	@Test
	public void testDeleteCancel(){
		VideoAction.navToVideo();
		if (VideoAction.cellsDisplayed()) {
			//获取直播视频
			IElement cellEem  = VideoPage.chooseFirstLiveStream();
			//获取title
			String titleExpect = VideoPage.getLiveTitle(cellEem);
			//删除视频
			cellEem  = VideoPage.chooseFirstLiveStream();
			VideoPage.swipToLeftMore(cellEem);
			//删除
			VideoPage.clickDeleteVideo();
			VideoAction.clickCancel();
			//验证
			Assert.assertEquals(text_exist(titleExpect), true,"delete-video cancel with");
		}
	}
	//退出
	@Test
	public void testMoreCancel(){
		VideoAction.navToVideo();
		if (VideoAction.cellsDisplayed()) {
			//获取直播视频
			IElement cellEem  = VideoPage.chooseFirstLiveStream();
			//滑动
			VideoPage.swipToLeftMore(cellEem);
			VideoAction.clickCancel();
			//验证
			Assert.assertEquals(text_exist("More"), true);
			VideoPage.swipToRight(cellEem);
		}
	}
}
