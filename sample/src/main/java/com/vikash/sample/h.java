package com.vikash.sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class h {
	public  String s3="fzfd",s4="xgdx";

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					h window = new h();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void intialse()
	{
		s3=textField.getText();
		s4=textField_1.getText();
		System.out.println(s3);
		System.out.println(s4);
	}
	public h() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("raj");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(84, 59, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(84, 123, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				 String s1=textField_1.getText();
			String 	s2=textField.getText();
				
				System.out.println(s1);
				System.out.println(s2);
				intialse();
				 g gg=new g();
	                gg.frame.setVisible(true);
	                frame.dispose();
		
               
	
			}
		});
		btnNewButton.setBounds(96, 190, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
