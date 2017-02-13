package ckt.App.Util;

import java.util.Random;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VP extends AppiumBase {
	private static final long WAIT_STRING=120;
	//通过Name 点击
	public static void clickByName(String name){
		log("click name-"+name);
		iosdriver.findElement(By.name(name)).click();
	}
	//获取页面xml元素
	public static String  getTreeForXml(){
		return iosdriver.getPageSource();
	}
	//根据calssName name获取对象
	public static MobileElement getElement(final String className,final String name){
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.className(className).name(name));
			}
        });
		return element;
	}
	
	//根据calssName获取对象
	public static MobileElement getElementByClassName(final String className){
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.className(className));
			}
        });
		return element;
	}
	//根据X-path获取对象
	public static MobileElement getElementByXpathExpression(final String xpathExpression){
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.xpath(xpathExpression));
			}
        });
		return element;
	}
	//根据tag-name获取对象
	public static MobileElement getElementByTag(final String name){
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.tagName(name));
			}
        });
		return element;
	}
	//根据tag-name获取对象
	public static void clickByByTag(final String name){
		log("click tagName-"+name);
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.tagName(name));
			}
        });
		 element.click();
	}
	//点击 X-path
	public static void  clickByXpath(final String xpathExpression){
		log("click xpathExpression-"+xpathExpression);
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.xpath(xpathExpression));
			}
        });
		 element.click();
	}
	//click calssName
	public static void clickByClassName(final String className){
		log("click className-"+className);
		WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
		MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
			@Override
			public MobileElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.className(className));
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
}
