package ckt.inspector;


import java.awt.EventQueue;
import java.awt.event.InputEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AppDemo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppDemo frame = new AppDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AppDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("测试");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 20, 196, 217);
		contentPane.add(scrollPane);
		final JTree tree = new JTree();
		scrollPane.setViewportView(tree);    textField = new JTextField();
		textField.setBounds(252, 35, 172, 27);
		contentPane.add(textField);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {//当我们在JTree上点选任何一个节点，都会触发TreeSelectionEvent事件
				//根据数字 0、1、2··区分根节点、子节点
				//   int z = tree.getSelectionCount();
				//   System.out.println(z);
				//   String name=((DefaultMutableTreeNode) tree.getSelectionPath().getPathComponent(z)).toString();
				//获取当前节点和前面所有节点的值
				//    TreePath note = tree.getSelectionPath();
				//获取当前选择节点的值
				//方法一
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
				// 获取选中节点的节点索引
				int selectedIndex = parent.getIndex(note);
				System.out.println("选中节点的节点索引:"+selectedIndex);
				textField.setText(parent.toString());

				// 判断是否为树叶节点，若是则显示文件内容，若不是则不做任何事。
				// if (note.isLeaf()) {
				// /*
				// * 取得文件的位置路径,System.getProperty("user.dir")可以取得目前工作的路径，
				// * System.getProperty("file.separator")是取得文件分隔符，例如在window环境的
				// * 文件分陋符是"\",而Unix环境的文件分隔符刚好相反，是"/".利用System.getProperty()
				// * 方法你可以取得下列的信息: java.version 显示java版本 java.endor 显示java制造商
				// * java.endor.url 显示java制造商URL java.home 显示java的安装路径
				// * java.class.version 显示java类版本 java.class.path 显示java classpath
				// * os.name 显示操作系统名称 os.arch 显示操作系统结构，如x86 os.version 显示操作系统版本
				// * file.separator 取得文件分隔符 path.separator 取得路径分隔符，如Unix是以“:”表示
				// * line.separator 取得换行符号，如Unix是以"\n"表示 user.name 取得用户名称 user.home
				// * 取得用户家目录(home directory),如Windows中Administrator的家目 录为c:\Documents
				// * and Settings\Administrator user.dir 取得用户目前的工作目录.
				// */
				// String filepath = "file:" + System.getProperty("user.dir")
				// + System.getProperty("file.separator") + note;
				// System.out.println(filepath);
				//// try {
				//// // 利用JEditorPane的setPage()方法将文件内容显示在editorPane中。若文件路径错误，则会产生IOException.
				//// editorPane.setPage(filepath);
				//// } catch (IOException ex) {
				//// System.out.println("找不到此文件");
				//// }
				// }
			}
		});
		//添加鼠标事件
		tree.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//        默认单击鼠标一下
				//          if(evt.getClickCount()==1){
				//             System.out.println("一下");
				//          }
				//点击鼠标左键两下
				//      1 左键
				//      2 中键（Sun Mouse）
				//      3 右键
				if(evt.getModifiers()==InputEvent.BUTTON1_MASK && evt.getClickCount()==2) {
					System.out.println("两下");
				}
			}
		});
	}
}