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
		clickByName("直播");
	}
	//点击-关注
	public static void clickFollowingBtn(){
		clickByName("关注");
	}
	//点击-粉丝
	public static void clickFollowsBtn(){
		clickByName("粉丝");
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
	public static void clickNickNameBtn(){
		clickByName("昵称");
	}
	public static void clickSexBtn(){
		clickByName("性别");
	}
	public static void clickLocationBtn(){
		clickByName("地区");
	}
	public static void clickInterestBtn(){
		clickByName("爱好");
	}
	public static void clickSignatureBtn(){
		clickByName("个性签名");
	}
	public static void clickSaveBtn(){
		clickByName("保存");
		wait(3);
		waitTextGone("保存", 20);
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
		clickByName("男");
	}
	public static void clickSexFeMale(){
		clickByName("女");
	}
	public static void clickSexSecret(){
		clickByName("保密");
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
		iosdriver.findElement(By.name("拍照")).click();
	}
	//编辑头像-选择拍照
	public static void avatarByGallery(){
		By.className("Button");
		iosdriver.findElement(By.name("从相册中选择")).click();
	}
	//编辑头像-选择拍照-使用照片
	public static void usingPicture(){
		By.className("Button");
		iosdriver.findElement(By.name("使用照片")).click();
		waitTextGone("使用照片", 10);
	}
	//拍照
	public static void clickCapture(){
		clickByName("拍照");
	}
	//编辑头像-图库-选取
	public static void avatarGalleryDone(){
		@SuppressWarnings("unchecked")
		List<MobileElement> cells = (List<MobileElement>) iosdriver.findElements(By.className("Cell"));
		MobileElement cell = cells.get(cells.size()-1);		
		cell.click();
		wait(2);
		if (text_exist("选取")) {
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
		clickByName("取消");
	}
}
