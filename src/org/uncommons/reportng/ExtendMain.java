package org.uncommons.reportng;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class ExtendMain {
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	public static void main(String[] args) {
		System.setProperty(ESCAPE_PROPERTY, "false"); 
		// TODO Auto-generated method stub
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(false);
		testNG.addListener(new HTMLReporter());
		testNG.addListener(new JUnitXMLReporter());
		//testNG.addListener(new TestNgListener());
		List<String> suits = new ArrayList<String>();
		suits.add("xml/demo.xml");
		suits.add("xml/demo2.xml");
		testNG.setTestSuites(suits);
		testNG.run();
	}

}
