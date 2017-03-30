package ckt.ios.action;

import io.appium.java_client.MobileElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import ckt.App.Util.VP;

public class InterestAction extends VP {
	public static List<MobileElement> getInterestElements(){
		List<MobileElement> inteStrings = new ArrayList<MobileElement>();
		MobileElement selectInterest= (MobileElement) iosdriver.findElements(By.className("CollectionView")).get(0);
		inteStrings = selectInterest.findElements(By.className("StaticText"));
		return inteStrings;
	}
	public static List<MobileElement> getMyInterestElements(){
		List<MobileElement> inteStrings = new ArrayList<MobileElement>();
		MobileElement selectInterest= (MobileElement) iosdriver.findElements(By.className("CollectionView")).get(1);
		inteStrings = selectInterest.findElements(By.className("StaticText"));
		return inteStrings;
	}
	/*删除我的爱好*/
	public static void delAllMyInterest(){
		List<MobileElement> myInterests = getMyInterestElements();
		if (myInterests.size()>=1) {
			myInterests.get(0).click();
			delAllMyInterest();
		}else{
			log("delete all interest finished");
		}
	}
	public static void clickAddBtn(){
		List<MobileElement> lists = (List<MobileElement>) iosdriver.findElements(By.className("Button"));
		int size = lists.size();
		lists.get(size-1).click();
		log("click save button");
	}
	public static void addInterestByManual(String value){
		clickAddBtn();
		setText((MobileElement) iosdriver.findElement(By.className("TextField")),value);
		clickByName("return");
		wait(3);
	}
}
