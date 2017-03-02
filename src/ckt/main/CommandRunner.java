package ckt.main;

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
	public static void main(String[] args) {
		System.setProperty(ESCAPE_PROPERTY, "false"); 
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		XmlSuite suite = new XmlSuite();
		suite.setName("BI.Suite");

		XmlTest test = new XmlTest(suite);
		test.setName("BITest");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("ckt.ios.testcase.me.TC1"));
		test.setXmlClasses(classes);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(false);
		testNG.addListener(new HTMLReporter());
		testNG.addListener(new JUnitXMLReporter());
		testNG.addListener(new TestngListener());
		testNG.setXmlSuites(suites);
		testNG.run();
	}
}
