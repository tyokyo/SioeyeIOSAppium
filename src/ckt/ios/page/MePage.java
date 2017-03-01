package ckt.ios.page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;

import ckt.App.Util.VP4;

public class MePage extends VP4{
	//Me
	//点击-直播配置
	public static void clickLiveConfiguration_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
	}
	//点击-二维码
	public static void clickQRCode_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]");
	}
	//点击-消息
	public static void clickMessage_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]");
	}
	//点击-我的剪辑
	public static void clickEditor_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]");
	}
	//点击-设置
	public static void clickSetting_btn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[5]");
	}
	//点击-分享
	public static void  clickShareBtn() {
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	}
	//点击-编辑
	public static void clickUserEdit(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	}
	//点击-直播
	public static void clickLive(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
	}
	//点击-关注
	public static void clickFollowingBtn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
	}
	//点击-粉丝
	public static void clickFollowsBtn(){
		clickByXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");
	}

	//设置
	//导播控制
	public static void clickAccountSecurity_btn(){
		clickElementByName("账号与安全");
	}
	//意见反馈
	public static void clickFeedbackbtn(){
		clickElementByName("意见反馈");
	}
	//帮助中心
	public static void clickHelpbtn(){
		clickElementByName("帮助中心");
	}
	//关于Sioeye
	public static void clickAboutSioeyebtn(){
		clickElementByName("关于Sioeye");
	}
	public static void clickNickNameBtn(){
		clickElementByName("昵称");
	}
	public static void clickSexBtn(){
		clickElementByName("性别");
	}
	public static void clickLocationBtn(){
		clickElementByName("地区");
	}
	public static void clickInterestBtn(){
		clickElementByName("爱好");
	}
	public static void clickSignatureBtn(){
		clickElementByName("个性签名");
	}
	public static void clickSaveBtn(){
		clickElementByName("保存");
		wait(3);
		waitTextExists("个性签名", 20);
	}
	public static MobileElement getUIATextView(){
		return ((MobileElement)iosdriver.findElement(By.className("UIATextView")));
	}

}
