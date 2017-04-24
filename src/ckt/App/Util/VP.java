package ckt.App.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.dom4j.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ckt.ios.page.MainPage;

public class VP extends AppiumBase {
	private static final long WAIT_STRING=10;
	public void waitForElementToLoad(int timeOut, final By By) {        
		(new WebDriverWait(iosdriver, timeOut)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By);
				return element.isDisplayed();
			}
		});
	}
	public static void waitUntilFind(int watiTime, By by){
		Log.info(String.format("start to wait element %s",by));
		boolean isExist = false;
		for (int i = 0; i <watiTime; i++) {
			if (isExist=true) {
				break;
			}else {
				try {
					iosdriver.findElement(by);
					isExist=true;
				} catch (NoSuchElementException e) {
					// TODO: handle exception
					isExist=false;
				}
			}
		}
		if (isExist=true) {
			Log.info(String.format("wait element success in %s seconds",watiTime));
		}else {
			Log.info(String.format("wait element failure in %s seconds",watiTime));
		}
	}
	public static void waitUntilFind(By by,int seconds){
		WebDriverWait wait = new WebDriverWait(iosdriver, seconds);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
	public static void waitUntilGone(int watiTime, By by){
		Log.info(String.format("start to wait element Gone %s",by));
		boolean isGone = false;
		for (int i = 0; i <watiTime; i++) {
			if (isGone=true) {
				break;
			}else {
				try {
					iosdriver.findElement(by);
					isGone=false;
				} catch (NoSuchElementException e) {
					// TODO: handle exception
					isGone=true;
				}
			}
		}
		if (isGone=true) {
			Log.info(String.format("wait element Gone in %s seconds",watiTime));
		}else {
			Log.info(String.format("wait element not Gone in %s seconds",watiTime));
		}
	}
	public boolean isExistElementName(String name){
		Log.info(String.format("start to search element %s",name));
		ArrayList<String> elementListString =VP3.searchElementByName(name);
		if (elementListString.size()>=1) {
			Log.info(String.format("element with name=%s success",name));
			return true;
		}else {
			Log.info(String.format("element with name=%s failure",name));
			return false;
		}
	}
	//通过Name 点击
	public static void clickByName(String name){
		//VP3.clickElementByName(name);
		log("click-name:"+name);
		iosdriver.findElement(By.name(name)).click();
	}
	//获取页面xml元素
	public static String  getTreeForXml(){
		return iosdriver.getPageSource();
	}
	//根据calssName name获取对象
	public static MobileElement getElement(String className,String name){
		return ((MobileElement)iosdriver.findElement(By.className(className).name(name)));
	}

	//根据calssName获取对象
	public static MobileElement getElementByClassName(String className){
		Log.info(String.format("Search Element By className=%s ",className));
		return ((MobileElement)iosdriver.findElement(By.className(className)));
	}
	//根据X-path获取对象
	public static MobileElement getElementByXpath(String xpath){
		return ((MobileElement)iosdriver.findElement(By.xpath(xpath)));
	}
	//根据tag-name获取对象
	public static MobileElement getElementByTag(String name){
		return ((MobileElement)iosdriver.findElement(By.tagName(name)));
	}
	//根据name获取对象
	public static MobileElement getElementByName(final String name){
		return ((MobileElement)iosdriver.findElement(By.name(name)));
	}
	//点击 X-path
	public static void  clickByXpath(final String xpathExpression){
		Log.info(String.format("click By.xpath:%s ",xpathExpression));
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return (MobileElement) arg0.findElement(By.xpath(xpathExpression));
			}
		});
		element.click();
	}
	//click calssName
	public static void clickByClassName(final String className){
		Log.info(String.format("click Element By className=%s ",className));
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return (MobileElement) arg0.findElement(By.className(className));
			}
		});
		element.click();
	}
	public static boolean text_exist(String text){
		boolean exist = false;
		if (iosdriver.getPageSource().contains(text)) {
			exist=true;
		}
		return exist ;
	}
	public static boolean xpath_exist(String xpath){
		boolean isexist=false;
		List<Element> ems = VP4.getPageXmlElements();
		List<IElement> tms = VP4.toIElements(ems);
		for (IElement iElement : tms) {
			if (xpath.equals(iElement.getXpath())) {
				isexist=true;
			}
		}
		return isexist;
	}
	public static boolean class_exist(String className){
		boolean exist = false;
		try {
			if (iosdriver.findElement(By.className(className)).isDisplayed()) {
				exist=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return exist ;
	}
	public static void wait(int time){
		try {
			Thread.currentThread();
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author young
	 * @param by
	 * @return
	 */
	private boolean isElementPresent(By by) {
		try {
			iosdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			iosdriver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * 获得随机字符
	 */
	public String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	public static void resetApp(){
		log("start resetApp ");
		MobileElement btnEmt;
		boolean tag = false;
		if (class_exist("TabBar")) {
			btnEmt= (MobileElement) iosdriver.findElement(By.className("TabBar")).findElements(By.className("Button")).get(0);
			btnEmt.click();
			btnEmt.click();
			log("click TabBar-Button[0]");
			tag=true;
		}else {
			if (text_exist("登录")) {
				log("find 登录");
				iosdriver.findElement(By.className("Button")).click();
			}
			if (class_exist("NavigationBar")) {
				btnEmt= (MobileElement) iosdriver.findElement(By.className("NavigationBar")).findElements(By.className("Button")).get(0);
				btnEmt.click();
				log("click Back Button");
			} 
			if (class_exist("SegmentedControl")) {
				btnEmt= (MobileElement) iosdriver.findElement(By.className("TypeScrollView"));
				btnEmt.click();
				log("click TypeScrollView");
			}
			if (class_exist("ScrollView")) {
				String xpath = VP4.getXpathByClassName("ScrollView").getXpath();
				String subnavpath = xpath+"/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar";
				String subbtnpath = xpath+"/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar/XCUIElementTypeButton[1]";
				if (xpath_exist(subnavpath)) {
					getElementByXpath(subnavpath).click();
				}
				if (xpath_exist(subbtnpath)) {
					getElementByXpath(subbtnpath).click();
				}
			}
		}
		if (!tag) {
			resetApp();
		}else {
			log("rest App finished");
		}

	}
	//during（这里是填写毫秒数，这里的 毫秒数越小 滑动的速度越快~ 一般设定在500~1000，如果你想快速滑动 那就可以设置的更加小）
	//num（是只滑动的次数，本人在做相册 翻页测试什么的 滑动  或者滑动到列表底部。就直接输入次数就行了）
	/** 
	 * 上滑 
	 *  
	 * @param iosdriver 
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToUp(IOSDriver<?> iosdriver,int during, int num) {  
		int width = iosdriver.manage().window().getSize().width;  
		int height = iosdriver.manage().window().getSize().height;  
		for (int i = 0; i < num; i++) {  
			iosdriver.swipe(width / 2, height * 4/ 6, width / 2, height *3/ 6, during);  
			Log.info("swipeToUp");
			wait(1);  
		}  
	}  
	/** 
	 * 下拉 
	 *  
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToDown(IOSDriver<?> driver,int during, int num) {  
		int width = driver.manage().window().getSize().width;  
		int height = driver.manage().window().getSize().height;  
		for (int i = 0; i < num; i++) {  
			driver.swipe(width / 2, height*3 / 6, width / 2, height * 4 / 6, during);  
			Log.info("swipeToDown");
			wait(1);  
		}  
	}  

	/** 
	 * 向左滑动 
	 *   
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToLeft(IOSDriver<?> driver,int during, int num) {  
		int width = driver.manage().window().getSize().width;  
		int height = driver.manage().window().getSize().height;  
		for (int i = 0; i < num; i++) {  
			driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);  
			Log.info("swipeToLeft");
			wait(3);  
		}  
	}  

	/** 
	 * 向右滑动 
	 *  
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToRight(IOSDriver<?> driver,int during, int num) {  
		int width = driver.manage().window().getSize().width;  
		int height = driver.manage().window().getSize().height;  
		for (int i = 0; i < num; i++) {  
			driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);  
			Log.info("swipeToRight");
			wait(3);  
		}  
	}  
	public static void swipeToBegin(IOSDriver<?> iosdriver,int num) {
		for (int i = 0; i < num; i++) {
			List<Element> sms1 = VP4.getPageXmlElements();
			VP.swipeToDown(iosdriver, 2000, 1);
			List<Element> sms2 = VP4.getPageXmlElements();

			if (sms1.size()==sms2.size()) {
				Log.info("swipe To begin");
				break;
			}
		}
	}
	public static void swipeToEnd(IOSDriver<?> iosdriver,int num) {
		for (int i = 0; i < num; i++) {
			List<Element> sms1 = VP4.getPageXmlElements();
			VP.swipeToUp(iosdriver, 2000, 1);
			List<Element> sms2 = VP4.getPageXmlElements();
			if (sms1.size()==sms2.size()) {
				Log.info("swipe To ends");
				break;
			}
		}
	}
	public static void setText(MobileElement element,String value){
		//iosdriver.hideKeyboard();
		element.clear();
		element.setValue(value);
		log(String.format("setValue-[%s]", value));
		wait(5);
		MainPage.clickReturn();
	}
	public static void setText(MobileElement element,String value,boolean isReturn){
		//iosdriver.hideKeyboard();
		element.clear();
		element.setValue(value);
		log(String.format("setValue-[%s]", value));
		wait(5);
		if (isReturn) {
			MainPage.clickReturn();
		}
	}
	public static boolean isTextExist(String text){
		boolean isTextFind=false;
		try {
			iosdriver.findElement(By.name(text));
			isTextFind=true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			isTextFind=false;
		}
		return isTextFind;
	}
	/*长按某一个对象*/
	public static void longPress(MobileElement element){
		new TouchActions(iosdriver).longPress(element);
	}
	public static  boolean scrollToFind(String text){
		boolean isFind=false;
		boolean isEnd = false;
		swipeToBegin(iosdriver, 50);
		List<Element> sms_before;
		List<Element> sms_after ;
		while(isFind!=true||isEnd!=true){
			sms_before = VP4.getPageXmlElements();
			if (isTextExist(text)) {
				isFind=true;
				isEnd=true;
				Log.info("swipeToUp to  find element with text="+text+ ", result  success");
			}else {
				swipeToUp(iosdriver, 2000, 1);
				sms_after = VP4.getPageXmlElements();
				if (sms_before.size()==sms_after.size()) {
					isEnd=true;
					Log.info("swipeToUp to  find element with text="+text+ ", result  failed");
				}
			}
		}
		return isFind;

	}
	private static <T> T checkNotNull(T value, String message) {
		if (value == null) {
			throw new NullPointerException(message);
		}
		return value;
	}
}
