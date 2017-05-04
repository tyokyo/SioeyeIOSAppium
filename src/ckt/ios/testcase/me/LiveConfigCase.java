package ckt.ios.testcase.me;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ckt.App.Util.Draw;
import ckt.App.Util.VP4;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.MainPage;
import ckt.ios.page.MePage;

public class LiveConfigCase extends VP4{
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
	@Test
	public void testDefaultVideoTitleSpace(){
		MeAction.navToLiveConfiguration();
		String title =MePage.getBroadcastTitleHasConfig();
		MePage.clickDefaultVideoTitle();
		MePage.getTextView().clear();
		MePage.clickSaveBtn();
		MainPage.clickBack_btn();
		String activeTitle =MePage.getBroadcastTitleHasConfig();
		Assert.assertEquals(activeTitle, title);
	}
	@Test
	public void testModifyDefaultVideoTitle(){
		MeAction.navToLiveDefaultVideoTitle();
		String expect = getRandomString(30);
		setText(MePage.getTextView(), expect);
		MePage.clickSaveBtn();
		String activeTitle =MePage.getBroadcastTitleHasConfig();
		MePage.clickDefaultVideoTitle();
		String titleConfig = MePage.getTextView().getText();
		Assert.assertEquals(titleConfig, expect);
		Assert.assertEquals(activeTitle, expect);
		MainPage.clickBack_btn();
	}
	@Test
	public void testLiveViewerPublic(){
		MeAction.navToWhoCanViewMyBroadcase();
		MePage.clickVisibility_Public();
		MePage.clickConfirm();
		String whoCan = MePage.getWhoCanViewHasConfig();
		Assert.assertEquals(whoCan, "Public","make public");

	}
	@Test
	public void testLiveViewerPrivate(){
		MeAction.navToWhoCanViewMyBroadcase();
		MePage.clickVisibility_Private();
		MePage.clickConfirm();
		String whoCan = MePage.getWhoCanViewHasConfig();
		Assert.assertEquals(whoCan, "Private","make public");

	}
	@Test
	public void testLiveViewerSomeOne(){
		MeAction.navToWhoCanViewMyBroadcase();
		MePage.clickVisibility_SomeOne();
		MePage.visibilitySomeOneDelAll();
		//选择添加一个好友
		MePage.visibilitySomeOneChoose(1);

		MePage.clickConfirm();
		MePage.clickConfirm();
		String whoCan = MePage.getWhoCanViewHasConfig();
		Assert.assertEquals(whoCan, "Visible to someone","make someone");

	}
	@Test
	public void testCoverPlotCamera(){
		MeAction.navToLiveConfiguration();
		String expect = MePage.getCoperStatus();
		MePage.clickCoverPlot();

		MePage.avatarByCamera();
		//拍照
		MePage.clickCapture();
		//使用图片
		MePage.usingPicture();
		//保存
		MePage.clickSaveBtn();
		//wai for loading success
		waitUntilGone(30,By.className("ActivityIndicator"));

		String active = MePage.getCoperStatus();
		if (expect.equals("None")) {
			Assert.assertEquals("Activated", active,"None");
		}else {
			Assert.assertEquals(expect, active,"Activated-inActivated");
		}
	}
	@Test
	public void testCoverPlotAlbums(){
		MeAction.navToLiveConfiguration();
		String expect = MePage.getCoperStatus();
		MePage.clickCoverPlot();
		//从图库选择
		MePage.avatarByGallery();
		//选择一图片
		MePage.avatarGalleryDone();
		//wai for loading success
		String active = MePage.getCoperStatus();
		if (expect.equals("None")) {
			Assert.assertEquals("Activated", active,"None");
		}else {
			Assert.assertEquals(expect, active,"Activated-inActivated");
		}
	}
	@Test
	public void testCoverPlotCancel(){
		MeAction.navToLiveConfiguration();
		String expect = MePage.getCoperStatus();
		MePage.clickCoverPlot();
		
		MePage.clickCaptureCancel();
		String active = MePage.getCoperStatus();

		Assert.assertEquals(expect,active,"coper-cancel");
	}
}
