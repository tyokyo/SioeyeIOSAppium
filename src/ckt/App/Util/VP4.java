package ckt.App.Util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

import ckt.ios.page.MainPage;
/*使用dom4j解析页面XML数据*/
public class VP4 extends VP3
{
	public static Element getApplicationXmlElement(){
		String xmlSource=iosdriver.getPageSource();
		Document document;
		Element UIAApplication = null;
		try {
			InputStream is =new ByteArrayInputStream(xmlSource.getBytes("UTF-8"));
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(is);
			// 获取根元素 - AppiumAUT
			Element root = document.getRootElement();
			//System.out.println("Root: " + root.getName());
			//获取子元素 - UIAApplication
			UIAApplication = (Element) root.elements().get(0);
			//System.out.println("AppiumAUT->UIAApplication: " + UIAApplication.getName()+"-"+UIAApplication.attributeValue("name"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UIAApplication;
	}
	public static String getApplicationName(){
		Element UIAApplication=getApplicationXmlElement();
		return UIAApplication==null?"":UIAApplication.attributeValue("name");
	}
	@SuppressWarnings("unchecked")
	private static void readElement(Element element,List<Element> allElements){
		List<Element>elmsElements = element.elements();
		for (Element element2 : elmsElements) {
			allElements.add(element2);
			//System.out.println("Node-" + element2.getName()+"-"+element2.attributeValue("name"));
			readElement(element2,allElements);
		}
	}
	public static List<Element> getPageXmlElements(){
		ArrayList<Element> allElements = new ArrayList<Element>();
		Element applicationElement = getApplicationXmlElement();
		readElement(applicationElement, allElements);
		return allElements;
	}
	public static IElement  ElementToIElement(Element element){
		IElement iElement = new IElement();
		iElement.setClassName(element.getName()+"");
		iElement.setXpath(getXpath(element));
		iElement.setName(""+element.attributeValue("name"));
		iElement.setValue(""+element.attributeValue("value"));
		iElement.setLabel(""+element.attributeValue("label"));
		iElement.setX(Double.parseDouble(element.attributeValue("x")));
		iElement.setY(Double.parseDouble(element.attributeValue("y")));
		iElement.setWidth(Double.parseDouble(element.attributeValue("width")));
		iElement.setHeight(Double.parseDouble(element.attributeValue("height")));
		iElement.setVisible(""+element.attributeValue("visible"));
		iElement.setEnabled(""+element.attributeValue("enabled"));
		return iElement;
	}
	public static MobileElement  ElementToMobileElement(Element element){
		MobileElement mobileElement = null;
		IElement iElement = ElementToIElement(element);
		mobileElement=getElementByXpath(iElement.getXpath());
		return mobileElement;
	}
	public static MobileElement  IElementToMobileElement(IElement iElement){
		return getElementByXpath(iElement.getXpath());
	}
	public static Element  IElementToElement(IElement iElement){
		Element sElement = null;
		List<Element> mElements = getPageXmlElements();
		for (Element element : mElements) {
			if (iElement.equals(ElementToIElement(element))) {
				sElement=element;
				break;
			}
		}
		return sElement;
	}
	public static String getElementRect(Element element){
		String rectStr = "";
		String x = element.attributeValue("x");
		String y = element.attributeValue("y");
		String width = element.attributeValue("width");
		String height = element.attributeValue("height");
		rectStr = String.format("{x=%s, width=%s, y=%s, height=%s}", x,width,y,height);
		return rectStr;
	}
	public static Element  MobileElementToElement(MobileElement mobileElement){
		Element xmlElement = null;
		MIElement iElement = new MIElement(mobileElement);
		String type = iElement.getType();
		String tosearchRect = iElement.getRect().toString();
		String name = iElement.getName()+"";
		List<Element> ems = VP4.getPageXmlElements();
		for (Element element : ems) {
			String rect = getElementRect(element);
			String ttype = element.attributeValue("type");
			String nname= element.attributeValue("name")+"";
			//System.out.println(rect+"-"+ttype+"-"+nname);
			if (ttype.equals(type)&&name.equals(nname)) {
				if (rect.equals(tosearchRect)) {
					log("find xml element");
					xmlElement=element;
					break;
				}
			}
		}	
		return xmlElement;
	}
	public static IElement  MobileElementToIElement(MobileElement mobileElement){
		Element element = MobileElementToElement(mobileElement);
		return ElementToIElement(element);
	}

	public static List<IElement> toIElements(List<Element> elements){
		List<IElement> iElements = new ArrayList<IElement>();
		for (Element element : elements) {
			IElement iElement = new IElement();
			iElement.setClassName(element.getName());
			iElement.setXpath(getXpath(element));
			iElement.setName(element.attributeValue("name"));
			iElement.setValue(element.attributeValue("value"));
			iElement.setLabel(element.attributeValue("label"));
			iElement.setX(Double.parseDouble(element.attributeValue("x")));
			iElement.setY(Double.parseDouble(element.attributeValue("y")));
			iElement.setWidth(Double.parseDouble(element.attributeValue("width")));
			iElement.setHeight(Double.parseDouble(element.attributeValue("height")));
			iElement.setVisible(element.attributeValue("visible"));
			iElement.setEnabled(element.attributeValue("enabled"));
			iElements.add(iElement);
		}
		return iElements;
	}
	private static List<MobileElement> toMobileElements(List<IElement> elements){
		List<MobileElement> mels = new ArrayList<MobileElement>();
		for (IElement iElement : elements) {
			mels.add(getElementByXpath(iElement.getXpath()));
		}
		return mels;
	}
	public static String getXpath(Element element){
		return element.getUniquePath().replace("AppiumAUT", "");
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
	//根据calssName name获取对象
	public static Element getElement(String name){
		log(String.format("getElement with  name=%s",name));
		Element xmlelement=null;
		List<Element> mElements = VP4.getPageXmlElements();
		for (Element element : mElements) {
			String ename = element.attributeValue("name");
			if (name.equals(ename)) {
				xmlelement=element;
				break;
			}
		}
		return xmlelement;
	}
	public static IElement getIElementByXpath(String xpath){
		IElement returnElement=null;
		List<Element> ems = getPageXmlElements();
		List<IElement> tms = toIElements(ems);
		for (IElement iElement : tms) {
			if (xpath.equals(iElement.getXpath())) {
				returnElement= iElement;
			}
		}
		return returnElement;
	}
	public static IElement getIElementByName(String name){
		IElement returnElement=null;
		List<Element> ems = getPageXmlElements();
		List<IElement> tms = toIElements(ems);
		for (IElement iElement : tms) {
			if (name.equals(iElement.getName())) {
				returnElement= iElement;
			}
		}
		return returnElement;
	}

	//根据name获取对象
	public static MobileElement getElementByName(String name){
		return ((MobileElement)iosdriver.findElement(By.name(name)));
	}
	//根据className获取对象
	public static IElement getIElementByClassName(String className){
		IElement returnElement=null;
		List<Element> ems = getPageXmlElements();
		List<IElement> tms = toIElements(ems);
		for (IElement iElement : tms) {
			String classname = iElement.getClassName();
			System.out.println(classname);
			if (className.equals(classname)) {
				returnElement= iElement;
				break;
			}
		}
		if (returnElement==null) {
			log("can not find IElement by className="+className);
		}else {
			log("find IElement by className="+className);
		}
		return returnElement;
	}
	//根据className获取对象
	public static List<IElement> getIElementsByClassName(String className){
		List<IElement> returnElement=new ArrayList<IElement>();
		List<Element> ems = getPageXmlElements();
		List<IElement> tms = toIElements(ems);
		for (IElement iElement : tms) {
			String classname = iElement.getClassName();
			System.out.println(classname);
			if (className.equals(classname)) {
				returnElement.add(iElement);
			}
		}
		if (returnElement.size()==0) {
			log("can not find IElement by className="+className);
		}else {
			log("find IElement by className="+className);
		}
		return returnElement;
	}
	public static void waitUntilTextExist(String text,int seconds){
		long time_start = System.currentTimeMillis();
		boolean isTerminate=false;
		while(!isTerminate){
			if (isTextExist(text)) {
				isTerminate=true;
				Log.info(String.format("find text %s",text));
			}else {
				long time_end = System.currentTimeMillis();
				if ((time_end-time_start)>=seconds*1000) {
					isTerminate=true;
					Log.info(String.format("can not find text %s in %d seconds",text,seconds));
				}
			}
		}
	}
	public static void waitTextGone(String text,int seconds){
		long time_start = System.currentTimeMillis();
		boolean isTerminate=false;
		while(!isTerminate){
			if (isTextExist(text)) {
				long time_end = System.currentTimeMillis();
				if ((time_end-time_start)>=seconds*1000) {
					isTerminate=true;
					Log.info(String.format("can not gone text %s in %d seconds",text,seconds));
				}
			}else {
				isTerminate=true;
				Log.info(String.format("text %s gone",text));
			}
		}
	}
	/*public static boolean isTextExist(String text){
		boolean isExist= false;
		List<Element> mElements = getPageXmlElements();
		List<IElement> iElements= toIElements(mElements);
		List<IElement> findElements = new ArrayList<IElement>();
		for (IElement element : iElements) {
			if (element.getName().equals(text)) {
				findElements.add(element);
			}
		}
		Log.info(String.format("find text %s count=%s",text,findElements.size()+""));
		if (findElements.size()>=1) {
			isExist=true;
		}else {
			isExist=false;
		}
		return isExist;
	}*/
	/** 
	 *  
	 * @param MobileElement   滑动的元素
 	 * @param direction 滑动方向
	 */  
	public static void swipeTo(MobileElement element,String direction) {  
		int wd_width = iosdriver.manage().window().getSize().width;  
		int wd_height = iosdriver.manage().window().getSize().height;  
		Point point = element.getCenter();
		int startX=point.x;
		int startY=point.y;
		int endX=0;
		int endY=0;
		switch (direction) {
		case "DOWN":
			endX=point.x;
			endY=point.y+wd_height/8;
			iosdriver.swipe(startX,startY,endX,endY,1000);
			Log.info(String.format("swipToDown startX=%d startY=%d endX=%d endY=%d",startX,startY,endX,endY));
			break;
		case "RIGHT":
			endX=wd_width-20;
			startX=startX/2;
			endY=point.y;
			iosdriver.swipe(startX,startY,endX,endY,10);
			Log.info(String.format("swipToRight startX=%d startY=%d endX=%d endY=%d",startX,startY,endX,endY));
			break;
		case "UP":
			endX=point.x;
			endY=point.y-wd_height/8;
			iosdriver.swipe(startX,startY,endX,endY,1000);
			Log.info(String.format("swipToUp startX=%d startY=%d endX=%d endY=%d",startX,startY,endX,endY));
			break;
		case "LEFT":
			startX=wd_width-20;
			endX=startX/4;;
			endY=point.y;
			iosdriver.swipe(startX,startY,endX,endY,10);
			Log.info(String.format("swipToLeft startX=%d startY=%d endX=%d endY=%d",startX,startY,endX,endY));
			break;
		default:
			break;
		}
	}  
	/** 
	 * 滑动到最底部
	 * @param MobileElement   滑动的元素
	 */  
	public static void swipeToEnd(MobileElement element) {  
		int height_wd = iosdriver.manage().window().getSize().height;  
		int width_wd = iosdriver.manage().window().getSize().width;  
		
		//Point point = element.getCenter();
		int startX=width_wd/2;
		int startY=element.getRect().y+10;
		int endX=0;
		int endY=0;
		endX=startX;
		endY=height_wd-5;
		iosdriver.swipe(startX,startY,endX,endY,1000);
		Log.info(String.format("swipToDown startX=%d startY=%d endX=%d endY=%d",startX,startY,endX,endY));
	}  
	//swipeToDown(IOSDriver<?>, int, int)
	//swipeToLeft(IOSDriver<?>, int, int)
	//swipeToRight(IOSDriver<?>, int, int)
	public static void main(String[] args) throws Exception
	{
		try {
			startAppium();

			String appName=getApplicationName();
			System.out.println(appName);
			System.out.println(iosdriver.getPageSource());
			MainPage.clickMe_btn();
			List<Element> ems = getPageXmlElements();
			for (Element element : ems) {
				System.out.println(element.getUniquePath());
			}

			List<IElement> tms = toIElements(ems);
			for (IElement iElement : tms) {
				System.out.println(iElement.toString());
			}
			wait(3);
			//scrollToFind("2857");
			MainPage.clickMe_btn();
			//Draw.takeScreenShotWithDraw("qiuxia.jian-qq007");
			wait(10);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			stopAppium();
		}
	}

}