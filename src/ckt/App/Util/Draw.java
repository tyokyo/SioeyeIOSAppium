package ckt.App.Util;

import java.io.File;
import java.io.FileOutputStream;  
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;  
import java.awt.Font;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.image.BufferedImage;  

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.uncommons.reportng.Reporters;

import ckt.main.TestNgXml;

import com.sun.image.codec.jpeg.JPEGCodec;  
import com.sun.image.codec.jpeg.JPEGImageEncoder;  

public class Draw extends VP4{
	private static String getPrefix() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		if (stackTrace == null || stackTrace.length < 4) return "BOGUS";
		String className = stackTrace[3].getClassName();
		String methodName = stackTrace[3].getMethodName();
		return String.format("%s.%s", className, methodName);
	}
	public static void takeScreenShot(Color color){
		int width = AppiumBase.iosdriver.manage().window().getSize().width;  
		int height = AppiumBase.iosdriver.manage().window().getSize().height;  
		String folderString = getPrefix();
		folderString=folderString.replaceAll("['.']", "/");
		//File folder = new File("test-output/screenshot/"+folderString);
		File folder = new File(TestNgXml.screenshotFolder+"/"+folderString);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String mDateTime = formatter.format(new Date());
		String screenName = mDateTime+".png";
		String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
		File screenShot = AppiumBase.iosdriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Log.info(folderString+"/"+screenName);
		try {
			takeDrawRect(screenShotPath, color);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporters.logInfo("<br><img src=../screenshot/" + folderString+"/"+screenName + "  onclick='window.open(\"../screenshot/"+folderString+"/"+screenName+")'"+"  height='"+height+"'  width='"+width+"'/>");
	}
	public static String takeScreenShot(){
		int width = AppiumBase.iosdriver.manage().window().getSize().width;  
		int height = AppiumBase.iosdriver.manage().window().getSize().height;  
		String folderString = getPrefix();
		folderString=folderString.replaceAll("['.']", "/");
		//File folder = new File("test-output/screenshot/"+folderString);
		File folder = new File(TestNgXml.screenshotFolder+"/"+folderString);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String mDateTime = formatter.format(new Date());
		String screenName = mDateTime+".png";
		String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
		File screenShot = AppiumBase.iosdriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Log.info(screenShotPath);
		try {
			takeDrawRect(screenShotPath, Color.BLACK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporters.logInfo("<br><img src=../screenshot/" + folderString+"/"+screenName + "  onclick='window.open(\"../screenshot/"+folderString+"/"+screenName+")'"+"  height='"+height+"'  width='"+width+"'/>");
		return screenShotPath;
	}
	public static String  takeInspectorScreenShot(){
		int width = AppiumBase.iosdriver.manage().window().getSize().width;  
		int height = AppiumBase.iosdriver.manage().window().getSize().height;  
		File folder = new File("inspector");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String screenName = String.format("app-inspector%s.png",System.currentTimeMillis());;
		String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
		File screenShot = AppiumBase.iosdriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Log.info(screenShotPath);
		try {
			takeDrawRect(screenShotPath, Color.BLACK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenName;
	}
	public static void takeScreenShotWithDraw(String drawText){
		int width = AppiumBase.iosdriver.manage().window().getSize().width;  
		int height = AppiumBase.iosdriver.manage().window().getSize().height;  
		String folderString = getPrefix();
		folderString=folderString.replaceAll("['.']", "/");
		//File folder = new File("test-output/screenshot/"+folderString);
		File folder = new File(TestNgXml.screenshotFolder+"/"+folderString);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String mDateTime = formatter.format(new Date());
		String screenName = mDateTime+".png";
		String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
		File screenShot = AppiumBase.iosdriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Log.info(screenShotPath);
		try {
			takeDrawRectAndText(screenShotPath, Color.BLACK,drawText);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporters.logInfo("<br><img src=../screenshot/" + folderString+"/"+screenName + "  onclick='window.open(\"../screenshot/"+folderString+"/"+screenName+")'"+"  height='"+height+"'  width='"+width+"'/>");
	}
	public static void takeDrawRect(String filePath,Color color) throws IOException{
		File _file = new File(filePath); // 读入文件  
		Image src = ImageIO.read(_file); // 构造Image对象  
		int width = src.getWidth(null); // 得到源图宽  
		int height = src.getHeight(null); // 得到源图长  
		//需要长度  
		int newwidth = width;//width / 2  
		int newheight = height;//height / 2  
		BufferedImage image = new BufferedImage(newwidth, newheight,  
				BufferedImage.TYPE_INT_RGB);  
		Graphics graphics = image.getGraphics();  
		graphics.drawImage(src, 0, 0, newwidth, newheight, null); // 绘制缩小后的图  
		// 画边框,在drawImage后面，下面代码给图片加上两个像素的白边     
		graphics.setColor(color);     
		graphics.drawRect(0, 0, newwidth - 1, newheight - 1);  
		graphics.drawRect(1, 1, newwidth - 1, newheight - 1);  
		graphics.drawRect(0, 0, newwidth - 2, newheight - 2);  
		FileOutputStream out = new FileOutputStream(filePath); // 输出到文件流  
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
		encoder.encode(image); // JPEG编码  
		out.close();  
	}
	public static void takeDrawRectAndText(String filePath,Color color,String drawText) throws IOException{
		File _file = new File(filePath); // 读入文件  
		Image src = ImageIO.read(_file); // 构造Image对象  
		int width = src.getWidth(null); // 得到源图宽  
		int height = src.getHeight(null); // 得到源图长  
		//需要长度  
		int newwidth = width;//width / 2  
		int newheight = height;//height / 2  
		BufferedImage image = new BufferedImage(newwidth, newheight,  
				BufferedImage.TYPE_INT_RGB);  
		Graphics graphics = image.getGraphics();  
		graphics.drawImage(src, 0, 0, newwidth, newheight, null); // 绘制缩小后的图  
		// 画边框,在drawImage后面，下面代码给图片加上两个像素的白边     
		graphics.setColor(color);     
		graphics.drawRect(0, 0, newwidth - 1, newheight - 1);  
		graphics.drawRect(1, 1, newwidth - 1, newheight - 1);  
		graphics.drawRect(0, 0, newwidth - 2, newheight - 2);  
		graphics.drawString(drawText, 10, height-10);
		Font font = new Font("Helvetica",Font.ITALIC,12);
		graphics.setFont(font);
		FileOutputStream out = new FileOutputStream(filePath); // 输出到文件流  
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
		encoder.encode(image); // JPEG编码  
		out.close();  
	}
}
