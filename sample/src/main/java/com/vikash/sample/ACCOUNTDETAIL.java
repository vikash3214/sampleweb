package com.vikash.sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ACCOUNTDETAIL {

	public JFrame accountdetail;
	private JTextField t1;
	private JTextField t4;
	private JComboBox comboBox;
	private JTextField t2;
	private JTextField t5;
	private JTextField t3;
	private JTextField t6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN window1 = new LOGIN();
					window1.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void populatecombobox1()
	{
	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","password");
		System.out.println("connnection established");
	    
		String query="select * from accountinfo";
		PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
		
				while(rs.next())
				{
					
					comboBox.addItem(rs.getString("account_no"));
				}
				
		pst.close();
		rs.close();
		
		} catch (ClassNotFoundException d) {
			
			d.printStackTrace();
		} catch (SQLException f)
		{
			f.printStackTrace();
		}  
		
	
		
		
		
	
		
	}

	/**
	 * Create the application.
	 */
	public ACCOUNTDETAIL() {
		initialize();
	}
	public void refresh()
	{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		comboBox.removeItem(comboBox.getSelectedItem().toString());
		
		
		
		
	}
	

	
	private void initialize() {
		accountdetail = new JFrame();
		accountdetail.setBounds(100, 100, 450, 300);
		accountdetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		accountdetail.setJMenuBar(menuBar);
		
		JMenu mnWelcome = new JMenu("welcome");
		menuBar.add(mnWelcome);
		
		JMenuItem mntmBack = new JMenuItem("BACK");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newfile abc=new newfile();
				abc.frame.setVisible(true);
				accountdetail.dispose();
				
				
				
			}
		});
		mnWelcome.add(mntmBack);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnWelcome.add(mntmExit);
		accountdetail.getContentPane().setLayout(null);
		
	 comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","password");
				System.out.println("connnection established");
			    
				String query="select * from accountinfo where account_no=?";
				PreparedStatement pst=con.prepareStatement(query);
				
		        pst.setString(1, comboBox.getSelectedItem().toString());		
				ResultSet rs=pst.executeQuery();
				
						while(rs.next())
						{
							t1.setText(rs.getString("account_no"));
							t2.setText(rs.getString("ACC_TYPE"));
							t3.setText(rs.getString("pan_no"));
							t4.setText(rs.getString("balance"));
							t5.setText(rs.getString("due"));
							t6.setText(rs.getString("customer_name"));
							
						}
				pst.close();
				rs.close();
				
				} catch (ClassNotFoundException d) {
					
					d.printStackTrace();
				} catch (SQLException f)
				{
					f.printStackTrace();
				}  
				
			
				
				
				
			
				
		
			}});
		comboBox.setBounds(113, 49, 130, 27);
		accountdetail.getContentPane().add(comboBox);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(96, 101, 86, 20);
		accountdetail.getContentPane().add(t1);
		t1.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(320, 101, 86, 20);
		accountdetail.getContentPane().add(t4);
		t4.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(96, 149, 86, 20);
		accountdetail.getContentPane().add(t2);
		t2.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(320, 149, 86, 20);
		accountdetail.getContentPane().add(t5);
		t5.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(96, 195, 86, 20);
		accountdetail.getContentPane().add(t3);
		t3.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(320, 195, 86, 20);
		accountdetail.getContentPane().add(t6);
		t6.setColumns(10);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","password");
				System.out.println("connnection established");
			    
				String query="update accountinfo set acc_type='"+t2.getText()+"', pan_no='"+t3.getText()+"',balance='"+t4.getText()+"',due='"+t5.getText()+"',customer_name='"+t6.getText()+"' where account_no='"+t1.getText()+"'";
				PreparedStatement pst=con.prepareStatement(query);
				
				pst.executeQuery();
				JOptionPane.showMessageDialog(null, "updated sussefully ");
				pst.close();
				
				} catch (ClassNotFoundException C) {
					
					C.printStackTrace();
				} catch (SQLException C)
				{
					C.printStackTrace();
				}  
				
				
			
				
				
				
			}
		});
		btnUpdate.setBounds(189, 15, 89, 23);
		accountdetail.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","password");
				System.out.println("connnection established");
			    
				String query="delete from accountinfo where account_no=?";
				
		        PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, t1.getText());
				
				int i=JOptionPane.showConfirmDialog(null, "do u really wanna delete");
				if (i==0){
				pst.executeQuery();
				refresh();
				JOptionPane.showMessageDialog(null, "deleted  sussefully ");
			
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "dont worry your data is safe ");
				}
				
				pst.close();
				
				
		     
				
			} catch (ClassNotFoundException C) {
					
					C.printStackTrace();
				} catch (SQLException C)
				{
					C.printStackTrace();
				}
				 
				
			}
		});
		btnDelete.setBounds(320, 15, 89, 23);
		accountdetail.getContentPane().add(btnDelete);
		
		JLabel lblAccountno = new JLabel("ACCOUNTNO");
		lblAccountno.setBounds(10, 55, 93, 14);
		accountdetail.getContentPane().add(lblAccountno);
		
		JLabel lblAccountNo = new JLabel("ACCOUNT NO");
		lblAccountNo.setBounds(10, 104, 76, 20);
		accountdetail.getContentPane().add(lblAccountNo);
		
		JLabel lblAccType = new JLabel("ACC TYPE");
		lblAccType.setBounds(10, 152, 76, 14);
		accountdetail.getContentPane().add(lblAccType);
		
		JLabel lblBalance = new JLabel("BALANCE");
		lblBalance.setBounds(246, 104, 46, 14);
		accountdetail.getContentPane().add(lblBalance);
		
		JLabel lblDue = new JLabel("DUE");
		lblDue.setBounds(246, 152, 46, 14);
		accountdetail.getContentPane().add(lblDue);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(246, 198, 46, 14);
		accountdetail.getContentPane().add(lblName);
		
		JLabel lblPanNo = new JLabel("PAN NO");
		lblPanNo.setBounds(10, 198, 46, 14);
		accountdetail.getContentPane().add(lblPanNo);
		populatecombobox1();
	 
	}
}
