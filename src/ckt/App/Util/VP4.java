package ckt.App.Util;

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
	private static String getXpath(Element element){
		return element.getUniquePath().replace("AppiumAUT", "");
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
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			stopAppium();
		}
	}

}