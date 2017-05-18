package ckt.ios.action;

import java.util.List;

import org.dom4j.Element;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import ckt.App.Util.IElement;
import ckt.App.Util.VP4;
import ckt.ios.page.DiscoverPage;
import ckt.ios.page.MainPage;
import ckt.ios.page.MePage;
import ckt.ios.page.VideoPage;

public class MeAction  extends VP4{
	//直播数
	public static String getAnchorVideoCount(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		//观看视频
		cellEem.click();
		DiscoverPage.clickAnchor();
		Element element =getElementContains("XCUIElementTypeStaticText", "Videos");
		String videoStr = element.attributeValue("name").replace("Videos", "").trim();
		System.out.println(videoStr);
		return videoStr;
	}
	//粉丝数
	public static int getAnchorFollowerCount(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		//观看视频
		cellEem.click();
		DiscoverPage.clickAnchor();
		Element element =getElementContains("XCUIElementTypeStaticText", "Followers");
		String followerString = element.attributeValue("name").replace("Followers", "").trim();
		System.out.println(followerString);
		return  Integer.parseInt(followerString);
	}
	//粉丝数
	public static int getPersonalFollowerCount(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		//观看视频
		cellEem.click();
		DiscoverPage.clickAnchor();
		getElementByClassName("ScrollView", "Button").click();
		waitUntilByFind(By.name("Video"), 5);
		Element velement =getElement("XCUIElementTypeStaticText", "Follower");
		List<Element> ems  = velement.getParent().elements("XCUIElementTypeStaticText");
		String followerString = ems.get(0).attributeValue("name");
		System.out.println(followerString);
		return  Integer.parseInt(followerString);
	}
	//直播数
	public static int getPersonalVideoCount(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		//观看视频
		cellEem.click();
		DiscoverPage.clickAnchor();
		getElementByClassName("ScrollView", "Button").click();
		waitUntilByFind(By.name("Video"), 5);
		Element velement =getElement("XCUIElementTypeStaticText", "Video");
		List<Element> ems  = velement.getParent().elements("XCUIElementTypeStaticText");
		String videoString = ems.get(0).attributeValue("name");
		System.out.println(videoString);
		return  Integer.parseInt(videoString);
	}
	//关注数
	public static int getPersonalFollowingCount(){
		VideoAction.navToVideo();
		IElement cellEem  = VideoPage.chooseFirstLiveStream();
		//观看视频
		cellEem.click();
		DiscoverPage.clickAnchor();
		getElementByClassName("ScrollView", "Button").click();
		waitUntilByFind(By.name("Video"), 5);
		Element velement =getElement("XCUIElementTypeStaticText", "Following");
		List<Element> ems  = velement.getParent().elements("XCUIElementTypeStaticText");
		String followingString = ems.get(0).attributeValue("name");
		System.out.println(followingString);
		return  Integer.parseInt(followingString);
	}
	//设置-账号和安全
	public static void navToAccountAndSecurity(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
		MePage.clickAccountSecurity_btn();
	}
	//设置-意见反馈
	public static void navToFeedback(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
		MePage.clickFeedbackbtn();
	}
	//设置-帮助
	public static void navToHelp(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
		MePage.clickHelpbtn();
	}
	//设置-关于Sioeye
	public static void navToAboutSioeye(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
		MePage.clickAboutSioeyebtn();
	}
	//设置-帮助-Terms of service
	public static void navToHelp_TOS(){
		navToHelp();
		MePage.clickTosbtn();
	}
	//设置-帮助-Terms of service
	public static void navToHelp_PrivacyPlolicy(){
		navToHelp();
		MePage.clickPrivacyPolicybtn();
	}
	//设置-帮助-Terms of service
	public static void navToHelp_EULA(){
		navToHelp();
		MePage.clickEulabtn();
	}
	//设置-帮助-Terms of service
	public static void navToHelp_Help(){
		navToHelp();
		wait(2);
		MePage.clickHelpHelpbtn();
	}
	//click back
	public static void clickBackBtn(){
		clickByClassName("Button");
	}
	//意见反馈
	public static void navToUserEdit(){
		MainPage.clickMe_btn();
		MePage.clickUserEdit();
	}
	//昵称
	public static void navToNickName(){
		navToUserEdit();
		MePage.clickNickNameBtn();
	}
	//性别
	public static void navToSex(){
		navToUserEdit();
		MePage.clickSexBtn();
	}
	//位置
	public static void navToLocation(){
		navToUserEdit();
		MePage.clickLocationBtn();
		if (text_exist("Allow")) {
			clickByName("Allow");
		}
	}
	//爱好
	public static void navToInterest(){
		navToUserEdit();
		MePage.clickInterestBtn();
	}
	//签名
	public static void navToSignature(){
		navToUserEdit();
		MePage.clickSignatureBtn();
	}
	//直播
	public static void navToLiveConfiguration(){
		MainPage.clickMe_btn();
		MePage.clickLiveConfiguration_btn();
	}
	//修改标题
	public static void navToLiveDefaultVideoTitle(){
		navToLiveConfiguration();
		MePage.clickDefaultVideoTitle();
	}
	//权限设置
	public static void navToWhoCanViewMyBroadcase(){
		navToLiveConfiguration();
		MePage.clickWhoCanViewMyBroadcast();
	}
	//修改直播封面
	public static void navToCoverPlot(){
		navToLiveConfiguration();
		MePage.clickCoverPlot();
	}
	//QR code
	public static void navToQrCode(){
		MainPage.clickMe_btn();
		MePage.clickQRCode_btn();
	}
	//通知
	public static void navToNotification(){
		MainPage.clickMe_btn();
		MePage.clickNotification_btn();
	}
	//Camera
	public static void navToCamera(){
		MainPage.clickMe_btn();
		MePage.clickCamera_btn();
	}
	//Settings
	public static void navToSettings(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
	}
	//分享
	public static void navToShare(){
		MainPage.clickMe_btn();
		MePage.clickShareBtn();
	}
	//获取nickname
	public static String getNickName(){
		MeAction.navToNickName();
		MobileElement textField = MePage.getTextField();
		String name = textField.getText();
		resetApp(1);
		return name;
	}
}
