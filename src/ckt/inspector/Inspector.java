package ckt.inspector;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import ckt.App.Util.IElement;
import ckt.App.Util.VP3;
/*使用dom4j解析页面XML数据*/
public class Inspector extends VP3
{
	public static DefaultMutableTreeNode rootTree ;
	private static String getXpath(Element element){
		return element.getUniquePath().replace("AppiumAUT", "");
	}
	public static void fillTree(){

	}
	public static List<IElement> toIElements(List<Element> elements){
		System.out.println("toIElements-"+elements.size());
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
	public static Element getApplicationXmlElement(){
		//String xmlSource=iosdriver.getPageSource();
		String xmlSource=readFile("inspector/app-inspector.xml");
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
	public static String readFile(String filePath){
		String content="";
		try {
			String encoding="UTF-8";
			File file=new File(filePath);
			if(file.isFile() && file.exists()){ //判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),encoding);//考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt = bufferedReader.readLine()) != null){
					content=content+lineTxt+"\n";
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return content;
	}
	public static boolean writeTxtFile(String content,File  fileName)throws Exception{  
		RandomAccessFile mm=null;  
		boolean flag=false;  
		FileOutputStream o=null;  
		try {  
			o = new FileOutputStream(fileName);  
			o.write(content.getBytes("UTF-8"));  
			o.close();  
			flag=true;  
		} catch (Exception e) {  
			// TODO: handle exception  
			e.printStackTrace();  
		}finally{  
			if(mm!=null){  
				mm.close();  
			}  
		}  
		return flag;  
	}  
	private static void readElement(DefaultMutableTreeNode  node,Element element,List<Element> allElements){
		@SuppressWarnings("unchecked")
		List<Element>elmsElements = element.elements();
		for (Element element2 : elmsElements) {
			DefaultMutableTreeNode nodechild = new DefaultMutableTreeNode(repXcui(element2.attributeValue("type")));
			node.add(nodechild);
			allElements.add(element2);

			//System.out.println("Node-" + element2.getName()+"-"+element2.attributeValue("name"));
			readElement(nodechild,element2,allElements);
		}
	}
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
	private static String repXcui(String tag){
		return tag.replace("XCUIElementType", "");
	}
	public static DefaultMutableTreeNode getTree(){
		ArrayList<Element> allElements = new ArrayList<Element>();
		Element rootElement = getApplicationXmlElement();
		rootTree =new DefaultMutableTreeNode(repXcui(rootElement.getName()));//创建Jtree数据模型的根节点
		readElement(rootTree,rootElement, allElements);
		UiViewer.tms = Inspector.toIElements(allElements);
		return rootTree;
	}
	public static void main(String args[]){
		List<Element>  ems = Inspector.getPageXmlElements();
		List<IElement> tms = Inspector.toIElements(ems);
		for (IElement iElement : tms) {
			System.out.println(iElement.getXpath());
		}
	}

}