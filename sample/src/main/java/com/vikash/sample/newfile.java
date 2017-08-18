package com.vikash.sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class newfile {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LOGIN window3 = new LOGIN();
					window3.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public newfile() {
		initialize();
	}
	public newfile(String param) {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAccount = new JMenu("ACCOUNT");
		menuBar.add(mnAccount);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("DETAIL");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ACCOUNTDETAIL aa =new ACCOUNTDETAIL();
				aa.accountdetail.setVisible(true);
				frame.dispose();
				
				
			}
		});
		mnAccount.add(mntmNewMenuItem);
		
		JSeparator separator_1 = new JSeparator();
		mnAccount.add(separator_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CREATE");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ACCOUNTCREATE a=new ACCOUNTCREATE();
				a.ACCOUNTCREAT.setVisible(true);
				frame.dispose();
				
	
			}
		});
		mnAccount.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnAccount.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		mnAccount.add(separator_2);
		
		JMenu mnCustomer = new JMenu("CUSTOMER");
		menuBar.add(mnCustomer);
		
		JMenuItem mntmDetail = new JMenuItem("DETAIL");
		mnCustomer.add(mntmDetail);
		
		JSeparator separator_3 = new JSeparator();
		mnCustomer.add(separator_3);
		
		JMenuItem mntmCreate = new JMenuItem("CREATE");
		mnCustomer.add(mntmCreate);
		
		JSeparator separator_4 = new JSeparator();
		mnCustomer.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		mnCustomer.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		mnCustomer.add(separator_6);
		
		JMenu mnExit = new JMenu("HELP");
		menuBar.add(mnExit);
		
		JMenuItem mntmContactAdmin = new JMenuItem("CONTACT ADMIN");
		mnExit.add(mntmContactAdmin);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		JSeparator separator_7 = new JSeparator();
		mnExit.add(separator_7);
		mnExit.add(mntmExit);
	}
}
