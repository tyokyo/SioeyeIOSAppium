package ckt.ios.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import ckt.App.Util.VP4;

public class FollowerPage extends VP4{
	public static void clickFollower_btn(){
		//clickByName("Follower");
		clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton[3]");
	}
	//添加关注
	public static boolean canFollow(MobileElement cell){
		boolean can = false;
		try {
			MobileElement bElement = cell.findElement(By.className("Button"));
			can=true;
			//System.out.println(bElement.getAttribute("name"));
		} catch (Exception e) {
			// TODO: handle exception
			can=false;
		}
		return can;
	}
	public static String getFollowName(MobileElement cell){
		//String name = cell.findElement(By.className("StaticText")).getText();
		String name = cell.findElement(By.className("TextField")).getText();
		log("add follow - "+name);
		return name;
	}
	//添加关注
	public static void clickAddFollow(MobileElement cell){
		cell.findElement(By.className("Button")).click();
	}
	//关注/取消关注按钮
	public static void clickPeopleAvartar_btn(){
		clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeButton[3]");
	}
	//添加,取消关注
	public static void clickAddFollowByAvartar(MobileElement cell){
		cell.click();
		clickPeopleAvartar_btn();
		MainPage.clickBack_btn();
		wait(2);
	}
	public static List<MobileElement> getAllEnableCells(){
		List<MobileElement> enableCells=new ArrayList<MobileElement>();
		List<MobileElement> all =getElementsByClassName("Cell");
		for (MobileElement mobileElement : all) {
			if (mobileElement.isDisplayed()&&MainPage.isInScreen(mobileElement)) {
				enableCells.add(mobileElement);
			}
		}
		System.out.println("enable cells find - "+enableCells.size());
		return enableCells;
	}
	//status = true  此好友未被关注
	//status = false  此好友已经被关注
	public static MobileElement swipToFindFollow(boolean status){
		String beforeString="";
		MobileElement  element = null;
		String afterString="";
		boolean exit = false;
		while(!exit){
			List<MobileElement> enableCells = getAllEnableCells();
			for (MobileElement mobileElement : enableCells) {
				if (canFollow(mobileElement)==status) {
					String video = mobileElement.findElement(By.className("StaticText")).getText();
					String title = mobileElement.findElement(By.className("TextField")).getText();
					log("find element with title - "+title);
					log("find element with video - "+video);
					exit=true;
					element= mobileElement;
					break;
				}
			}
			if (!exit) {
				beforeString=iosdriver.getPageSource();
				swipeToUp(iosdriver, 1000, 1);
				wait(2);
				afterString=iosdriver.getPageSource();
				if (beforeString.equals(afterString)) {
					log("scrol to end exit");
					exit=true; 
					break;
				}
			}
		}
		return element;
	}
	//status = true  此好友未被关注
	//status = false  此好友已经被关注
	//存在直播的视频
	public static MobileElement swipToFindFollowWithVideo(boolean status){
		String beforeString="";
		MobileElement  element = null;
		String afterString="";
		boolean exit = false;
		while(!exit){
			List<MobileElement> enableCells = getAllEnableCells();
			for (MobileElement mobileElement : enableCells) {
				if (canFollow(mobileElement)==status) {
					String video = mobileElement.findElement(By.className("StaticText")).getText();
					String title = mobileElement.findElement(By.className("TextField")).getText();
					//获取字符串，类似Follower 2  Video 14
					if (!video.contains("Video 0")) {
						exit=true;
						element= mobileElement;
						log("find element with  title-"+title);
						log("find element with video-"+video);
						break;
					}
				}
			}
			if (!exit) {
				beforeString=iosdriver.getPageSource();
				swipeToUp(iosdriver, 1000, 1);
				wait(2);
				afterString=iosdriver.getPageSource();
				if (beforeString.equals(afterString)) {
					log("scrol to end but not find exit");
					exit=true; 
					break;
				}
			}
		}
		if (element==null) {
			log("not find  video in page");
		}
		return element;
	}
}
