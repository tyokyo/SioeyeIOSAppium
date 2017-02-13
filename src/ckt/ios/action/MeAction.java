package ckt.ios.action;

import ckt.App.Util.VP;
import ckt.ios.page.MainPage;
import ckt.ios.page.MePage;

public class MeAction  extends VP{
	//账号和安全
	public static void navToAccountAndSecurity(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
		MePage.clickAccountSecurity_btn();
	}
	//意见反馈
	public static void navToFeedback(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
		MePage.clickFeedbackbtn();
	}
	//意见反馈
	public static void navToHelp(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
		MePage.clickHelpbtn();
	}
	//意见反馈
	public static void navToAboutSioeye(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
		MePage.clickAboutSioeyebtn();
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
	public static void navToNickName(){
		navToUserEdit();
		MePage.clickNickNameBtn();
	}
	public static void navToSex(){
		navToUserEdit();
		MePage.clickSexBtn();
	}
	public static void navToLocation(){
		navToUserEdit();
		MePage.clickLocationBtn();
	}
	public static void navToInterest(){
		navToUserEdit();
		MePage.clickInterestBtn();
	}
	public static void navToSignature(){
		navToUserEdit();
		MePage.clickSignatureBtn();
	}
	
	
	
}
