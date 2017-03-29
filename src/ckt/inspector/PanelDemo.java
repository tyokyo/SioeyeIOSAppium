package ckt.inspector;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.openqa.selenium.By;

import ckt.App.Util.AppiumBase;
import ckt.App.Util.Draw;
public class PanelDemo  extends JFrame{
	private static final long serialVersionUID = 1L;
	public static int width = 0;
	public static int height=0;

	public static JPanel getImagePanel() {
		JPanel imgPanel=new JPanel();             //实例化一个面板
		imgPanel.setBackground(Color.BLUE);       
		imgPanel.setSize(width,height);          //设置面板对象大小
		JLabel img = new JLabel();
		img.setIcon(new ImageIcon("001.png"));


		imgPanel.add(img);
		imgPanel.addMouseListener(new MouseAdapter(){  //匿名内部类，鼠标事件
			public void mouseClicked(MouseEvent e){   //鼠标完成点击事件
				if(e.getButton() == MouseEvent.BUTTON3){ //e.getButton就会返回点鼠标的那个键，左键还是右健，3代表右键
					int x = e.getX();  //得到鼠标x坐标
					int y = e.getY();  //得到鼠标y坐标
					String banner = "鼠标当前点击位置的坐标是" + x + "," + y;
					System.out.println(banner);
				}
			}
		});
		return imgPanel;
	}
	public static JPanel getTreePanel() {
		JPanel treePanel=new JPanel();             //实例化一个面板
		treePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		treePanel.setBackground(Color.WHITE);       
		treePanel.setSize(width,height);          //设置面板对象大小

		JScrollPane scrollPane = new JScrollPane();
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);  
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {//当我们在JTree上点选任何一个节点，都会触发TreeSelectionEvent事件
				DefaultMutableTreeNode note = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				//     String name = note.toString();//获得这个结点的名称
				//方法2
				//   String name=((DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent()).toString();
				// 获取选中节点的父节点
				DefaultMutableTreeNode parent = (DefaultMutableTreeNode) note.getParent();
				//获取父节点的子节点(首个子节点和最后一个子节点)
				DefaultMutableTreeNode FirstChild = (DefaultMutableTreeNode) note.getFirstChild();
				DefaultMutableTreeNode LastChild = (DefaultMutableTreeNode) note.getLastChild();
				System.out.println("选中节点的子节点"+FirstChild.toString());
				if (parent == null) {
					return;
				}
				int selectedIndex = parent.getIndex(note);
				System.out.println("选中节点的节点索引:"+selectedIndex);
			}
		});
		treePanel.add(tree);

		return treePanel;
	}
	public static JPanel getElementPanel() {
		JPanel elementPanel=new JPanel();             //实例化一个面板
		//创建表头
		String[] columnNames = { "First Name", "Last Name", "Sport",
				"# of Years", "Vegetarian" };
		//创建显示数据
		Object[][] data = {
				{ "Kathy", "Smith", "Snowboarding", new Integer(5),
					new Boolean(false) },
					{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
					{ "Sue", "Black", "Knitting", new Integer(2),
						new Boolean(false) },
						{ "Jane", "White", "Speed reading", new Integer(20),
							new Boolean(true) },
							{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

		JTable table = new JTable(data, columnNames);
		table.setBackground(Color.YELLOW);
		JScrollPane tableScrollPane = new JScrollPane(table);

		elementPanel.setBackground(Color.BLUE);       
		elementPanel.add(tableScrollPane);
		elementPanel.setSize(width,height);          //设置面板对象大小
		return elementPanel;
	}
	public static JPanel getJContentPane() {
		JPanel jContentPane =new JPanel();
		jContentPane = new JPanel();
		jContentPane.setLayout(new GridLayout(1,3));
		jContentPane.add(getImagePanel());
		jContentPane.add(getTreePanel());
		jContentPane.add(getElementPanel());
		return jContentPane;
	}
	public PanelDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width*3, height);
		setTitle("Ios-Appium-Inspector");
		add(getJContentPane());
		//setContentPane(getJContentPane());
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*AppiumBase.startAppium();
		height =AppiumBase.iosdriver.manage().window().getSize().height; 
		width=AppiumBase.iosdriver.manage().window().getSize().width;
		System.out.println("width="+width+"");
		System.out.println("height"+height+"");
		AppiumBase.stopAppium();*/

		String imgPath = "001.png";  
		BufferedImage image = ImageIO.read(new FileInputStream(imgPath));  
		Image image2 = image.getScaledInstance(width, height,
				Image.SCALE_DEFAULT); // 返回图像的缩放版本。默认的图像缩放算法

		height=image.getHeight()/2;
		width=image.getWidth()/2;
		System.out.println(height);
		System.out.println(width);


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDemo frame = new PanelDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
