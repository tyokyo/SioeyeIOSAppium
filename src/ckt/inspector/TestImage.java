package ckt.inspector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestImage extends JFrame {
	public void launch() {
		this.setTitle("TestImage");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//JFrame最大化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//让JFrame的关闭按钮起作用
		this.setVisible(true);//显示JFrame
	}

	public static void main(String args[]) {
		TestImage testImage = new TestImage();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		ImageIcon img = new ImageIcon("001.png");//创建图片对象
		label.setIcon(img);
		panel.add(label);
		testImage.getContentPane().add(panel);
		testImage.launch();
	}
}