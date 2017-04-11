package ckt.inspector;

import java.awt.*;  

import javax.swing.JPanel;  

import sun.java2d.loops.FillRect;
  
/** 
 * 有背景图片的Panel类 
 * @author tntxia 
 * 
 */  
public class BackgroundPanel extends JPanel {  
	private int width=0;
	private int height=0;
	private int x=0;
	private int y=0;
	
    private static final long serialVersionUID = -6352788025440244338L;  
      
    private Image image = null;  
  
    public BackgroundPanel(Image image,int x,int y,int width,int height) {  
        this.image = image;  
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }  
    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件  
    @Override
    protected void paintComponent(Graphics g) {  
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH, HEIGHT);
      /*  g.setColor(Color.RED);
        g.drawRect(x, y, width, height);*/
        
        Graphics2D g2d = (Graphics2D) g;  //首先把g转换成g2d
        g2d.setColor(Color.RED);//设置颜色,可以省略
        g2d.setStroke(new BasicStroke(5.0f));//关键,设置画笔的宽度.  越大,边框越粗搜索
        g.drawRect(x, y, width, height);//画矩形
    }  
}  