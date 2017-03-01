package ckt.App.Util;

import io.appium.java_client.TouchAction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Element;
/*使用正则表达式查找元素*/
public class VP3 extends VP{
	public static ArrayList<String> searchElementByName(String name){
		Log.info(String.format("start to search By.name=%s",name));
		ArrayList<String> sList = new ArrayList<String>();
		Pattern p=Pattern.compile(String.format("<(.*?) name=\"%s\"(.*?) value=\"%s\"(.*?)>",name,name));
		//Pattern p=Pattern.compile(" (.*?)=(.*?) "); 
		//Pattern p=Pattern.compile("<(.*?) ");
		String s = iosdriver.getPageSource();
		//System.out.println(s);
		Matcher m=p.matcher(s); 
		while(m.find()) { 
			String findString=m.group(0).toString();
			sList.add(findString);
		}
		Log.info(String.format("result is=%s", sList.toString()));
		if (sList.size()>=1) {
			Log.info(" find element");
		}else {
			Log.info(" not find element");
		}
		return sList;
	}
	/*x,y,width,height*/
	private static String getCoordinate(String line,String attribute){
		String findString=null;
		Pattern p=Pattern.compile(attribute+"=\"(.*?)\""); 
		//Pattern p=Pattern.compile("^<(.*?) "); 
		Matcher m=p.matcher(line); 
		while(m.find()) { 
			findString=m.group(1).trim();
		}
		Log.info(String.format("%s=%s", attribute,findString));
		return findString;
	}
	public static void clickElementByName(String name){
		List<Element> mElements = VP4.getPageXmlElements();
		List<IElement> iElements= VP4.toIElements(mElements);
		List<IElement> findElements = new ArrayList<IElement>();
		for (IElement element : iElements) {
			if (element.getName().equals(name)) {
				findElements.add(element);
			}
		}
		Log.info(String.format("find name %s count=%s",name,findElements.size()+""));
		if (findElements.size()>=1) {
			IElement find = findElements.get(0);
			double x =find.getX();
			double y =find.getY();
			double width = find.getWidth();
			double height =find.getHeight();
			int x_coordinate =(int) (x+width/2);
			int y_coordinate =(int) (y+height/2);
			//do click operation
			TouchAction gesture = new TouchAction(iosdriver).press(x_coordinate, y_coordinate) ;
			 gesture.perform();
			 Log.info(String.format("click Element By name=%s  With x=%s,y=%s,width=%s,height=%s",name, x,y,width,height));
		
		}else {
			Log.info("there is no element named="+name);
		}
		/*ArrayList<String> sList  = searchElementByName(name);
		//default is click the first element name=name
		if (sList.size()==0) {
			Log.info("there is no element named="+name);
		}else {
			String elementString = sList.get(0);
			double x =Double.parseDouble(getCoordinate(elementString, "x"));
			double y =Double.parseDouble(getCoordinate(elementString, "y"));
			double width = Double.parseDouble(getCoordinate(elementString, "width"));
			double height = Double.parseDouble(getCoordinate(elementString, "height"));
			int x_coordinate =(int) (x+width/2);
			int y_coordinate =(int) (y+height/2);
			//do click operation
			TouchAction gesture = new TouchAction(iosdriver).press(x_coordinate, y_coordinate) ;
			 gesture.perform();
			 Log.info(String.format("click Element By name=%s  With x=%s,y=%s,width=%s,height=%s",name, x,y,width,height));
		}*/
	}
}
