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
			videoElement = cells.get(0);
		}
		return videoElement;
	}
}
