package ckt.ios.testcase.me.edit;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ckt.App.Util.Compare;
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
	public void testChangeAvatarFromCamera() throws Exception{
		//编辑界面
		MeAction.navToUserEdit();
		String beforeTake=Draw.takeScreenShot();
		//点击编辑头像
		MePage.clickAvatar();
		//拍照
		MePage.avatarByCamera();
		Draw.takeScreenShot();
		//拍照
		MePage.clickCapture();
		//使用图片
		MePage.usingPicture();
		String afterTake=Draw.takeScreenShot();
		Draw.takeScreenShotWithDraw("change avatar success");
		float percent = Compare.toCompare(beforeTake, afterTake);
		Assert.assertNotEquals(percent,100, "not simialr");
	}
	@Test
	public void testChangeAvatarFromCameraNotSave() throws Exception{
		//编辑界面
		MeAction.navToUserEdit();
		String beforeTake=Draw.takeScreenShot();
		//点击编辑头像
		MePage.clickAvatar();
		//拍照
		MePage.avatarByCamera();
		Draw.takeScreenShot();
		//拍照
		MePage.clickCapture();
		//使用图片
		MePage.reCaptureCancel();

		String afterTake=Draw.takeScreenShot();
		float percent = Compare.toCompare(beforeTake, afterTake);
		if (percent<99) {
			Assert.assertFalse(true, "similar is "+percent);
		}
	}
	@Test
	public void testChangeAvatarFromGallery(){
		//编辑界面
		MeAction.navToUserEdit();
		//点击编辑头像
		MePage.clickAvatar();
		//从图库选择
		MePage.avatarByGallery();
		Draw.takeScreenShot();

		//选择一图片
		MePage.avatarGalleryDone();
		Draw.takeScreenShotWithDraw("change avatar success");
	}
	@Test
	public void testChangeAvatarFromGalleryNotSace() throws Exception{
		//编辑界面
		MeAction.navToUserEdit();
		String beforeTake=Draw.takeScreenShot();
		//点击编辑头像
		MePage.clickAvatar();
		//从图库选择
		MePage.avatarByGallery();
		Draw.takeScreenShot();

		//选择一图片-不保存
		MePage.avatarGalleryDoneCancel();

		String afterTake=Draw.takeScreenShot();
		float percent = Compare.toCompare(beforeTake, afterTake);
		if (percent<99) {
			Assert.assertFalse(true, "similar is "+percent);
		}
	}
}
