package ckt.inspector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.dom4j.Element;
import org.openqa.selenium.By;

import ckt.App.Util.Draw;
import ckt.App.Util.IElement;
import ckt.App.Util.VP4;

public class UiViewer  extends JFrame{
	private static final long serialVersionUID = 1L;
	public static int width = 0;
	public static int height=0;
	public static JPanel imgPanel;
	public static UiViewer frame;
	public static JPanel jContentPane ;
	public static JPanel treePanel;
	public static JPanel elementPanel;
	public static String  imagePath;
	public static String  xmlPath;
	public static List<IElement> tms;
	public static JTable table;
	public static DefaultTableModel model; 
	public static JTree tree;
	public static Vector vData ;
	public static Vector vName;;
	public static DefaultTreeModel dModel;
	public static JDialog createDialog(){
		JDialog configDialog = new JDialog(frame, "调试 ", true);
		JPanel select_mk_panel = new JPanel();
		Dimension dimension = new Dimension(500, 100);
		Dimension lbDimension = new Dimension(40, 20);
		Dimension cmdDimension = new Dimension(320, 20);
		
		select_mk_panel.setLayout(new BoxLayout(select_mk_panel, BoxLayout.PAGE_AXIS));
		select_mk_panel.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.CENTER);
		
		JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));


		rowPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		JLabel ArgType= new JLabel("关键字");
		ArgType.setPreferredSize(lbDimension);
		JComboBox typejComboBox = new JComboBox();
		typejComboBox.addItem("Name");
		typejComboBox.addItem("ClassName");
		typejComboBox.addItem("Xpath");

		rowPanel.add(ArgType);
		rowPanel.add(typejComboBox);
		select_mk_panel.add(rowPanel);
		select_mk_panel.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.CENTER);
		
		rowPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		JLabel cmdLabel= new JLabel("值");
		JTextField cmd = new JTextField();
		JButton clickBtn = new JButton("CLICK");
		clickBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(VP4.iosdriver.getPageSource());
				
				// TODO Auto-generated method stub
				if (typejComboBox.getSelectedItem().toString().equals("Name")) {
					VP4.iosdriver.findElement(By.name(cmd.getText())).click();
				}
				if (typejComboBox.getSelectedItem().toString().equals("ClassName")) {
					VP4.iosdriver.findElement(By.className(cmd.getText())).click();
				}
				if (typejComboBox.getSelectedItem().toString().equals("Xpath")) {
					VP4.iosdriver.findElement(By.xpath(cmd.getText())).click();
				}
			}
		});
		//clickBtn.setPreferredSize(lbDimension);
		cmdLabel.setPreferredSize(lbDimension);
		cmd.setPreferredSize(cmdDimension);
		rowPanel.add(cmdLabel);
		rowPanel.add(cmd);
		rowPanel.add(clickBtn);
		select_mk_panel.add(rowPanel);
		select_mk_panel.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.CENTER);
		
		configDialog.setSize(dimension);
		configDialog.setLocationRelativeTo(frame);
		configDialog.getContentPane().add(select_mk_panel,BorderLayout.SOUTH);
		configDialog.setVisible(true);
		return configDialog;
	}
	public static void initImagePanel() {
		imgPanel=new JPanel();             //实例化一个面板
		imgPanel.setBackground(Color.BLUE);       
		imgPanel.setSize(width,height);          //设置面板对象大小

		Image image=new ImageIcon(imagePath).getImage();  
		imgPanel = new BackgroundPanel(image,0,0,width,height); 
		imgPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();  //得到鼠标x坐标
				int y = e.getY();  //得到鼠标y坐标
				getPointInElement(x, y);
			}
		});
	}
	public static String getRootXpath(DefaultMutableTreeNode node){
		TreeNode[] treeNodes = node.getPath();
		return "//XCUIElementType"+treeNodes[0].toString();
	}
	public static void expandAll(JTree tree)
	{
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
		expandTreeFromNode(tree, root);
	}

	/**
	 * Method Name:expandTreeFromNode
	 * Purpose:展开指定的节点。
	 */
	public static void expandTreeFromNode(JTree tree,DefaultMutableTreeNode nodeToE)
	{
		Enumeration<?> enumeration = nodeToE.preorderEnumeration();
		while (enumeration.hasMoreElements())
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
			if(!node.isLeaf())
			{
				TreePath path = new TreePath(node.getPath());
				tree.expandPath(path);
			}
		}
	}
	public static String getXpath(DefaultMutableTreeNode node){
		String pathString = "";
		TreeNode[] treeNodes = node.getPath();
		int nodeLength=treeNodes.length;
		if (nodeLength==1) {
			pathString=getRootXpath(node);
		}else {
			pathString = pathString+getRootXpath(node);
			for (int i = 1; i < treeNodes.length; i++) {
				TreeNode fNode = treeNodes[i];
				int count = fNode.getParent().getChildCount();
				if (count==1) {
					pathString=pathString+"/XCUIElementType"+fNode.toString();
				}else {
					TreeNode parentNode = fNode.getParent();
					int pcount = parentNode.getChildCount();
					int pIndex=parentNode.getIndex(fNode);
					//有多少个同类对象
					int sameTypecount=0;

					for (int j = 0; j < pcount; j++) {
						if (parentNode.getChildAt(j).toString().equals(fNode.toString())) {
							sameTypecount=sameTypecount+1;
						}
					}

					int cureentcount =0;
					for (int j = 0; j < pIndex+1; j++) {
						if (parentNode.getChildAt(j).toString().equals(fNode.toString())) {
							cureentcount=cureentcount+1;
						}
					}
					//System.out.println(String.format("%d-%d", sameTypecount,cureentcount));
					if (sameTypecount==1) {
						pathString=pathString+"/XCUIElementType"+fNode.toString();
					}else {
						pathString=pathString+"/XCUIElementType"+fNode.toString()+String.format("[%d]",cureentcount);
					}
				}
			}
		}
		return pathString;

	}
	public static void initEms(){
		List<Element>  ems = Inspector.getPageXmlElements();
		tms = Inspector.toIElements(ems);
	}
	public static void initTreePanel() {
		treePanel=new JPanel();             //实例化一个面板
		treePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		treePanel.setBackground(Color.WHITE);       
		treePanel.setSize(new Dimension(width,height));

		//treePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));//设置面板边框颜色
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(width,height));

		/*Inspector.getTree();
		Draw.takeInspectorScreenShot();*/
		Inspector.getTree();
		dModel=new DefaultTreeModel(Inspector.rootTree);
		tree = new JTree(dModel);
		/*ImageIcon leafIcon = new ImageIcon("images/middle.gif");
		if (leafIcon != null) {
		    DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		    renderer.setLeafIcon(leafIcon);
		    tree.setCellRenderer(renderer);
		}*/

		//initEms();
		System.out.println(tms.size());
		//Inspector.printTree();

		scrollPane.setViewportView(tree);  
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {//当我们在JTree上点选任何一个节点，都会触发TreeSelectionEvent事件
				Object obj = tree.getLastSelectedPathComponent();
				if (obj instanceof DefaultMutableTreeNode) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj;
					String xpathSelected = getXpath(node);

					System.out.println(xpathSelected);

					for (IElement iElement : tms) {
						//System.err.println(iElement.getXpath());
						if (iElement.getXpath().equals(xpathSelected)) {
							System.out.println("============find ==============");
							vData .clear();
							iElement.add(vData);
							model = new DefaultTableModel(vData, vName);
							table.setModel(model);

							imgPanel.removeAll();
							Image image=new ImageIcon(imagePath).getImage();  
							imgPanel = new BackgroundPanel(image,(int)iElement.getX(),(int)iElement.getY(),(int)iElement.getWidth(),(int)iElement.getHeight());  
							updateContentPane();

							break;
						}
					}
				}
			}
		});
		treePanel.add(scrollPane);
	}

	public static void initElementPanel() {
		elementPanel=new JPanel();             //实例化一个面板
		//创建表头
		elementPanel.setSize(width,height);          //设置面板对象大小
		vData = new Vector();
		vName = new Vector();

		vName.add("key");
		vName.add("value");

		Vector vRow = new Vector();
		vRow.add("cell 0 0");
		vRow.add("cell 0 1");

		vData.add(vRow.clone());

		model = new DefaultTableModel(vData, vName);
		table=new JTable();
		table.setModel(model);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中  
		// tcr.setHorizontalAlignment(JLabel.CENTER);  
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样  
		table.setDefaultRenderer(Object.class, tcr);  

		JTableHeader tableHeader = table.getTableHeader();  

		tableHeader.setReorderingAllowed(false);//表格列不可移动  
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//列名居中  

		table.setFont(new Font("华文楷体", Font.PLAIN, 14));
		table.setBackground(Color.YELLOW);


		//table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer());

		JScrollPane tableScrollPane = new JScrollPane(table);

		elementPanel.setBackground(Color.BLUE);       
		elementPanel.add(tableScrollPane);
		elementPanel.setSize(width,height);          //设置面板对象大小
	}
	public static void getPointInElement(int x ,int y){
		double area=width*height;;
		IElement aeraEmt = null;
		for (IElement iElement : tms) {
			Rectangle rectangle =iElement.getRectangle();
			if (rectangle.contains(x, y)) {
				double eArea = iElement.getArea();
				if (area>=eArea) {
					area=eArea;
					aeraEmt=iElement;
				}
			}
		}
		if (aeraEmt!=null) {
			imgPanel.removeAll();
			Image image=new ImageIcon(imagePath).getImage();  
			imgPanel = new BackgroundPanel(image,(int)aeraEmt.getX(),(int)aeraEmt.getY(),(int)aeraEmt.getWidth(),(int)aeraEmt.getHeight());  
			updateContentPane();
			//选中jtree
			expandTree(aeraEmt);
		}

	}
	public static int  expandTree(IElement element){
		System.out.println("do expandTree ");
		System.out.println("to -"+element.getXpath());
		int s = 0;
		Enumeration<?> enumeration = Inspector.rootTree.preorderEnumeration();
		while(enumeration.hasMoreElements()){ //遍历枚举对象.
			//先定义一个节点变量.
			DefaultMutableTreeNode node;
			node=(DefaultMutableTreeNode) enumeration.nextElement();//将节点名称给node.
			//System.out.println("==========expandTree=============");
			//System.out.println(node.toString());
			String xpath = UiViewer.getXpath(node);
			//System.out.println(xpath);
			//System.out.println("==========expandTree=============");
			if (xpath.equals(element.getXpath())) {
				System.err.println("find element with the same xpath");

				TreePath path = new TreePath(node.getPath());
				tree.expandPath(path);
				tree.makeVisible(path);
				tree.setSelectionPath(path);
				tree.updateUI();
				//PanelDemo.expandTreeFromNode(PanelDemo.tree, node);
				break;
			}
		}
		return s ;
	}
	public static void updateContentPane() {
		jContentPane =new JPanel();
		jContentPane.setLayout(new GridLayout(1,3));
		jContentPane.add(imgPanel);
		imgPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();  //得到鼠标x坐标
				int y = e.getY();  //得到鼠标y坐标
				String banner = "鼠标当前点击位置的坐标是" + x + "," + y;

				getPointInElement(x, y);

				System.out.println(banner);   //568  320
				//imgPanel.setSize(width, height);
			}
		});
		jContentPane.add(treePanel);
		jContentPane.add(elementPanel);

		frame.getContentPane().removeAll();
		frame.add(jContentPane);

		frame.setVisible(true);

	}
	public static JPanel getJContentPane() {
		initImagePanel();
		initTreePanel();
		initElementPanel();

		jContentPane =new JPanel();
		jContentPane.setLayout(new GridLayout(1,3));
		jContentPane.add(imgPanel);
		jContentPane.add(treePanel);
		jContentPane.add(elementPanel);
		return jContentPane;
	}
	public static void updateJtree(){
		/*tree.removeAll();
		tree = new JTree(Inspector.getTree());
		tree.updateUI();*/
		dModel.reload(Inspector.rootTree);
	}
	public UiViewer() {
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu actionMenu = new JMenu("Action");
		JMenu searchMenu = new JMenu("Search");
		menubar.add(actionMenu);
		menubar.add(searchMenu);
		
		JMenuItem debugItem = new JMenuItem("Debug");
		searchMenu.add(debugItem);
		debugItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createDialog();
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Capture");
		actionMenu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Dialog.start_doing(frame);

				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						String content;
						try {
							System.out.println(VP4.iosdriver.getSessionId());
							content = VP4.iosdriver.getPageSource();
						} catch (Exception e2) {
							// TODO: handle exception
							VP4.log("appium session has died,need to re-create appium instance");
							VP4.startAppium();
							content = VP4.iosdriver.getPageSource();
						}
						/*if (VP4.iosdriver.getSessionId()==null) {
							VP4.startAppium();
						}*/
						try {
							Inspector.writeTxtFile(content,new File(xmlPath));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						imagePath ="inspector/"+Draw.takeInspectorScreenShot();
						Inspector.getTree();

						List<Element>  ems = VP4.getPageXmlElements();
						//System.out.println(VP4.iosdriver.getPageSource());
						for (Element element : ems) {
							//System.out.println(element.getUniquePath());
						}
						List<IElement> tms = VP4.toIElements(ems);
						for (IElement iElement : tms) {
							//System.out.println(iElement.toString());
						}
						imgPanel.removeAll();
						Image image=new ImageIcon(imagePath).getImage();  
						imgPanel = new BackgroundPanel(image,0,0,width,height);   
						initTreePanel();
						updateContentPane();

						Dialog.stop_doing();
					}
				});
				thread.start();
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width*3+20, height+64);
		setTitle("Ios-Appium-Inspector");
		setLocationRelativeTo(getOwner());  
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

		imagePath = "inspector/app-inspector.png";  
		xmlPath= "inspector/app-inspector.xml";  
		BufferedImage image = ImageIO.read(new FileInputStream(imagePath));  
		height=image.getHeight()/2;
		width=image.getWidth()/2;
		System.out.println(height);
		System.out.println(width);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					/*String content = VP4.iosdriver.getPageSource();
					Inspector.writeTxtFile(content,new File(xmlPath));

					List<Element> ems = VP4.getPageXmlElements();
					for (Element element : ems) {
						System.out.println(element.getUniquePath());
					}

					List<IElement> tms = VP4.toIElements(ems);
					for (IElement iElement : tms) {
						System.out.println(iElement.toString());
					}*/
					try {  
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  
					} catch (Exception evt) {

					}  

					frame = new UiViewer();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
					//frame.setResizable(false); //禁止改变大小在调用显示之前  
					frame.setVisible(true);//2显示JFrame  
					//frame.pack();//3调用pack()适应子控件大小  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
