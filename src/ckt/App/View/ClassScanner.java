package ckt.App.View;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.testng.log4testng.Logger;

public class ClassScanner {  
	private File root;  
	private FileFilter filter;  
	private ClassLoader loader;  

	private static final Logger log = Logger.getLogger(ClassScanner.class);  
	private static final String CLASS_EXT = ".class";  

	/** 
	 * @param root 
	 */  
	public ClassScanner(File root) {  
		super();  
		this.root = root;  
	}  

	public void setFilter(FileFilter filter) {  
		this.filter = filter;  
	}  

	public void setLoader(ClassLoader loader) {  
		this.loader = loader;  
	}  

	public Class[] getClasses() {  
		List<Class> list = new ArrayList<Class>();  
		loadClasses(list, root);  
		return list.toArray(new Class[list.size()]);  
	}  

	/** 
	 * @param list 
	 * @param root2 
	 */  
	private void loadClasses(List<Class> list, File dir) {  
		if (dir == null || !dir.isDirectory()) {  
			return;  
		}  
		File[] files = dir.listFiles();  
		for (File file : files) {  
			log.debug("scan "+file.getAbsolutePath());  
			if (file.isDirectory()) {  
				loadClasses(list, file);  
			} else if (filter == null || filter.accept(file)) {  
				if (file.getName().endsWith(CLASS_EXT)) {  
					int trim = root.toString().length();  
					String name = file.toString().substring(trim + 1);  
					name = name.substring(0, name.length() - CLASS_EXT.length());  
					name = name.replace(File.separatorChar, '.');  
					try {  
						Class clazz = loader == null ? Class.forName(name) : loader.loadClass(name);  
						log.info("loaded "+file.getAbsolutePath());  
						list.add(clazz);  
					} catch (Exception e) {  
						log.warn("error loading class " + name, e);  
					}  
				}  
			}  
		}  
	}  
}  
