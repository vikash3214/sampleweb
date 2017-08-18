package com.vikash.sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

public class radio {

public JFrame frame;
private JTextField T1;
private JTextField T2;
ButtonGroup H1 = new ButtonGroup();
ButtonGroup H2 = new ButtonGroup();
ButtonGroup H3 = new ButtonGroup();
String dept= new String();
String sex= new String();
String status= new String();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					radio window = new radio();
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
	public radio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("sample radio button");
		frame.setBounds(100, 100, 689, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 55, 77, 27);
		frame.getContentPane().add(lblNewLabel);
		
		T1 = new JTextField();
		T1.setBounds(172, 61, 155, 20);
		frame.getContentPane().add(T1);
		T1.setColumns(10);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAge.setBounds(38, 119, 46, 14);
		frame.getContentPane().add(lblAge);
		
		T2 = new JTextField();
		T2.setBounds(172, 119, 155, 20);
		frame.getContentPane().add(T2);
		T2.setColumns(10);
		
		JLabel lblDepartment = new JLabel("DEPARTMENT");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartment.setBounds(10, 186, 122, 14);
		frame.getContentPane().add(lblDepartment);
		
		JCheckBox C1 = new JCheckBox("IT");
		C1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dept="it";
				
				System.out.println(dept);
				
			}
		});
		H1.add(C1);
		C1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		C1.setBounds(172, 174, 155, 27);
		frame.getContentPane().add(C1);
		
		JCheckBox C2 = new JCheckBox("HR");
		C2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept="hr";
				System.out.println(dept);
				
			}
		});
		H1.add(C2);
		C2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		C2.setBounds(172, 201, 97, 23);
		frame.getContentPane().add(C2);
		
		JLabel lblSex = new JLabel("SEX");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSex.setBounds(26, 261, 58, 14);
		frame.getContentPane().add(lblSex);
		
		JRadioButton r1 = new JRadioButton("MALE");
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex="male";
				System.out.println(sex);
			}
		});
		H2.add(r1);
		r1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		r1.setBounds(130, 257, 109, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("FEMALE");
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex="female";
				System.out.println(sex);
			}
		});
		H2.add(r2);
		r2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		r2.setBounds(254, 257, 109, 23);
		frame.getContentPane().add(r2);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus.setBounds(25, 324, 83, 14);
		frame.getContentPane().add(lblStatus);
		
		JRadioButton r3 = new JRadioButton("ACTIVE");
		r3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status="active";
				System.out.println(status);
			}
		});
		H3.add(r3);
		r3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		r3.setBounds(130, 323, 109, 23);
		frame.getContentPane().add(r3);
		
		JRadioButton r4 = new JRadioButton("INACTIVE");
		r4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status="inactive";
				System.out.println(status);
			}
		});
		H3.add(r4);
		r4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		r4.setBounds(254, 323, 109, 23);
		frame.getContentPane().add(r4);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","password");
				System.out.println("connnection established");
			    //jdbc ka code hai 
				String query="insert into user4 values(?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, T1.getText());
				int a=Integer.parseInt(T2.getText());
				pst.setLong(2,a );
				pst.setString(3, dept);
				pst.setString(4, sex);
				pst.setString(5, status);
            pst.executeQuery();				
				
				JOptionPane.showMessageDialog(null, "CREATED succesfully");
				pst.close();
				
				
				} catch (ClassNotFoundException d) {
					
					d.printStackTrace();
				} catch (SQLException f)
				{
					f.printStackTrace();
				}  
				catch(Exception g)
				{
					JOptionPane.showMessageDialog(null, "something wrong entered");
				}
			
				
				
				
			
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(528, 320, 135, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
