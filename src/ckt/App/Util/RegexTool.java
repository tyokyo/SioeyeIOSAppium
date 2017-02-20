package ckt.App.Util;

import io.appium.java_client.TouchAction;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTool extends VP{
	public static ArrayList<String> searchByName(String name){
		ArrayList<String> sList = new ArrayList<String>();
		Pattern p=Pattern.compile(String.format("<(.*?) name=\"%s\"(.*?) value=\"%s\"(.*?)>",name,name));
		//Pattern p=Pattern.compile(" (.*?)=(.*?) "); 
		//Pattern p=Pattern.compile("<(.*?) ");
		String s = iosdriver.getPageSource();
		//System.out.println(s);
		Matcher m=p.matcher(s); 
		while(m.find()) { 
			sList.add(m.group(0).toString());
			Log.logInfo(String.format("Search By.name=%s Result is=%s",name, m.group(0).toString()));
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
		Log.logInfo(String.format("%s=%s", attribute,findString));
		return findString;
	}
	public static void clickElementByPoint(String name){
		ArrayList<String> sList  = searchByName(name);
		//default is click the first element name=name
		if (sList.size()==0) {
			Log.logInfo("there is no element named="+name);
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
			 Log.logInfo(String.format("click Element By name=%s  With x=%s,y=%s,width=%s,height=%s",name, x,y,width,height));
		}
	}
}
