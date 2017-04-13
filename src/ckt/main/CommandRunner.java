package ckt.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.JUnitXMLReporter;

import ckt.App.Listeners.TestngListener;

public class CommandRunner {
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	public static void allFiles(String root,List<File> files){
		File f = new File(root);
		File[] fs = f.listFiles();
		for (File file : fs) {
			if (file.isDirectory()) {
				String path = file.getAbsolutePath();
				allFiles(path, files);
			}else {
				if (file.getName().endsWith("java")) {
					files.add(file);
				}
			}
		}
	}
	public static List<String> getXmlClassList(){
		List<String> xmlName=new ArrayList<String>();
		List<File> files = new ArrayList<File>();
		String root = "src\\ckt\\ios\\testcase1";
		allFiles(root, files);
		for (File file : files) {
			String xmlClassName = file.getAbsolutePath().split("src")[1].replaceAll("\\\\", ".").replaceFirst(".", "").replaceAll(".java", "");
			xmlName.add(xmlClassName);
			System.out.println(xmlClassName);
		}
		return xmlName;
	}
	public static void main(String[] args) {
		System.setProperty(ESCAPE_PROPERTY, "false"); 
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		XmlSuite suite = new XmlSuite();
		suite.setName("BI.Suite");

		XmlTest test = new XmlTest(suite);
		test.setName("BITest");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		//classes.add(new XmlClass("ckt.ios.testcase.me.edit.LocationCase"));
		
		List<String> xmlStrings = getXmlClassList();
		for (String xmlClass: xmlStrings) {
			classes.add(new XmlClass(xmlClass));
		}
		
		test.setXmlClasses(classes);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(false);
		testNG.addListener(new HTMLReporter());
		testNG.addListener(new JUnitXMLReporter());
		testNG.addListener(new TestngListener());
		testNG.setXmlSuites(suites);
		//testNG.run();
		
	}
}
