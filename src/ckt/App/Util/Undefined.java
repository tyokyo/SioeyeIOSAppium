package ckt.App.Util;

import io.appium.java_client.MobileElement;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Undefined extends VP {
	private static final long WAIT_STRING=120;
	//scroll方向滑动-Right, Left, Up, Down
		public static void scrollDirection(String direction){
			HashMap<String, String> scrollObject = new HashMap<String, String>();  
			//scrollObject.put("direction", "Up");
			scrollObject.put("direction", direction);
			iosdriver.execute("mobile: scroll", scrollObject);
		}
		public void scroll(Map<String, Double> scrollMap){
			JavascriptExecutor js= (JavascriptExecutor) iosdriver;
			js.executeScript("mobile: scroll", scrollMap);
			}
		//scroll对象滑动
		public static void scroll(){
			JavascriptExecutor js = (JavascriptExecutor) iosdriver;  
			MobileElement  element = getElementByClassName("");
			HashMap<String, String> scrollObject = new HashMap<String, String>();  
			scrollObject.put("element", ((RemoteWebElement) element).getId());  
			js.executeScript("mobile: scroll", scrollObject);  
		}
		public static void swipe(double startX,double startY,double endX,double endY,double duration){
			JavascriptExecutor js = (JavascriptExecutor) iosdriver;  
			MobileElement  element = getElementByClassName("");
			HashMap<String, Double> swipeObject = new HashMap<String, Double>();  
			swipeObject.put("startX", startX);  
			swipeObject.put("startY", startY);  
			swipeObject.put("endX", endX);  
			swipeObject.put("endY", endY);  
			swipeObject.put("duration", duration);  
			swipeObject.put("element", Double.valueOf(((RemoteWebElement) element).getId()));  
			js.executeScript("mobile: swipe", swipeObject);  
		}
		/*X,Y可为coordinator，也可以是percent，大于1 为coordinator， 小于1 为percent，比如0.5 代表50%
		duration单位为秒， Android 可以设置0.1-60，iOS设置0.5-60
		需要滑动特定的对象时需要指定的element，只是在名目上滑动式就可以不指定element
		第二种： flick 区别swipe是没有duration*/
		public static void flick(double startX,double startY,double endX,double endY){
			JavascriptExecutor js = (JavascriptExecutor) iosdriver;  
			MobileElement  element = getElementByClassName("");
			HashMap<String, Double> swipeObject = new HashMap<String, Double>();  
			swipeObject.put("startX", startX);  
			swipeObject.put("startY", startY);  
			swipeObject.put("endX", endX);  
			swipeObject.put("endY", endY);  
			swipeObject.put("element", Double.valueOf(((RemoteWebElement) element).getId()));  
			js.executeScript("mobile:flick", swipeObject);  
		}
		//通过Name 点击
		public static void clickByName(final String name){
			Log.logInfo(String.format("click Element By name=%s ",name));
			WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
			MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
				@Override
				public MobileElement apply(WebDriver arg0) {
					// TODO Auto-generated method stub
					return (MobileElement) arg0.findElement(By.name(name));
				}
			});
			element.click();
		}
		//获取页面xml元素
		public static String  getTreeForXml(){
			return iosdriver.getPageSource();
		}
		//根据calssName name获取对象
		public static MobileElement getElement(final String className,final String name){
			Log.logInfo(String.format("Search Element By className=%s name=%s",className,name));
			WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
			MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
				@Override
				public MobileElement apply(WebDriver arg0) {
					// TODO Auto-generated method stub
					return (MobileElement) arg0.findElement(By.className(className).name(name));
				}
			});
			return element;
		}

		//根据calssName获取对象
		public static MobileElement getElementByClassName(final String className){
			Log.logInfo(String.format("Search Element By className=%s ",className));
			WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
			MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
				@Override
				public MobileElement apply(WebDriver arg0) {
					// TODO Auto-generated method stub
					return (MobileElement) arg0.findElement(By.className(className));
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
					return (MobileElement) arg0.findElement(By.xpath(xpathExpression));
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
					return (MobileElement) arg0.findElement(By.tagName(name));
				}
			});
			return element;
		}
		//根据name获取对象
		public static MobileElement getElementByName(final String name){
			WebDriverWait wait = new WebDriverWait(iosdriver, WAIT_STRING);
			MobileElement element= wait.until(new  ExpectedCondition<MobileElement>() {
				@Override
				public MobileElement apply(WebDriver arg0) {
					// TODO Auto-generated method stub
					return (MobileElement) arg0.findElement(By.name(name));
				}
			});
			return element;
		}
		//根据tag-name获取对象
		public static void clickByByTag(final String name){
			Log.logInfo(String.format("click Element By name=%s ",name));
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
			Log.logInfo(String.format("click Element By xpath=%s ",xpathExpression));
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
			Log.logInfo(String.format("click Element By className=%s ",className));
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
}
