package ckt.ios.Test;

import java.io.File;
import java.io.FileOutputStream;  
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.image.BufferedImage;  

import com.sun.image.codec.jpeg.JPEGCodec;  
import com.sun.image.codec.jpeg.JPEGImageEncoder;  

public class JpgTest {  

	public void JpgTset() throws Exception {  
		File _file = new File("test-output/screenshot/f3.png"); // 读入文件  
		Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象  
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
		graphics.setColor(Color.RED);     
		graphics.drawRect(0, 0, newwidth - 1, newheight - 1);  
		graphics.drawRect(1, 1, newwidth - 1, newheight - 1);  
		graphics.drawRect(0, 0, newwidth - 2, newheight - 2);  
		graphics.drawString("======================", 10, 10);
		FileOutputStream out = new FileOutputStream("test-output/screenshot/f3.png"); // 输出到文件流  
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
		encoder.encode(image); // JPEG编码  
		out.close();  
	}  
	public static void main(String[] args) {  
		JpgTest jpg = new JpgTest();  
		try {  
			jpg.JpgTset();  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}  
} 