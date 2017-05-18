package ckt.inspector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*IElement cellEem  = VideoPage.chooseFirstLiveStream();
		MobileElement mElement =IElementToMobileElement(cellEem);
		swipeTo(mElement, "LEFT");*/


		String str="For my /XCUIElementTypeCollectionView/ money, /XCUIElementTypeCollectionView/ the important thing ";
		String regEx="XCUIElementTypeCollectionView"; 
		//e表示需要匹配的数据，使用Pattern建立匹配模式  
		Pattern p = Pattern.compile(regEx);  
		//使用Matcher进行各种查找替换操作  
		Matcher m = p.matcher(str);  
		int i = 0;  
		while(m.find()){  
			i++;  
		}  

		System.out.println(i);  
		
		String s = "Follower 20 Video 30";
		System.out.println(s.split("Video")[0]);
		System.out.println(s.split("Video")[1]);
	}

}
