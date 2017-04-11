package ckt.main;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.JUnitXMLReporter;

import ckt.App.Listeners.TestngListener;
import ckt.App.View.ClassScanner;
import ckt.ios.Test.TestTC2;
import ckt.ios.testcase.me.edit.LocationCase;

public class RunAll {
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
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		System.setProperty(ESCAPE_PROPERTY, "false"); 
		// TODO Auto-generated method stub
		ArrayList<Class<?>> classList = new ArrayList<Class<?>>();
		
		String root = "src\\ckt\\ios\\testcase";
		List<File> files = new ArrayList<File>();
		allFiles(root, files);
		for (File file : files) {
			classList.add(file.getClass());
			System.out.println(file.getAbsolutePath());
		}
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(false);
		testNG.addListener(new HTMLReporter());
		testNG.addListener(new JUnitXMLReporter());
		testNG.addListener(new TestngListener());
		
		int count = classList.size();
		Class[]  classes = new Class[count];
		for (int i = 0; i < count; i++) {
			classes[i]=classList.get(i);
		}
		testNG.setTestClasses(classes);
		//testNG.run();
	}
}
