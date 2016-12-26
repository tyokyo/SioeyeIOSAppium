package ckt.ios.action;

import ckt.App.Util.VP;
import ckt.ios.page.MainPage;
import ckt.ios.page.MePage;

public class MeAction  extends VP{
	public static void navToAccountAndSecurity(){
		MainPage.clickMe_btn();
		MePage.clickSetting_btn();
		MePage.clickAccountSecurity_btn();
	}
	
}
