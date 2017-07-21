package ckt.ios.page;

import io.appium.java_client.MobileElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Element;
import org.openqa.selenium.By;

import com.sun.javafx.scene.traversal.Direction;

import ckt.App.Util.IElement;
import ckt.App.Util.Log;
import ckt.App.Util.VP4;
import ckt.ios.action.MainAction;

public class DiscoverPage extends VP4 {
	//处理观看数和点赞数K的情况
	public static int kToInt(String number){
		if (number.contains("K")) {
			String string = number.replace("K", "");
			return (int)Double.parseDouble(string)*1000;
		}else {
			return Integer.parseInt(number);
		}
	}
	//New message at the bottom
	public static void clickVieNewMessage(){
		if (text_exist("New message at the bottom")) {
			clickByName("New message at the bottom");
			wait(3);
		}
	}
	//click 主播
	public static void clickAnchor(){
		clickByName("About");
		MobileElement element = getElementByClassName("ScrollView");
		swipeToEnd(element);
		wait(3);
	}
	//click 主播-关注
	public static void clickFollowAnchor(){
		if (existBy(By.className("Button").name("Follow"))) {
			log("click Follow button");
			clickByClassNameAndName("Button", "Follow");
		}
		if (existBy(By.className("Button").name("Following"))) {
			log("click Following button");
			clickByClassNameAndName("Button", "Following");
		}
		wait(3);
	}
	//推荐-关注
	public static void clickRecommandFollow(){
		log(" click recommand follow xpath");
		String xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton";
		clickByXpath(xpath);
		waitUntilByNotFind(By.xpath(xpath), 5);
		MainAction.navToDiscover();
		wait(5);
		DiscoverPage.fresh();
	}

	//关注  未关注状态
	public static String getAnchorStatus(){
		String status = "";
		if (existBy(By.className("Button").name("Follow"))) {
			log("status is Follow");
			status = "Follow";
		}
		if (existBy(By.className("Button").name("Following"))) {
			log("status is Following");
			status = "Following";
		}
		return status;
	}
	//click 
	public static void clickRoom(){
		clickByName("chat room");
	}
	public static IElement  getCharRoom(){
		/*List<MobileElement> ems = getElementsByClassName("ScrollView");
		int size = ems.size();
		MobileElement sElement = (MobileElement)ems.get(size-1);*/
		IElement element =getIElementByName("XCUIElementTypeScrollView");
		return element;
	}
	//Discover-New
	public static IElement  getNewCell(){
		IElement findeElement = null;
		List<IElement> elements = getIElementsByClassName("XCUIElementTypeCollectionView");
		IElement maxElement=null;
		for (IElement iElement : elements) {
			System.out.println(iElement.getXpath());
		}
		
		/*int h = iosdriver.manage().window().getSize().height;
		int w = iosdriver.manage().window().getSize().width;
		IElement findeElement = null;
		swipeToUp(iosdriver, 1000, 5);
		//获取xml所有元素
		List<Element> ems = getPageXmlElements();
		//转化为IElement
		List<IElement> tms = toIElements(ems);
		for (IElement iElement : tms) {
			if ("XCUIElementTypeCell".equals(iElement.getClassName())) {
				int x =(int)iElement.getX();
				int y =(int)iElement.getY();
				//查找的Cell可见
				if (0<=x &&x<=h) {
					if (0<=y &&y<=w) {
						String xpath = iElement.getXpath();
						String regEx="XCUIElementTypeCollectionView"; 
						Pattern p = Pattern.compile(regEx);  
						Matcher m = p.matcher(xpath);  
						int i = 0;  
						while(m.find()){  
							i++;  
						}  
						//XCUIElementTypeCollectionView 下第一级的Cell
						//之所以要做次判断，动画界面也属于Cell
						//xpath中只有一个XCUIElementTypeCollectionView
						if (i==1) {
							System.out.println(iElement.getXpath());
							findeElement =iElement;
							break;
						}
					}
				}
			}
		}*/
		return findeElement;
	}
	//获取界面上显示的一个Cell
	public static IElement  getCell(){
		int h = iosdriver.manage().window().getSize().height;
		int w = iosdriver.manage().window().getSize().width;
		IElement findeElement = null;
		swipeToUp(iosdriver, 1000, 5);
		//获取xml所有元素
		List<Element> ems = getPageXmlElements();
		//转化为IElement
		List<IElement> tms = toIElements(ems);
		for (IElement iElement : tms) {
			if ("XCUIElementTypeCell".equals(iElement.getClassName())) {
				int x =(int)iElement.getX();
				int y =(int)iElement.getY();
				//查找的Cell可见
				if (0<=x &&x<=h) {
					if (0<=y &&y<=w) {
						String xpath = iElement.getXpath();
						String regEx="XCUIElementTypeCollectionView"; 
						Pattern p = Pattern.compile(regEx);  
						Matcher m = p.matcher(xpath);  
						int i = 0;  
						while(m.find()){  
							i++;  
						}  
						//XCUIElementTypeCollectionView 下第一级的Cell
						//之所以要做次判断，动画界面也属于Cell
						//xpath中只有一个XCUIElementTypeCollectionView
						if (i==1) {
							System.out.println(iElement.getXpath());
							findeElement =iElement;
							break;
						}
					}
				}
			}
		}
		return findeElement;
	}
	public static IElement  getFirstCell(){
		int h = iosdriver.manage().window().getSize().height;
		int w = iosdriver.manage().window().getSize().width;
		IElement findeElement = null;
		List<Element> ems = getPageXmlElements();
		List<IElement> tms = toIElements(ems);
		for (IElement iElement : tms) {
			if ("XCUIElementTypeCell".equals(iElement.getClassName())) {
				int x =(int)iElement.getX();
				int y =(int)iElement.getY();
				if (0<=x &&x<=h) {
					if (0<=y &&y<=w) {
						System.out.println(iElement.getXpath());
						findeElement =iElement;
						break;
					}
				}
			}
		}
		return findeElement;
	}
	public static String getWatchCount(String cellpath){
		String watchSubXpath2 = "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
		String watchSubXpath3 = "/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
		String xpath2 = cellpath+watchSubXpath2;
		String xpath3 = cellpath+watchSubXpath3;
		IElement watchElement2 = getIElementByXpath(xpath2);
		IElement watchElement3 = getIElementByXpath(xpath3);
		if (watchElement2!=null) {
			log("find element with cellpath");
			String name = watchElement2.getName();
			log(" get watch count ="+name);
			return name;
		}else if (watchElement3!=null) {
			log("find element with cellpath");
			String name = watchElement3.getName();
			log(" get watch count ="+name);
			return name;
		}else {
			log(" get watch count failed");
			return null;
		}
	}
	public static String getHomeWatchCount(String cellpath){
		String watchSubXpath2 = "/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]";
		String watchSubXpath3 = "/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]";
		String xpath2 = cellpath+watchSubXpath2;
		String xpath3 = cellpath+watchSubXpath3;
		IElement watchElemen2 = getIElementByXpath(xpath2);
		IElement watchElemen3 = getIElementByXpath(xpath3);
		if (watchElemen2!=null) {
			log("find element with cellpath");
			String name = watchElemen2.getName();
			log(" get watch count ="+name);
			return name;
		}else if (watchElemen3!=null) {
			log("find element with cellpath");
			String name = watchElemen3.getName();
			log(" get watch count ="+name);
			return name;
		}else {
			log(" get watch count failed");
			return null;
		}
	}
	//discover 页面点赞数
	public static String getZanCount(String cellpath){
		String zanSubXpath2 = "/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText";
		String zanSubXpath3 = "/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText";
		String xpath2 = cellpath+zanSubXpath2;
		String xpath3 = cellpath+zanSubXpath3;
		IElement zanElement2 = getIElementByXpath(xpath2);
		IElement zanElement3 = getIElementByXpath(xpath3);
		if (zanElement2!=null) {
			log("find element with cellpath");
			return zanElement2.getName();
		}else if (zanElement3!=null) {
			return zanElement3.getName();
		}else {
			log(" not find element with cellpath");
			return null;
		}
	}
	public static String getHomeZanCount(String cellpath){
		String zanSubXpath2 = "/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[3]";
		String zanSubXpath3 = "/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[3]";
		String xpath2 = cellpath+zanSubXpath2;
		String xpath3 = cellpath+zanSubXpath3;
		IElement zanElement2 = getIElementByXpath(xpath2);
		IElement zanElement3 = getIElementByXpath(xpath3);
		if (zanElement2!=null) {
			log("find element with cellpath");
			return zanElement2.getName();
		}else if (zanElement3!=null) {
			log("find element with cellpath");
			return zanElement3.getName();
		}else {
			log(" not find element with cellpath");
			return null;
		}
	}
	public static String getHomeCommentCount(String cellpath){
		String zanSubXpath2 = "/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[4]";
		String zanSubXpath3 = "/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[4]";
		String xpath2 = cellpath+zanSubXpath2;
		String xpath3 = cellpath+zanSubXpath3;
		IElement cmtElement2 = getIElementByXpath(xpath2);
		IElement cmtElement3 = getIElementByXpath(xpath3);
		if (cmtElement2!=null) {
			log("find element with cellpath");
			return cmtElement2.getName();
		}else if (cmtElement3!=null) {
			log("find element with cellpath");
			return cmtElement3.getName();
		}else {
			log(" not find element with cellpath");
			return null;
		}
	}
	//观看视频之后的返回动作
	public static void watchBackVideos(){
		wait(2);
		String videosXpathWindow="//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther";
		if (xpath_exist(videosXpathWindow)) {
			log("click video window-videosXpathWindow");
			clickByXpath(videosXpathWindow);
			String backXpath=String.format("%s//XCUIElementTypeOther[1]/XCUIElementTypeButton[1]", videosXpathWindow);
			log("click video window-videos-back-button");
			clickByXpath(backXpath);
		}
		wait(2);
	}
	//观看视频之后的返回动作
	public static void watchBackFollowering(){
		wait(2);
		String videosXpathWindow="//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther";
		if (xpath_exist(videosXpathWindow)) {
			log("click video window-videosXpathWindow");
			clickByXpath(videosXpathWindow);
			String backXpath=String.format("%s//XCUIElementTypeOther[1]/XCUIElementTypeButton[1]", videosXpathWindow);
			log("click video window-videos-back-button");
			clickByXpath(backXpath);
		}
		wait(2);
	}
	//观看视频之后的返回动作
	public static void watchBackFollowers(){
		watchBackFollowering();
	}
	//观看视频之后的返回动作
	public static void watchBackDsicover(){
		wait(2);
		String XpathWindow="//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther";
		if (xpath_exist(XpathWindow)) {
			log("click video window-videosXpathWindow");
			clickByXpath(XpathWindow);
			String backXpath=String.format("%s//XCUIElementTypeOther[1]/XCUIElementTypeButton[1]", XpathWindow);
			log("click video window-videos-back-button");
			clickByXpath(backXpath);
		}
		wait(2);
	}
	
	//观看视频之后的返回动作
	public static void watchBack(){
		/*wait(3);
		//有进度条-未加载完成时候
		if (class_exist("ActivityIndicator")) {
			//点击进度条-弹出返回按钮
			clickByClassName("ActivityIndicator");
		}else {
			//点击视频播放框-弹出返回按钮

			//clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]");			
		}
		//iosdriver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")).click();
		//getElementBySubXpath(getElementByClassName("NavigationBar"), "/XCUIElementTypeButton[1]").click();
		 */		

		/*int h = (int)getIElementByClassName("XCUIElementTypeStatusBar").getHeight();
		clickPoint(1, 20, 20+h, 0);
		wait(2);
		clickPoint(1, 20, 20+h, 0);
		wait(2);*/

		wait(2);
		String discoverPopularPlayWindow ="//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther";
		String meVideosPlayWindow=discoverPopularPlayWindow;
		String discoverNewPlayWindow=discoverPopularPlayWindow;
		String watchPlayWindow=discoverPopularPlayWindow;
		String meFollowingPlayWindow="//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
		String meFollowerPlayWindow=meFollowingPlayWindow;
		String liveStoppedXpath="//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]";

		if (xpath_exist(discoverPopularPlayWindow)) {
			log("click video window-discoverPopularPlayWindow");
			clickByXpath(discoverPopularPlayWindow);
			String backXpath=String.format("%s//XCUIElementTypeOther[1]/XCUIElementTypeButton[1]", discoverPopularPlayWindow);
			clickByXpath(backXpath);
		}
		if (xpath_exist(meFollowingPlayWindow)) {
			log("click video window-meFollowingPlayWindow");
			clickByXpath(discoverPopularPlayWindow);
			String backXpath=String.format("%s//XCUIElementTypeOther[1]/XCUIElementTypeButton[1]", meFollowingPlayWindow);
			clickByXpath(backXpath);
		}

		wait(4);
	}
	public static void clickZan(){
		log("click zan ");
		List<MobileElement> btns = getElementsByClassName("Button");
		int size = btns.size();
		btns.get(size-1).click();
		//clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]");
	}
	//搜索按钮
	public static void clickReLoad_btn(){
		//clickByClassNameAndName("Button", "ReloadButton");
		clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeButton");
		waitUntilByFind(By.name("Search"), 5);
	}
	//who to follow 关闭按钮
	public static void clickKillWhoToFollow(){
		wait(5);
		if (text_exist("Who to follow")) {
			clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton");
		}
	}
	//下拉刷新列表
	public static void fresh(){
		int width = iosdriver.manage().window().getSize().width;  
		int height = iosdriver.manage().window().getSize().height;  
		for (int i = 1; i <= 2; i++) {  
			iosdriver.swipe(width / 2, height*1 / 6, width / 2, height * 5 / 6, 1000);  
			Log.info("swipeToDown-"+i);
			wait(3);  
			waitUntilByFind(By.name("Who to follow"),30);
			//waitUntilByNotFind(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeImage"), 40);
		}  
	}
	public static void clickCancel(){
		clickByName("Cancel");
	}
	//广告
	public static void clickAdvertisement(){
		clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeCollectionView");
	}
	//推荐列表
	public static List<MobileElement> getRecommandList(){
		Element other = getElement("Who to follow").getParent();
		String otherXpath = ElementToIElement(other).getXpath();
		String collectionXpath= otherXpath+"/XCUIElementTypeCollectionView";
		MobileElement recommandElement = getElementByXpath(collectionXpath);
		//MobileElement recommandElement = getElementByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView");
		List<MobileElement> cells = recommandElement.findElements(By.className("Cell"));
		log("find recommand list size = "+cells.size());
		return cells;
	}
	//推荐人的name
	public static String getRecommandName(MobileElement cell){
		String name = cell.findElement(By.className("StaticText")).getText();
		log(""+name);
		return name;
	}
	//输入框-删除文字按钮
	public static void deleteInput(){
		log("click delete ");
		getElementByClassName("SearchField").findElement(By.className("Button")).click();
	}
	//滑动推荐列表
	public static void swipRecommandList(){
		MobileElement element=getElementByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView");
		for (int i = 0; i < 2; i++) {
			swipeTo(element, "LEFT");
			wait(5);
		}
	}

}
