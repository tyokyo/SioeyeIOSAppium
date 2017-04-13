package ckt.main;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import org.testng.TestNG;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.JUnitXMLReporter;

import ckt.App.Listeners.TestngListener;
import ckt.App.View.ClassScanner;
import ckt.ios.Test.TestTC2;
import ckt.ios.testcase.me.edit.LocationCase;

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
		String root = "D:\\soft\\workspace\\workspace4\\SioeyeIOSAppium\\bin\\ckt\\ios\\testcase";
		ClassScanner scanner = new ClassScanner(new File(root));  
		scanner.setLoader(ScranRunner.class.getClassLoader());
		scanner.setFilter(new FileFilter() {
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				if (f.getName().endsWith("java")) {
					System.out.println(f.getName());
				}
				return true;
			}
		});  
		ArrayList<Class<?>> classList = new ArrayList<Class<?>>();
		classList.add(LocationCase.class);
		int count = classList.size();
		Class[]  classes = new Class[count];
		for (int i = 0; i < count; i++) {
			classes[i]=classList.get(i);
		}
		testNG.setTestClasses(classes);
		//testNG.run();
	}
}
