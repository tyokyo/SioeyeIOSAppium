package ckt.ios.testcase.me.edit;

import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ckt.App.Util.Draw;
import ckt.App.Util.VP4;
import ckt.ios.action.InterestAction;
import ckt.ios.action.LoginAction;
import ckt.ios.action.MeAction;
import ckt.ios.page.MePage;

public class InterestCase extends VP4{
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
		resetApp();
		LoginAction.inLoginStatus();
	}
	@Test
	public void testDelAllMyInterest(){
		MeAction.navToInterest();
		InterestAction.delAllMyInterest();
		MePage.clickSaveBtn();
		
		resetApp();
		MeAction.navToInterest();
		List<MobileElement> interests = InterestAction.getMyInterestElements();
		Assert.assertEquals(0, interests.size(), "del All MyInterest");
	}
	@Test
	public void testAddManual(){
		MeAction.navToInterest();
		InterestAction.delAllMyInterest();
		String value = getRandomString(5);
		InterestAction.addInterestByManual(value);
		MePage.clickSaveBtn();
		
		resetApp();
		MeAction.navToInterest();
		List<MobileElement> interests = InterestAction.getMyInterestElements();
		if (interests.size()==1&&interests.get(0).getText().equals(value)) {
			Assert.assertTrue(true,"add success");
		}else {
			Assert.assertTrue(false,"add false");
		}
	}
	@Test
	public void testAddAllInterest(){
		MeAction.navToInterest();
		//delete all interests
		InterestAction.delAllMyInterest();
		//add all interests
		List<MobileElement> allInterests = InterestAction.getInterestElements();
		for (MobileElement mobileElement : allInterests) {
			mobileElement.click();
		}
		MePage.clickSaveBtn();
		
		resetApp();
		
		MeAction.navToInterest();
		//verify interest added
		allInterests = InterestAction.getInterestElements();
		List<MobileElement> myInterests = InterestAction.getMyInterestElements();
		//只验证了前面的4个
		for (int i = 0; i <4; i++) {
			MobileElement activeElement = myInterests.get(i);
			MobileElement expectElement = allInterests.get(i);
			Assert.assertEquals(activeElement.getText(), expectElement.getText(), "assert index-"+i);
			log(String.format("expect is  %s  active is %s", expectElement.getText(),activeElement.getText()));
		}
		Draw.takeScreenShot();
	}
}
