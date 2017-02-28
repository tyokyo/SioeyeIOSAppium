package ckt.App.Util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.touch.TouchActions;
/*使用dom4j解析页面XML数据*/
public class VP4 extends VP3
{
	private static Element getApplicationXmlElement(){
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
			mels.add(getElementByXpathExpression(iElement.getXpath()));
		}
		return mels;
	}
	private static String getXpath(Element element){
		return element.getUniquePath().replace("AppiumAUT", "");
	}
	//根据name获取对象
	public static MobileElement getElementByName(String name){
		List<Element> mElements = getPageXmlElements();
		List<MobileElement> ems = toMobileElements(toIElements(mElements));
		for (MobileElement mobileElement : ems) {
			System.out.println(mobileElement.getAttribute("name"));
		}
		return ((MobileElement)iosdriver.findElement(By.name(name)));
	}
	public static boolean isTextExist(String text){
		boolean isExist= false;
		List<Element> mElements = getPageXmlElements();
		List<IElement> iElements= toIElements(mElements);
		List<IElement> findElements = new ArrayList<IElement>();
		for (IElement element : iElements) {
			if (element.getName().equals(text)&&element.getValue().equals(text)) {
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
	}
	public static void main(String[] args) throws Exception
	{
		try {
			startAppium();
			By.className("AppiumAUT");
			By.name("CKT");
			/*String appName=getApplicationName();
			System.out.println(appName);*/
			By by = By.xpath("//AppiumAUT/AppiumAUT/AppiumAUT");
			System.out.println(by);
			List<Element> ems = getPageXmlElements();
			for (Element element : ems) {
				System.out.println(element.getUniquePath());
			}

			List<IElement> tms = toIElements(ems);
			for (IElement iElement : tms) {
				System.out.println(iElement.toString());
			}
			wait(3);
			//scrollToFind("qiuxia.jian-qq007");
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			stopAppium();
		}
	}

}