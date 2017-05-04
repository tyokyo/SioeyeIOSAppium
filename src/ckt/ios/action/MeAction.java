package ckt.ios.action;

import ckt.App.Util.VP;
import ckt.ios.page.MainPage;
import ckt.ios.page.MePage;

public class MeAction  extends VP{
	//输入法->搜索按钮
	public static void clickKeyBoardSearch(){
		clickByClassNameAndName("Button", "Search");
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
		clickByClassName("UIAButton");
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
	
}
