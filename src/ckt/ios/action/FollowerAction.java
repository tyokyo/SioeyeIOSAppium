package ckt.ios.action;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import ckt.App.Util.VP4;
import ckt.ios.page.FollowerPage;
import ckt.ios.page.MainPage;

public class FollowerAction extends VP4{
	public static void navToFollower(){
		MainPage.clickMe_btn();
		FollowerPage.clickFollower_btn();
	}
	public static MobileElement chooseVideo(){
		MobileElement videoElement=null;
		MobileElement collectionViewElement =getElementByClassName("CollectionView");
		List<MobileElement> cells = collectionViewElement.findElements(By.className("Cell"));
		if (cells.size()>=1) {
			log("find video");
			//获取不是预定直播间的直播间,如果属于预定直播间，视频将不能播放
			for (MobileElement mobileElement : cells) {
				try {
					mobileElement.findElement(By.name("LiveConfigLiveRoomRoom"));
				} catch (Exception e) {
					// TODO: handle exception
					videoElement=mobileElement;
					break;
				}
			}
		}
		return videoElement;
	}
	
}
