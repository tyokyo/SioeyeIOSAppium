package ckt.ios.action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.appium.java_client.MobileElement;
import ckt.App.Util.IElement;
import ckt.App.Util.VP4;

public class DiscoverAction extends VP4 {
	public static void waitForConnect(){
		waitUntilTextExist("what is your opinion", 60);
	}
	//主页-观看第一个视频
	public static void watchVideo(){
		log("watch video in home page");
		List<MobileElement> cells = getElementsByClassName("CollectionView", "Cell");
		boolean firstCellTag = false;
		int size = cells.size();
		if (size>=2) {
			MobileElement firestCell = cells.get(0);
			MobileElement secondCell = cells.get(1);
			IElement iElement =MobileElementToIElement(firestCell);
			String xpath = iElement.getXpath();
			String regEx="XCUIElementTypeCollectionView"; 
			Pattern p = Pattern.compile(regEx);  
			Matcher m = p.matcher(xpath);  
			int t = 0;  
			while(m.find()){  
				t++;  
			}  
			//XCUIElementTypeCollectionView 下第一级的Cell
			if (t==2) {
				firstCellTag=true;
				System.out.println(iElement.getXpath());
			}
			if (firstCellTag) {
				log("click the second cell");
				secondCell.click();
			}else {
				log("click the first cell");
				firestCell.click();
			}
		}else {
			MobileElement firestCell = cells.get(0);
			firestCell.click();
		}
		
	}
	public static void clickCommentInput_btn(){
		clickByClassName("TextField");
	}
	public static void searchFollower(String value){
		MobileElement element = getElementByClassName("SearchField");
		element.clear();
		element.setValue(value);
		clickByClassNameAndName("Button", "User");
		log(String.format("setValue-[%s]", value));
		wait(5);
		MainAction.clickKeyBoardSearch();
	}
	public static void searchVideo(String value){
		MobileElement element = getElementByClassName("SearchField");
		element.clear();
		element.setValue(value);
		clickByClassNameAndName("Button", "Video");
		log(String.format("setValue-[%s]", value));
		wait(5);
		MainAction.clickKeyBoardSearch();
	}
	//等待搜索完成
	public static void waitSearchFinished(){
		waitTextGone("Search", 10);
		wait(3);
		waitTextGone("Loading", 60);
	}
	//推荐列表左滑动
	public static void swipeLeftRecommandList(){
		MobileElement element=getElementByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView");
		swipeTo(element, "LEFT");
		wait(5);
	}
}
