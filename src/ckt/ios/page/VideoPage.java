package ckt.ios.page;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import ckt.App.Util.IElement;
import ckt.App.Util.Log;
import ckt.App.Util.VP4;
import ckt.ios.action.VideoAction;

public class VideoPage  extends VP4{
	public static void clickModifyVideoTitle(){
		log("Modify the video title");
		clickByName("Modify the video title");
	}

	public static void clickSetVideoOpen(){
		log("Set to open video");
		clickByName("Set to open video");
	}
	public static void clickSetVideoPrivate(){
		log("Set to open video");
		clickByName("Set to private video");
	}
	//删除视频
	public static void clickDeleteVideo(){
		log("delete video selected");
		clickByName("Delete");
	}
	//分享视频
	public static void clickShareVideo(){
		log("share video selected");
		clickByName("Share");
	}
	//左滑动-More
	public static void swipToLeftMore(IElement cellEem ){
		MobileElement mElement =IElementToMobileElement(cellEem);
		swipeTo(mElement, "LEFT");
		waitUntilFind(By.name("More"), 30);
		clickMore();
	}
	//左滑动-More
	public static void swipToLeft(IElement cellEem ){
		MobileElement mElement =IElementToMobileElement(cellEem);
		swipeTo(mElement, "LEFT");
	}
	//右滑动
	public static void swipToRight(IElement cellEem ){
		MobileElement mElement =IElementToMobileElement(cellEem);
		swipeTo(mElement, "RIGHT");
		wait(3);
		VideoAction.clickCancel();
		wait(3);
	}
	//More
	public static void clickMore(){
		clickByName("More");
	}
	public static void clickLive_btn(){
		//clickByName("Videos");
		clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton[1]");
	}
	public static void clickSettingCoverPlot(){
		log("click setting the cover plot");
		if (text_exist("Setting the cover plot")) {
			clickByClassNameAndName("Button", "Setting the cover plot");
		}
		if (text_exist("Update the cover plot")) {
			clickByClassNameAndName("Button", "Update the cover plot");
		}
		
	}
	//选择一个直播
	public static IElement  chooseFirstLiveStream(){
		IElement cellEem = DiscoverPage.getFirstCell();
		return cellEem;
	}
	//获取直播标题
	public static String  getLiveTitle(IElement cellEem){
		String cellpath=cellEem.getXpath();
		String titlepath = cellpath+"/XCUIElementTypeStaticText[1]";
		String title = getElementByXpath(titlepath).getText();
		log("title - "+title);
		return title;
	}
	//获取直播观看数目
	public static int  getLiveWatchCount(IElement cellEem){
		String cellpath=cellEem.getXpath();
		String watchpath = cellpath+"/XCUIElementTypeStaticText[3]";
		String watch = getElementByXpath(watchpath).getText();
		log("watch-"+watch);
		return Integer.parseInt(watch);
	}
	//获取直播点赞数目
	public static int  getLiveLikeCount(IElement cellEem){
		String cellpath=cellEem.getXpath();
		String likepath = cellpath+"/XCUIElementTypeStaticText[4]";
		String like = getElementByXpath(likepath).getText();
		log("like - "+like);
		return Integer.parseInt(like);
	}
	public static int  getLiveCommentCount(IElement cellEem){
		String cellpath=cellEem.getXpath();
		String commentpath = cellpath+"/XCUIElementTypeStaticText[5]";
		String comment = getElementByXpath(commentpath).getText(); 
		log("comment - "+comment);
		return Integer.parseInt(comment);
	}
	public static void slipeToRefresh(){
		swipeToBegin(iosdriver, 50);
		int width = iosdriver.manage().window().getSize().width;  
		int height = iosdriver.manage().window().getSize().height;  
		for (int i = 1; i <= 3; i++) {  
			iosdriver.swipe(width / 2, height*2 / 6, width / 2, height * 5 / 6, 500);  
			Log.info("swipeToDown-"+i);
			wait(1);  
		}  
		wait(5);
	}
}
////XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[4]