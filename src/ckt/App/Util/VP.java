package ckt.App.Util;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VP extends AppiumBase {
	private static final long WAIT_STRING=120;
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
		VP3.clickElementByPoint(name);
		//iosdriver.findElement(By.name(name)).click();
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
	public static MobileElement getElementByXpathExpression(String xpathExpression){
		return ((MobileElement)iosdriver.findElement(By.xpath(xpathExpression)));
	}
	//根据tag-name获取对象
	public static MobileElement getElementByTag(String name){
		return ((MobileElement)iosdriver.findElement(By.tagName(name)));
	}
	//根据name获取对象
	public static MobileElement getElementByName(final String name){
		return ((MobileElement)iosdriver.findElement(By.name(name)));
	}
	//根据tag-name获取对象
	public static void clickByByTag(final String name){
		Log.info(String.format("click Element By name=%s ",name));
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return (MobileElement) arg0.findElement(By.tagName(name));
			}
		});
		element.click();
	}
	//点击 X-path
	public static void  clickByXpath(final String xpathExpression){
		Log.info(String.format("click  By.xpath:%s ",xpathExpression));
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
		iosdriver.resetApp();
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
			iosdriver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);  
			Log.info("swipeToUp");
			wait(3);  
		}  
	}  

	/** 
	 * 下拉 
	 *  
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToDown(IOSDriver<WebElement> driver,int during, int num) {  
		int width = driver.manage().window().getSize().width;  
		int height = driver.manage().window().getSize().height;  
		System.out.println(width);  
		System.out.println(height);  
		for (int i = 0; i < num; i++) {  
			driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);  
			Log.info("swipeToDown");
			wait(3);  
		}  
	}  

	/** 
	 * 向左滑动 
	 *   
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToLeft(IOSDriver<WebElement> driver,int during, int num) {  
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
	public static void swipeToRight(IOSDriver<WebElement> driver,int during, int num) {  
		int width = driver.manage().window().getSize().width;  
		int height = driver.manage().window().getSize().height;  
		for (int i = 0; i < num; i++) {  
			driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);  
			Log.info("swipeToRight");
			wait(3);  
		}  
	}  

}
