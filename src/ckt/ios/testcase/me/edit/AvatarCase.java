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

public class AvatarCase extends VP4{
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
	public void testChangeAvatarFromCamera(){
		MeAction.navToUserEdit();
		MePage.clickAvatar();
		MePage.avatarByCamera();
		Draw.takeScreenShot();
		
		MePage.clickCapture();
		MePage.usingPicture();
		Draw.takeScreenShot();
	}
	@Test
	public void testChangeAvatarFromGallery(){
		
	}
}
