package com.vikash.sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ACCOUNTCREATE {

	public JFrame ACCOUNTCREAT;
	private JTextField t1;
	private JTextField t4;
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
					ACCOUNTCREATE window2 = new ACCOUNTCREATE();
					window2.ACCOUNTCREAT.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public ACCOUNTCREATE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ACCOUNTCREAT = new JFrame();
		ACCOUNTCREAT.setBounds(100, 100, 467, 403);
		ACCOUNTCREAT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ACCOUNTCREAT.getContentPane().setLayout(null);

		t1 = new JTextField();

		t1.setBounds(94, 70, 86, 20);
		ACCOUNTCREAT.getContentPane().add(t1);
		t1.setColumns(10);

		t4 = new JTextField();
		t4.setBounds(307, 70, 86, 20);
		ACCOUNTCREAT.getContentPane().add(t4);
		t4.setColumns(10);

		t2 = new JTextField();
		t2.setBounds(84, 119, 86, 20);
		ACCOUNTCREAT.getContentPane().add(t2);
		t2.setColumns(10);

		t5 = new JTextField();
		t5.setBounds(307, 119, 86, 20);
		ACCOUNTCREAT.getContentPane().add(t5);
		t5.setColumns(10);

		t3 = new JTextField();
		t3.setBounds(84, 171, 86, 20);
		ACCOUNTCREAT.getContentPane().add(t3);
		t3.setColumns(10);

		t6 = new JTextField();
		t6.setBounds(307, 171, 86, 20);
		ACCOUNTCREAT.getContentPane().add(t6);
		t6.setColumns(10);

		JLabel lblNewLabel = new JLabel("ACCOUNT NO");
		lblNewLabel.setBounds(10, 73, 75, 17);
		ACCOUNTCREAT.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ACC TYPE");
		lblNewLabel_1.setBounds(10, 122, 64, 14);
		ACCOUNTCREAT.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PAN NO");
		lblNewLabel_2.setBounds(10, 174, 64, 14);
		ACCOUNTCREAT.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("BALANCE");
		lblNewLabel_3.setBounds(231, 76, 66, 14);
		ACCOUNTCREAT.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("DUE");
		lblNewLabel_4.setBounds(231, 122, 46, 14);
		ACCOUNTCREAT.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("NAME");
		lblNewLabel_5.setBounds(231, 174, 46, 14);
		ACCOUNTCREAT.getContentPane().add(lblNewLabel_5);

		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
							"password");
					System.out.println("connnection established");

					String query = "insert into accountinfo(account_no,acc_type,pan_no,balance,due,customer_name) values(?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					int a = Integer.parseInt(t1.getText());
					pst.setInt(1, a);
					pst.setString(2, t2.getText());
					pst.setString(3, t3.getText());
					pst.setString(4, t4.getText());
					pst.setString(5, t5.getText());
					pst.setString(6, t6.getText());
					ResultSet rs = pst.executeQuery();
					JOptionPane.showMessageDialog(null, "CREATED succesfully");
					pst.close();
					rs.close();

				} catch (ClassNotFoundException d) {

					d.printStackTrace();
				} catch (SQLException f) {
					f.printStackTrace();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "something wrong entered");
				}

			}
		});
		btnNewButton.setBounds(60, 261, 162, 61);
		ACCOUNTCREAT.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
			}
		});
		btnNewButton_1.setBounds(266, 261, 145, 61);
		ACCOUNTCREAT.getContentPane().add(btnNewButton_1);

		JMenuBar menuBar = new JMenuBar();
		ACCOUNTCREAT.setJMenuBar(menuBar);

		JMenu mnOperation = new JMenu("operation");
		menuBar.add(mnOperation);

		JMenuItem mntmBack = new JMenuItem("BACK");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newfile abc = new newfile();
				abc.frame.setVisible(true);
				ACCOUNTCREAT.dispose();

			}
		});
		mnOperation.add(mntmBack);
	}
}
