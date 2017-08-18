package com.vikash.sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class g {

public  JFrame frame;
private JTextField t2;
private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					g window = new g();
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
	public g() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		h hf = new h();
		
		hf.intialse();
		
		frame = new JFrame("viky");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		t2 = new JTextField();
		t2.setBounds(87, 68, 86, 20);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		
		
		t1 = new JTextField();
		t1.setBounds(106, 125, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
	}

}
