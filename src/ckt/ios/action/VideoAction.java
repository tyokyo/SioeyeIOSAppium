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
		setText(getElementByClassName("TextField"),titleInput);
		clickOk();
		wait(5);
		waitUntilFind(10, By.name(titleInput));
		return titleInput;
	}
	public static String modifyTitleCancel(IElement cellEem){
		VideoPage.swipToLeftMore(cellEem);
		VideoPage.clickModifyVideoTitle();
		String titleInput= getRandomString(8);
		setText(getElementByClassName("TextField"),titleInput);
		clickCancel();
		wait(5);
		waitUntilFind(10, By.name(titleInput));
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
	public static int getAnchorWatchCount(){
		//主播
		DiscoverPage.clickAnchor();
		String roomXpath = DiscoverPage.getCharRoom().getXpath();
		String afterString=DiscoverPage.getHomeWatchCount(roomXpath);
		log("watch count -  "+afterString);
		int afterWatch = DiscoverPage.kToInt(afterString);
		return afterWatch;
	}
	public static int getAnchorLikeCount(){
		//主播
		DiscoverPage.clickAnchor();
		String roomXpath = DiscoverPage.getCharRoom().getXpath();
		String afterString=DiscoverPage.getHomeZanCount(roomXpath);
		log("like count -  "+afterString);
		int afterWatch = DiscoverPage.kToInt(afterString);
		DiscoverPage.clickRoom();
		return afterWatch;
	}
	public static int getAnchorCommentCount(){
		//主播
		DiscoverPage.clickAnchor();
		String roomXpath = DiscoverPage.getCharRoom().getXpath();
		String afterString=DiscoverPage.getHomeCommentCount(roomXpath);
		log("comment count -  "+afterString);
		int afterWatch = DiscoverPage.kToInt(afterString);
		DiscoverPage.clickRoom();
		return afterWatch;
	}
	public static void navToVideo(){
		MainPage.clickMe_btn();
		VideoPage.clickLive_btn();
		wait(4);
		waitUntilByNotFind(By.name("Loading"), 40);
	}
}
