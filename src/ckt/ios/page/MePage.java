package ckt.ios.page;

import ckt.App.Util.VP;

public class MePage extends VP{
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
		clickByXpath("UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	}
	//点击-编辑
	public static void clickUserEdit(){
		clickByXpath("UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	}
	//点击-直播
	public static void clickLive(){
		clickByXpath("UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
	}
	//点击-关注
	public static void clickFollowingBtn(){
		clickByXpath("UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
	}
	//点击-粉丝
	public static void clickFollowsBtn(){
		clickByXpath("UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");
	}

	//设置
	//导播控制
	public static void clickAccountSecurity_btn(){
		clickByName("账号与安全");
	}
	//意见反馈
	public static void clickFeedbackbtn(){
		clickByName("意见反馈");
	}
	//帮助中心
	public static void clickHelpbtn(){
		clickByName("帮助中心");
	}
	//关于Sioeye
	public static void clickAboutSioeyebtn(){
		clickByName("关于Sioeye");
	}


	
	

}
