package ckt.ios.action;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.openqa.selenium.By;

import ckt.App.Util.IElement;
import ckt.App.Util.VP4;
import ckt.ios.page.DiscoverPage;
import ckt.ios.page.MainPage;
import ckt.ios.page.MePage;
import ckt.ios.page.VideoPage;

public class VideoAction extends VP4{
	//通过拍照改变cover
	public static void coverByCamera(){
		MePage.avatarByCamera();
		//拍照
		MePage.clickCapture();
		//使用图片
		MePage.usingPicture();
		//保存
		MePage.clickSaveBtn();
		//wai for loading success
		waitUntilGone(30,By.className("ActivityIndicator"));
	}
	//图库照片选择改变cover
	public static void coverByAlbums(){
		//从图库选择
		MePage.avatarByGallery();
		//选择一图片
		MePage.avatarGalleryDone();
	}

	public static void setVideoPublic(){
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		VideoPage.swipToLeftMore(cellEem);
		if (text_exist("Set to public video")) {
			VideoPage.clickSetVideoOpen();
			wait(5);
		}else {
			clickCancel();			
		}
		cellEem  = VideoPage.chooseFirstLiveStream();
		VideoPage.swipToRight(cellEem);
	}
	public static void setVideoPrivate(){
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		VideoPage.swipToLeftMore(cellEem);
		if (text_exist("Set to private video")) {
			VideoPage.clickSetVideoPrivate();
			wait(5);
		}else {
			clickCancel();			
		}
		cellEem  = VideoPage.chooseFirstLiveStream();
		VideoPage.swipToRight(cellEem);
	}
	//直播列表是否为空
	public static boolean cellsDisplayed(){
		boolean display = false;
		List<MobileElement> cells = getElementsByClassName("Cell");
		for (MobileElement mobileElement : cells) {
			if (mobileElement.isDisplayed()) {
				display=true;
				break;
			}
		}
		return display;
	}
	public static String modifyTitle(IElement cellEem){
		VideoPage.swipToLeftMore(cellEem);
		VideoPage.clickModifyVideoTitle();
		String titleInput= getRandomString(8);
		waitUntilByFind(By.className("Alert"), 10);
		List<IElement> listEms =getIElementsByClassName("XCUIElementTypeTextField");
		IElement textElement=null;
		for (IElement iElement : listEms) {
			System.out.println(iElement.getXpath());
			if (iElement.getXpath().contains("Alert")) {
				textElement=iElement;
				break;
			}
		}
		MobileElement mElement =IElementToMobileElement(textElement);
		setText(mElement,titleInput);
		clickOk();
		wait(5);
		waitUntilFind(10, By.name(titleInput));
		return titleInput;
	}
	public static String modifyTitleCancel(IElement cellEem){
		VideoPage.swipToLeftMore(cellEem);
		VideoPage.clickModifyVideoTitle();
		String titleInput= getRandomString(8);
		waitUntilByFind(By.className("Alert"), 10);
		List<IElement> listEms =getIElementsByClassName("XCUIElementTypeTextField");
		IElement textElement=null;
		for (IElement iElement : listEms) {
			System.out.println(iElement.getXpath());
			if (iElement.getXpath().contains("Alert")) {
				textElement=iElement;
				break;
			}
		}
		MobileElement mElement =IElementToMobileElement(textElement);
		setText(mElement,titleInput);
		clickCancel();
		wait(5);
		return titleInput;
	}
	public static void clickOk(){
		waitUntilFind(10, By.name("OK"));
		if (text_exist("OK")) {
			clickByName("OK");	
			wait(2);
		}
	}
	public static void clickCancel(){
		if (text_exist("Cancel")) {
			clickByName("Cancel");	
			wait(2);
		}
	}
	//直播间获取观看数
	public static int getAnchorWatchCount(){
		//主播
		DiscoverPage.clickAnchor();
		String watchCount = getElementByClassName("ScrollView").findElements(By.className("StaticText")).get(1).getText();
		log("Watch count -  "+watchCount);
		int afterWatch = DiscoverPage.kToInt(watchCount);
		DiscoverPage.clickRoom();
		return afterWatch;
	}
	//直播间获取点赞数
	public static int getAnchorLikeCount(){
		//主播
		DiscoverPage.clickAnchor();
		String zanCount = getElementByClassName("ScrollView").findElements(By.className("StaticText")).get(2).getText();
		log("Zan count -  "+zanCount);
		int zanNumber = DiscoverPage.kToInt(zanCount);
		DiscoverPage.clickRoom();
		return zanNumber;
	}
	//直播间获取评论数
	public static int getAnchorCommentCount(){
		//主播
		DiscoverPage.clickAnchor();
		String commentCount = getElementByClassName("ScrollView").findElements(By.className("StaticText")).get(3).getText();
		log("Zan count -  "+commentCount);
		int commentNumber = DiscoverPage.kToInt(commentCount);
		DiscoverPage.clickRoom();
		return commentNumber;
	}
	public static void navToVideo(){
		MainPage.clickMe_btn();
		VideoPage.clickLive_btn();
		wait(4);
		waitUntilByNotFind(By.name("Loading"), 40);
	}
}
