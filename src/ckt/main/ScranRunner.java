package ckt.main;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import org.testng.TestNG;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.JUnitXMLReporter;

import ckt.App.Listeners.TestngListener;
import ckt.App.View.ClassScanner;

public class ScranRunner {
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		System.setProperty(ESCAPE_PROPERTY, "false"); 
		// TODO Auto-generated method stub
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(false);
		testNG.addListener(new HTMLReporter());
		testNG.addListener(new JUnitXMLReporter());
		testNG.addListener(new TestngListener());
		String root = "D:\\soft\\workspace\\workspace4\\SioeyeIOSAppium\\bin\\ckt\\ios\\testcase\\me";
		ClassScanner scanner = new ClassScanner(new File(root));  
		scanner.setLoader(ScranRunner.class.getClassLoader());
		scanner.setFilter(new FileFilter() {
			
			@Override
			public boolean accept(File arg0) {
				// TODO Auto-generated method stub
				return true;
			}
		});  
		ArrayList<Class<?>> classList = new ArrayList<Class<?>>();
		classList.add(ckt.ios.testcase.Test.TestTC2.class);
		int count = classList.size();
		Class[]  classes = new Class[count];
		for (int i = 0; i < count; i++) {
			classes[i]=classList.get(i);
		}
		testNG.setTestClasses(classes);
		testNG.run();
	}
}
