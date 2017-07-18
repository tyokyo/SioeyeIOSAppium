package ckt.ios.page;

import java.util.List;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ckt.App.Util.VP4;

public class MePage extends VP4{
	//Me
	//点击-直播配置 - liceConfiguration
	public static void clickLiveConfiguration_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(0).click();;
	}
	//点击-直播配置 - liceConfiguration
	public static void clickVIPRights_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(1).click();;
	}
	//点击-二维码 -QR code
	public static void clickQRCode_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(2).click();;
	}
	//点击-消息-Notification
	public static void clickNotification_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(3).click();;
	}
	//点击-Camera
	public static void clickCamera_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(4).click();;
	}
	//点击-设置
	public static void clickSetting_btn(){
		iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(5).click();;
	}

	//点击-分享
	public static void  clickShareBtn() {
		iosdriver.findElement(By.className("NavigationBar")).findElements(By.className("Button")).get(0).click();
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
	//帮助中心->TOS
	public static void clickTosbtn(){
		clickByName("Terms of Service");
	}
	//帮助中心->Privacy policy
	public static void clickPrivacyPolicybtn(){
		clickByName("Privacy policy");
	}
	//帮助中心->EULA
	public static void clickEulabtn(){
		clickByName("End User License Agreement（EULA）");
	}
	public static void returnToSioeye(){
		waitUntilFind(By.name("Return to Sioeye"), 10);
		clickByName("Return to Sioeye");
	}
	//帮助中心-HELP
	public static void clickHelpHelpbtn(){
		//clickByName("Help");
		clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeStaticText");
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
		return getElementByClassName("TextField");
	}
	//获取文本框对象
	public static MobileElement getTextView(){
		return getElementByClassName("TextView");
	}
	//获取文本框对象
	public static MobileElement getStaticText(){
		//getElementByClassName("StaticText");
		return  getElementsByClassName("StaticText").get(1);

	}
	//性别设置
	public static void clickSexMale(){
		clickByName("Male");
	}
	public static void clickSexFeMale(){
		clickByName("Female");
	}
	public static void clickSexSecret(){
		clickByName("Privary");
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
		clickByName("Camera");
		MainPage.clickAskToSure_btn();
	}
	//编辑头像-选择拍照
	public static void avatarByGallery(){
		clickByClassNameAndName("Button", "Albums");
		MainPage.clickAskToSure_btn();
	}
	//编辑头像-选择拍照-使用照片
	public static void usingPicture(){
		clickByClassNameAndName("Button", "Use Photo");
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
		for (int i = 0; i < 8; i++) {
			if (classExist("Cell")) {
				List<MobileElement> cells =getElementsByClassName("Cell");
				int size = cells.size();
				if (size>=2) {
					MobileElement cell = cells.get(1);		
					cell.click();
					wait(2);
				}else {
					log("there is no picture to be seelcted");
					break;
				}
			}
			if (text_exist("OK")) {
				clickByName("OK");
			}
			if (text_exist("Choose")) {
				//Cancel 不选择
				clickByName("Cancel");
				wait(2);
				clickByTextContains("Cancel");
				break;
			}
		}
		
	}
	//编辑头像-图库-选取
	public static void avatarGalleryDone(){
		log("avatarGalleryDone");
		waitUntilFind(30, By.className("Cell"));
		for (int i = 0; i < 10; i++) {
			if (classExist("Cell")) {
				List<MobileElement> cells = getElementsByClassName("Cell");
				//选择第一个Cell
				int size = cells.size();
				log("Cell Size is  "+size);
				if (size>=2) {
					MobileElement cell = cells.get(1);		
					cell.click();
					wait(2);
					//avatarGalleryDone();
				}else {
					log("there is no picture to be seelcted");
					break;
				}
			}
			if (text_exist("OK")) {
				clickByName("OK");
			}
			if (text_exist("Choose")) {
				//click choose
				clickByName("Choose");
				wait(3);
				waitUntilGone(30,By.className("ActivityIndicator"));
				break;
			}
			if (text_exist("Save")) {
				//click choose
				MePage.clickSaveBtn();
				wait(3);
				waitUntilGone(30,By.className("ActivityIndicator"));
				break;
			}
		}
		//Cell isDisplayed -= false
	}
	//编辑头像-图库-取消
	public static void avatarGalleryCancel(){
		clickByClassName("Cell");
		wait(2);
		clickByClassName("Cell");
		wait(2);
		clickByClassNameIndex("Button", 0);
		wait(3);
		clickCaptureCancel();
	}
	//取消拍照
	public static void clickCaptureCancel(){
		clickByName("Cancel");
	}
	/*live configuration*/
	public static void clickDefaultVideoTitle(){
		log("click Default video title");
		clickByClassNameIndex("Cell", 0);
	}

	public static void clickWhoCanViewMyBroadcast(){
		log("clickWhoCanViewMyBroadcast");
		clickByClassNameIndex("Cell", 1);
	}
	public static void clickCoverPlot(){
		log("clickCoverPlot");
		clickByName("Cover plot");
		//iosdriver.findElements(By.className("Cell")).get(3).click();
	}
	public static void clickCoperActived(){
		if (text_exist("inactivated")) {
			clickByName("Activated");
		}
	}
	public static void clickCoperInActived(){
		if (text_exist("Activated")) {
			clickByName("inactivated");
		}
	}
	public static String getCoperStatus(){
		String status ="None";
		try {
			getElementByClassNameAndName("Button", "Inactivated");
			status="inactivated";
		} catch (Exception e) {
			// TODO: handle exception
			log("Exception-inactivated not find...");
		}

		try {
			getElementByClassNameAndName("Button", "Activated");
			status="Activated";
		} catch (Exception e) {
			// TODO: handle exception
			log("Exception-Activated not find...");
		}
		log("status is "+status);
		return status;
	}
	public static void getDefaultTitleLengthLeft(){
		MobileElement len = getElementByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
		System.out.println(len.getText());
	}
	public static String getBroadcastTitleHasConfig(){
		log("getBroadcastTitleHasConfig");
		return iosdriver.findElements(By.className("Cell")).get(0).findElements(By.className("StaticText")).get(1).getAttribute("name");
	}
	public static String getWhoCanViewHasConfig(){
		log("getWhoCanViewHasConfig");
		return iosdriver.findElements(By.className("Cell")).get(1).findElements(By.className("StaticText")).get(1).getAttribute("name");
	}
	public static void clickVisibility_Public(){
		log("visibility-public");
		iosdriver.findElements(By.className("Cell")).get(0).click();
	}
	public static void clickVisibility_Private(){
		log("visibility-private");
		iosdriver.findElements(By.className("Cell")).get(1).click();
	}
	public static void clickVisibility_SomeOne(){
		log("visibility-some one");
		iosdriver.findElements(By.className("Cell")).get(2).click();
	}
	//Confirm button
	public static void clickConfirm(){
		clickByName("Confirm");
	}
	//添加可见的好友
	public static void visibilitySomeOneChoose(int chooseCount){
		for (int i = 1; i <=chooseCount; i++) {
			iosdriver.findElement(By.className("Table")).findElements(By.className("Cell")).get(0).click();
			wait(2);
		}
	}
	//删除已经添加的好友
	public static void visibilitySomeOneDelAll(){
		if (class_exist("CollectionView")) {
			List<WebElement> allCells = iosdriver.findElement(By.className("CollectionView")).findElements(By.className("Cell"));
			int size = allCells.size();
			for (int i = 0; i < size; i++) {
				allCells.get(0).click();
				log("del "+i+" some one");
				wait(2);
			}
		}
	}
	//已经选择的个数
	public static int visibilitySomeOneCount(){
		List<WebElement> allCells = null;
		if (class_exist("CollectionView")) {
			allCells = iosdriver.findElement(By.className("CollectionView")).findElements(By.className("Cell"));
		}
		return allCells==null?0:allCells.size();
	}
}
