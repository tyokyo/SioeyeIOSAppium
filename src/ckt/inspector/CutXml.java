package ckt.inspector;

public class CutXml {
	public static String repXml(String xmlStr){
		xmlStr = xmlStr.replaceAll("AppiumAUT", "hierarchy");
		if (xmlStr.contains("/UIA")) {
			xmlStr = xmlStr.replaceAll("/UIA.[A-za-z]+", "/node");
			xmlStr = xmlStr.replaceAll("UIA", "node type=\"UIA");
			xmlStr = xmlStr.replaceAll(" name=", "\" name=");
		} else {
			xmlStr = xmlStr.replaceAll("XCUIElement.* type", "node type");
			xmlStr = xmlStr.replaceAll("/XCUIElementType.[A-za-z]+", "/node");
		}
		System.out.println(xmlStr);
		return xmlStr;
	}
}
