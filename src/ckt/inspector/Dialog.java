package ckt.inspector;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Dialog {
	public static JDialog progressDialog;
	public static Dimension dimension =new Dimension(150, 22);
	public static  JDialog start_doing_dialog(JFrame frame){
		progressDialog = new JDialog(frame,"操作在进行中,请等待...",true);
		progressDialog.setAlwaysOnTop(true);
		//progressDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL );  
		bar.setPreferredSize(dimension);
		bar.setToolTipText("执行中.....");
		bar.setPreferredSize(new Dimension(400, 20));
		bar.setMinimum(0);
		bar.setIndeterminate(true);
		progressDialog.setSize(500, 70);
		progressDialog.getContentPane().setLayout(new BorderLayout());
		JPanel jPanel = new JPanel();
		jPanel.add(bar);
		progressDialog.getContentPane().add(jPanel,BorderLayout.CENTER);
		progressDialog.setLocationRelativeTo(frame);
		progressDialog.setResizable(false);
		progressDialog.setVisible(true);
		return progressDialog;
	}
	public static void stop_doing(){
		progressDialog.dispose();
	}
	public static void start_doing(final JFrame frame){
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				start_doing_dialog(frame);
			}
		}).start();
	}
}
