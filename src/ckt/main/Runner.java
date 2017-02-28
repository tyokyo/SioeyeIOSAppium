package ckt.main;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.JUnitXMLReporter;
import ckt.App.Util.TestngListener;

public class Runner {
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	public static void main(String[] args) {
		System.setProperty(ESCAPE_PROPERTY, "false"); 
		// TODO Auto-generated method stub
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(false);
		testNG.addListener(new HTMLReporter());
		testNG.addListener(new JUnitXMLReporter());
		testNG.addListener(new TestngListener());
		List<String> suits = new ArrayList<String>();
		suits.add("xml/demo.xml");
		//suits.add("xml/demo2.xml");
		testNG.setTestSuites(suits);
		testNG.run();
	}

}

