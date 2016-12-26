package ckt.App.Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public class Property {
	public static Hashtable<String, String> getProperties(String  filePath) throws FileNotFoundException, IOException {
		Properties pps = new Properties();
		pps.load(new FileInputStream("properties/config.properties"));
		Enumeration<?>  enum1 = (Enumeration<?>) pps.propertyNames();
		Hashtable<String, String> prop = new Hashtable<String, String>();
		while(enum1.hasMoreElements()) {
			String strKey = (String) enum1.nextElement();
			String strValue = pps.getProperty(strKey);
			prop.put(strKey, strValue);
			System.out.println(strKey + "=" + strValue);
		}
		return prop;
	}
	public static String getValueByKey(String filePath, String key) {
		Properties pps = new Properties();
		try {
			InputStream in = new BufferedInputStream (new FileInputStream(filePath));  
			pps.load(in);
			String value = pps.getProperty(key);
			System.out.println(key + " = " + value);
			return value;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String args[]) throws FileNotFoundException, IOException {
	}
}
