package com.vikash.sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LOGIN {

public JFrame frame;
	private JTextField T1;
	private JPasswordField T2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN window = new LOGIN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	/**
	 * Create the application.
	 */
	public LOGIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(91, 44, 132, 36);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(91, 91, 132, 63);
		frame.getContentPane().add(lblPassword);
		
		T1 = new JTextField();
		T1.setBounds(239, 56, 157, 24);
		frame.getContentPane().add(T1);
		T1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		             Class.forName("oracle.jdbc.driver.OracleDriver");  
							  
							
							Connection con=DriverManager.getConnection(  
							"jdbc:oracle:thin:@localhost:1521:xe","system","password");
						String query="select *from user_auth where username=? and password=?";
							PreparedStatement pst=con.prepareStatement(query);
			               pst.setString(1, T1.getText());
			              pst.setString(2, T2.getText());
							
						  
			              ResultSet rs=pst.executeQuery();
					      int count=0;
						 
					      while(rs.next())
					   {
						   count++;
						   
						 }
						  System.out.println(count);
						  if (count==1)
						  {
							  
						  JOptionPane.showMessageDialog(null, "valid password");
						  frame.dispose();
						radio rr=new radio();
						  rr.frame.setVisible(true);
					 
					
						 
						  
						  }
						  else 
						  {
							  
							  JOptionPane.showMessageDialog(null, "invalid password");
						  }
						}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, "invalid try again");
						}
				
				
			}
		});
		btnNewButton.setBounds(113, 196, 110, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				T1.setText("");
				T2.setText("");
			
			}
		});
		btnNewButton_1.setBounds(280, 198, 123, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		T2 = new JPasswordField();
		T2.setBounds(239, 116, 157, 20);
		frame.getContentPane().add(T2);
	}
}
