package ckt.ios.page;

import java.util.List;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;

import ckt.App.Util.VP4;

public class MePage extends VP4{
	//Me
	//点击-直播配置
	public static void clickLiveConfiguration_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(0).click();;
	}
	//点击-二维码
	public static void clickQRCode_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(1).click();;
	}
	//点击-消息
	public static void clickMessage_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(2).click();;
	}
	//点击-我的剪辑
	public static void clickEditor_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(3).click();;
	}
	//点击-设置
	public static void clickSetting_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(4).click();;
	}

	//点击-分享
	public static void  clickShareBtn() {
		iosdriver.findElement(By.className("NavigationBar")).findElements(By.className("Button")).get(0).click();;
	}
	//点击-编辑
	public static void clickUserEdit(){
		iosdriver.findElement(By.className("NavigationBar")).findElements(By.className("Button")).get(1).click();;
	}


	//点击-直播
	public static void clickLive(){
		clickByName("Video");
	}
	//点击-关注
	public static void clickFollowingBtn(){
		clickByName("Following");
	}
	//点击-粉丝
	public static void clickFollowsBtn(){
		clickByName("Follower");
	}

	//设置
	//导播控制
	public static void clickAccountSecurity_btn(){
		clickByName("Account and Security");
	}
	//意见反馈
	public static void clickFeedbackbtn(){
		clickByName("Feedback");
	}
	//帮助中心
	public static void clickHelpbtn(){
		clickByName("Help");
	}
	//关于Sioeye
	public static void clickAboutSioeyebtn(){
		clickByName("About Sioeye");
	}
	//me-Edit
	public static void clickNickNameBtn(){
		clickByName("Nick name");
	}
	public static void clickSexBtn(){
		clickByName("Gender");
	}
	public static void clickLocationBtn(){
		clickByName("Location");
	}
	public static void clickInterestBtn(){
		clickByName("Activities");
	}
	public static void clickSignatureBtn(){
		clickByName("About me");
	}
	public static void clickSaveBtn(){
		clickByName("Save");
		wait(3);
		waitTextGone("Save", 20);
	}
	//获取文本框对象
	public static MobileElement getTextField(){
		return ((MobileElement)iosdriver.findElement(By.className("TextField")));
	}
	//获取文本框对象
	public static MobileElement getTextView(){
		return ((MobileElement)iosdriver.findElement(By.className("TextView")));
	}

	//性别设置
	public static void clickSexMale(){
		clickByName("Male");
	}
	public static void clickSexFeMale(){
		clickByName("Female");
	}
	public static void clickSexSecret(){
		clickByName("Privacy");
	}
	public static MobileElement getSearchField(){
		return getElementByClassName("SearchField");
	}
	//编辑头像
	public static void clickAvatar(){
		iosdriver.findElement(By.className("ScrollView")).findElement(By.className("Image")).click();
	}
	//编辑头像-选择拍照
	public static void avatarByCamera(){
		By.className("Button");
		iosdriver.findElement(By.name("Camera")).click();
		MainPage.clickAskToSure_btn();
	}
	//编辑头像-选择拍照
	public static void avatarByGallery(){
		By.className("Button");
		iosdriver.findElement(By.name("Albums")).click();
		MainPage.clickAskToSure_btn();
	}
	//编辑头像-选择拍照-使用照片
	public static void usingPicture(){
		By.className("Button");
		iosdriver.findElement(By.name("Use Photo")).click();
		waitTextGone("Use Photo", 10);
	}
	//拍照
	public static void reCaptureCancel(){
		clickByName("Retake");
		wait(2);
		clickByName("Cancel");
		wait(2);
	}
	//拍照
	public static void clickCapture(){
		clickByName("PhotoCapture");
	}
	//编辑头像-图库-选取
	public static void avatarGalleryDoneCancel(){
		@SuppressWarnings("unchecked")
		List<MobileElement> cells = (List<MobileElement>) iosdriver.findElements(By.className("Cell"));
		MobileElement cell = cells.get(cells.size()-1);		
		cell.click();
		wait(2);
		if (text_exist("Choose")) {
			iosdriver.findElements(By.className("Button")).get(0).click();	
			wait(2);
			clickByName("Cancel");
			wait(2);
		}else {
			avatarGalleryDoneCancel();
		}
	}
	//编辑头像-图库-选取
		public static void avatarGalleryDone(){
			@SuppressWarnings("unchecked")
			List<MobileElement> cells = (List<MobileElement>) iosdriver.findElements(By.className("Cell"));
			MobileElement cell = cells.get(cells.size()-1);		
			cell.click();
			wait(2);
			if (text_exist("Choose")) {
				iosdriver.findElements(By.className("Button")).get(1).click();	
				wait(3);
				waitUntilGone(30,By.className("ActivityIndicator"));
			}else {
				avatarGalleryDone();
			}
		}
	//编辑头像-图库-取消
	public static void avatarGalleryCancel(){
		iosdriver.findElement(By.className("Cell")).click();
		wait(2);
		iosdriver.findElement(By.className("Cell")).click();
		wait(2);
		iosdriver.findElements(By.className("Button")).get(0).click();
		wait(3);
		clickCaptureCancel();
	}
	//取消拍照
	public static void clickCaptureCancel(){
		clickByName("Cancel");
	}
}
