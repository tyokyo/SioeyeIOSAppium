package ckt.main;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.JUnitXMLReporter;

import ckt.App.Listeners.TestngListener;

public class XmlRunner {
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
		suits.add("xml/account.xml");
		//suits.add("xml/me.xml");
		testNG.setTestSuites(suits);
		testNG.run();
	}
}

