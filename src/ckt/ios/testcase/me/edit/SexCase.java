package ckt.ios.testcase.me.edit;

import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ckt.App.Util.Draw;
import ckt.App.Util.VP4;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.MePage;

public class SexCase extends VP4 {
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		startAppium();
	}
	@AfterClass
	public void afterClass() {
		stopAppium();
	}
	@BeforeMethod
	public void BeforeTest(){
		resetApp(0);
		LoginAction.inLoginStatus();
	}
	@Test
	public void testSexMale(){
		MeAction.navToSex();
		MePage.clickSexMale();
		//验证是否修改成功
		resetApp(0);
		MeAction.navToSex();
		Draw.takeScreenShotWithDraw("Male");
	}
	@Test
	public void testSexFeMale(){
		MeAction.navToSex();
		MePage.clickSexFeMale();
		//验证是否修改成功
		resetApp(0);
		MeAction.navToSex();
		Draw.takeScreenShotWithDraw("FeMale");
	}
	@Test
	public void testSexSecret(){
		MeAction.navToSex();
		MePage.clickSexSecret();
		//验证是否修改成功
		resetApp(0);
		MeAction.navToSex();
		Draw.takeScreenShotWithDraw("secrect");
	}
}
