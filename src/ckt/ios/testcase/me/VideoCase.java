package ckt.ios.testcase.me;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ckt.App.Util.VP4;
import ckt.ios.action.LoginAction;

public class VideoCase extends VP4{
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
	//播放视频-主页观看数+1
	@Test
	public void testWatchVoideoHome(){

	}
	//播放视频-播放页面观看数+1
	@Test
	public void testWatchVoideoView(){

	}
	//评论(内容，评论数+1)
	@Test
	public void testComments(){

	}
	//点赞-主页点赞数+1
	@Test
	public void testZanHome(){

	}
	//点赞-观看页面点赞数+1
	@Test
	public void testZanView(){

	}
	//通过拍照修改
	@Test
	public void testSetCoverPlotCamera(){

	}
	//相册选择照片修改
	@Test
	public void testSetCoverPlotAlbums(){

	}
	//取消修改
	@Test
	public void testSetCoverPlotCancel(){

	}
	//修改视频标题
	@Test
	public void testModifyVideoTitle(){

	}
	//修改视频标题-不保存
	@Test
	public void testModifyVideoTitleCancel(){

	}
	//设置为似有视频
	@Test
	public void testSetToPrivateVideo(){

	}
	//设置为公开视频
	@Test
	public void testSetToOpenVideo(){

	}
	//分享
	@Test
	public void testShareVideo(){

	}
	//删除
	@Test
	public void testDelete(){

	}
	//删除
	@Test
	public void testDeleteCancel(){

	}
	//退出
	@Test
	public void testMoreCancel(){

	}
}
