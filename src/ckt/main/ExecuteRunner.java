package ckt.main;

import org.testng.TestNG;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.JUnitXMLReporter;

import ckt.App.Listeners.TestngListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExecuteRunner{
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	public static void main(String[] args) {
		//强制显示图片
		System.setProperty(ESCAPE_PROPERTY, "false");
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(false);
		testNG.addListener(new HTMLReporter());
		testNG.addListener(new JUnitXMLReporter());
		//自定义监听器-失败截图
		testNG.addListener(new TestngListener());
		List<String> suits = new ArrayList<String>();
		//添加测试套件-读取XML文件夹下所有的.xml文件（testng 配置文件）
		File xmlDir=new File("xml");
		File[] xmlFiles=xmlDir.listFiles();
		for (File file: xmlFiles) {
			if (file.getName().toLowerCase().endsWith(".xml")){
				suits.add(file.getAbsolutePath());
			}
		}
		/*suits.add("xml/demo.xml");
		suits.add("xml/demo2.xml");*/
		testNG.setTestSuites(suits);
		testNG.run();
	}
}
