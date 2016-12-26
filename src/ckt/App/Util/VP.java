package ckt.App.Util;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;

public class VP extends AppiumBase {
	//通过Name 点击
	public static void clickByName(String name){
		iosdriver.findElement(By.name(name)).click();
	}
	//获取页面xml元素
	public static String  getTreeForXml(){
		return iosdriver.getPageSource();
	}
	//根据calssName获取对象
	public static MobileElement getElementByClassName(String className){
		return ((MobileElement)iosdriver.findElement(By.className(className)));
	}
	//根据X-path获取对象
	public static MobileElement getElementByXpathExpression(String xpathExpression){
		return ((MobileElement)iosdriver.findElement(By.xpath(xpathExpression)));
	}
	//点击 X-path
	public static void  clickByXpath(String xpathExpression){
		((MobileElement)iosdriver.findElement(By.xpath(xpathExpression))).click();
	}
	public static boolean text_exist(String text){
		boolean exist = false;
		try {
			exist = iosdriver.findElement(By.name(text))==null?false:true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
		}
		return exist ;
	}
}
