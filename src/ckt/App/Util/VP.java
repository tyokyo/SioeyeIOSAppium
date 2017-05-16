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

import ckt.ios.action.MainAction;
import ckt.ios.page.MainPage;

public class VP extends AppiumBase {
	private static final long WAIT_STRING=15;
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
		for (int i = 0; i <watiTime; i++) {
			try {
				iosdriver.findElement(by);
				Log.info(String.format("wait element success in %s seconds",watiTime));
				break;
			} catch (NoSuchElementException e) {
				// TODO: handle exception
				log("try to find ");
				wait(1);
			}
		}
	}
	public static void waitUntilFind(By by,int seconds){
		log(String.format("waitUntilFind %d",seconds ));
		try {
			WebDriverWait wait = new WebDriverWait(iosdriver, seconds);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			log("waitUntilFind = success");
		} catch (Exception e) {
			// TODO: handle exception
			log("waitUntilFind = Not find ");
		}
	}
	public static void waitUntilByFind(By by,int seconds){
		log(String.format("waitUntilFind in  %d seconds",seconds ));
		try {
			WebDriverWait wait = new WebDriverWait(iosdriver, seconds);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			log("waitUntilFind = success");
		} catch (Exception e) {
			// TODO: handle exception
			log("waitUntilFind = Not find ");
		}
	}
	public static void waitUntilByNotFind(By by,int seconds){
		log(String.format("waitUntilByNotFind in %d secods",seconds));
		long start = System.currentTimeMillis();
		boolean timeout=false;
		while(!timeout){
			try {
				WebDriverWait wait = new WebDriverWait(iosdriver, 5);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
				log("sorry, by is find in ,please wait ");
			} catch (Exception e) {
				// TODO: handle exception
				log("Congratulations,by has gone ,now exit ");
				timeout=true;
			}
			long end = System.currentTimeMillis();
			if ((end-start)>=seconds*1000) {
				log(String.format("sorry ,Time out, wait until by gone in %d seconds",seconds));
				timeout=true;
			}
			if (timeout==true) {
				log("wait-"+(System.currentTimeMillis()-start)/1000+" seconds");
			}
		}
	}
	public static void waitUntilGone(int watiTime, By by){
		Log.info(String.format("start to wait element Gone %s",by));
		for (int i = 1; i <=watiTime; i++) {
			try {
				iosdriver.findElement(by);
				Log.info(String.format("find element in %d seconds", i*2));
			} catch (NoSuchElementException e) {
				// TODO: handle exception
				Log.info("waitUntilGone  - not find by");
				break;
			}
			wait(2);
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
	public static void clickXmlElement(Element element){
		String xpath =VP4.getXpath(element);
		clickByXpath(xpath);
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
	public static Element getElement(String className,String name){
		log(String.format("getElement with className=%s name=%s",className,name));
		Element xmlelement=null;
		List<Element> mElements = VP4.getPageXmlElements();
		for (Element element : mElements) {
			String clsName = element.getName();
			String ename = element.attributeValue("name");
			if (className.equals(clsName)&&name.equals(ename)) {
				xmlelement=element;
				break;
			}
		}
		return xmlelement;
	}

	//根据calssName获取对象
	public static MobileElement getElementByClassName(String className){
		Log.info(String.format("Search Element By className=%s ",className));
		return ((MobileElement)iosdriver.findElement(By.className(className)));
	}
	public static MobileElement getElementByClassNameAndName(String className,String name){
		Log.info(String.format("Search Element By className=%s name=%s ",className,name));
		return ((MobileElement)iosdriver.findElement(By.className(className).name(name)));
	}
	//根据X-path获取对象
	public static MobileElement getElementByXpath(String xpath){
		log("getElementByXpath-"+xpath);
		return ((MobileElement)iosdriver.findElement(By.xpath(xpath)));
	}
	//根据X-path获取对象
	public static MobileElement getElementBySubXpath(MobileElement parent,String subXpath){
		Element element =VP4.MobileElementToElement(parent);
		String xpath = VP4.ElementToIElement(element).getXpath()+subXpath;
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
	//根据className 获取Element列表
	public static List<MobileElement> getElementsByClassName(final String className){
		log(String.format("getElements by className =%s",className));
		List<MobileElement> classEms = (List<MobileElement>) iosdriver.findElements(By.className(className));
		log(String.format("find %d elements", classEms.size()));
		return classEms;
	}
	//根据className 获取Element列表
		public static List<MobileElement> getElementsByClassName(String parentClassName,String childClassName){
			log(String.format("getElements by  parent className =%s  child className=%s",parentClassName,childClassName));
			MobileElement pElement = getElementByClassName(parentClassName);
			List<MobileElement> classEms = pElement.findElements(By.className(childClassName));
			log(String.format("find %d elements", classEms.size()));
			return classEms;
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
	//click by className and name
	public static void clickByClassNameAndName(final String className,final String name){
		Log.info(String.format("click Element By className=%s name=%s",className,name));
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return (MobileElement) arg0.findElement(By.className(className).name(name));
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
	public static void clickByClassNameIndex(final String className,int index){
		log(String.format("click className=%s with index=%d", className,index));
		iosdriver.findElements(By.className(className)).get(index).click();;
	}
	public static boolean text_contains(String text){
		boolean isFind = false;
		List<Element> ems = VP4.getPageXmlElements();
		for (Element element : ems) {
			IElement iElement = VP4.ElementToIElement(element);
			if (iElement.getName().contains(text)) {
				isFind=true;
				break;
			}
		}
		log(String.format("search  result for string contains %s is %s", text,isFind));
		return isFind;
	}
	public static void clickByTextContains(String text){
		log("clickByTextContains - "+text);
		List<Element> ems = VP4.getPageXmlElements();
		for (Element element : ems) {
			IElement iElement = VP4.ElementToIElement(element);
			//System.out.println(iElement.getName());
			if (iElement.getName().contains(text)) {
				iElement.click();
				break;
			}
		}
	}
	public static boolean existBy(By by){
		boolean byExist = false;
		try {
			iosdriver.findElement(by);
			byExist = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return byExist;
	}
	public static boolean text_exist(String text){
		boolean exist = false;
		if (iosdriver.getPageSource().contains(text)) {
			exist=true;
			log(String.format("%s contains", text));
		}else {
			log(String.format("%s not contains", text));
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
		if (isexist) {
			log("xpath has finded:"+xpath);
		}else {
			log("not find xpath:"+xpath);
		}
		return isexist;
	}
	public static boolean class_exist(String className){
		boolean exist = false;
		try {
			boolean isDisplay = iosdriver.findElement(By.className(className)).isDisplayed();
			if (isDisplay) {
				log("exist class ="+className);
				exist=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log(String.format("className-%s not exits", className));
		}
		return exist ;
	}
	public static boolean classExist(String className,boolean isDisplay){
		boolean exist = false;
		try {
			if (iosdriver.findElement(By.className(className)).isDisplayed()==isDisplay) {
				exist=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return exist ;
	}
	public static boolean classExist(String className){
		boolean exist = false;
		try {
			iosdriver.findElement(By.className(className));
			exist=true;
			log("find className-"+className);
		} catch (Exception e) {
			// TODO: handle exception
			log("not find className-"+className);
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
	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	public static void resetApp(int count){
		log("start resetApp -"+count);
		MobileElement btnEmt;
		boolean tag = false;

		clickByTextContains("OK");
		if (text_exist("Close")) {
			clickByName("Close");
		}
		if (text_exist("Cancel")) {
			clickByName("Cancel");
		}
		if (class_exist("TabBar")) {
			btnEmt= (MobileElement) iosdriver.findElement(By.className("TabBar")).findElements(By.className("Button")).get(0);
			btnEmt.click();
			btnEmt.click();
			log("click TabBar-Button[0]");
			tag=true;
		}else {
			if (text_exist("Log in")) {
				log("find Log in");
				iosdriver.findElement(By.className("Button")).click();
			}
			if (class_exist("NavigationBar")) {
				btnEmt= (MobileElement) iosdriver.findElement(By.className("NavigationBar")).findElements(By.className("Button")).get(0);
				btnEmt.click();
				log("click Back Button");
			} 
			if (text_exist("anchor")) {
				log("click video");
				clickByXpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]");
				log("click video back button");
				getElementBySubXpath(getElementByClassName("NavigationBar"), "/XCUIElementTypeButton[1]").click();
				wait(7);
			}
			if (text_exist("Log in")) {
				//第一个button
				clickByClassName("Button");
			}
			if (text_exist("Return to Sioeye")) {
				clickByName("Return to Sioeye");
			}
			/*if (class_exist("SegmentedControl")) {
				btnEmt= (MobileElement) iosdriver.findElement(By.className("TypeScrollView"));
				btnEmt.click();
				log("click TypeScrollView");
			}*/
		}
		if (count>=10) {
			iosdriver.resetApp();
		}
		count=count+1;
		if (!tag) {
			resetApp(count);
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
		for (int i = 1; i <= num; i++) {  
			iosdriver.swipe(width / 2, height * 4/ 6, width / 2, height *3/ 6, during);  
			//iosdriver.swipe(width / 2, height * 3/ 4, width / 2, height *1/ 4, during);  
			Log.info("swipeToUp-"+i);
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
		for (int i = 1; i <= num; i++) {  
			driver.swipe(width / 2, height*3 / 6, width / 2, height * 4 / 6, during);  
			Log.info("swipeToDown-"+i);
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
		for (int i = 1; i <= num; i++) {  
			driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);  
			Log.info("swipeToLeft-"+i);
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
		for (int i = 1; i <= num; i++) {  
			driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);  
			Log.info("swipeToRight-"+i);
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
		MainAction.clickKeyBoardReturn();
	}
	public static void setText(String className,String value){
		//iosdriver.hideKeyboard();
		MobileElement element = getElementByClassName(className);
		element.clear();
		element.setValue(value);
		log(String.format("setValue-[%s]", value));
		wait(5);
		MainAction.clickKeyBoardReturn();
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
		swipeToBegin(iosdriver, 50);
		List<Element> sms_before;
		List<Element> sms_after ;
		boolean exit=false;
		while(!exit){
			sms_before = VP4.getPageXmlElements();
			if (isTextExist(text)) {
				isFind=true;
				exit=true;
				Log.info("swipeToUp to  find element with text="+text+ ", result  success");
				break;
			}else {
				swipeToUp(iosdriver, 2000, 1);
				wait(3);
				sms_after = VP4.getPageXmlElements();
				if (sms_before.size()==sms_after.size()) {
					Log.info("swipeToUp to  find element with text="+text+ ", result  failed");
					exit=true;
					break;
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
