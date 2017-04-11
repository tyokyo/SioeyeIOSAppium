package ckt.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {
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
	public static void findPackage(Object testObject) {
		System.out.println("Object has the package " + testObject.getClass().getPackage().getName());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String root = "src\\ckt\\ios\\testcase";
		List<File> files = new ArrayList<File>();
		allFiles(root, files);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
			System.out.println("Object has the package " +file.getClass().getPackage().getName());
		}
	}

}
