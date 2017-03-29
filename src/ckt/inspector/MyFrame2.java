package ckt.inspector;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class MyFrame2 extends javax.swing.JFrame {
	public static void main(String[] args) {
		MyFrame2 f = new MyFrame2();
	}

	JLabel label2;
	JLabel label3;
	JTextField tf;
	JPasswordField psf;


	public MyFrame2() {
		this.setVisible(true);
		this.setSize(250, 220);
		this.setVisible(true);
		this.setLocation(400, 200);

		label2 = new JLabel("账号：");
		label3 = new JLabel("密码：");
		tf = new JTextField();
		psf = new JPasswordField();
		// 为指定的 Container 创建 GroupLayout
		GroupLayout layout = new GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(layout);
		//创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGap(5);//添加间隔
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(label2)
				.addComponent(label3));
		hGroup.addGap(5);
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(psf)
				.addComponent(tf));
		hGroup.addGap(5);
		layout.setHorizontalGroup(hGroup);
		//创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGap(10);
		vGroup.addGroup(layout.createParallelGroup().addComponent(label2)
				.addComponent(tf));
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup().addComponent(label3)
				.addComponent(psf));
		vGroup.addGap(10);
		//设置垂直组
		layout.setVerticalGroup(vGroup);
	}
}