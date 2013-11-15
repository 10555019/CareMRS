import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Login() {
		
		/*
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		*/
		
		setTitle("CareMRS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setBounds(455, 265, 253, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField.setBounds(455, 342, 253, 30);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("User Name :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(301, 265, 120, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(301, 342, 120, 30);
		contentPane.add(lblPassword);
		
		JButton B_login = new JButton("Login");
		B_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//*****when login button is pressed*****
				
				if (Doctor.checkLogin(textField.getText(),passwordField.getPassword() )){
					System.out.println("TURE");
				}
				else
					System.out.println("FALSE");
				
			}
		});
		B_login.setFont(new Font("Arial", Font.PLAIN, 20));
		B_login.setBounds(327, 452, 110, 60);
		contentPane.add(B_login);
		
		JButton B_exit = new JButton("Exit");
		B_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		B_exit.setFont(new Font("Arial", Font.PLAIN, 20));
		B_exit.setBounds(547, 452, 110, 60);
		contentPane.add(B_exit);
		
		
		
		/*JLabel lblCareMedicalRecord = new JLabel("Care Medical Record System");
		lblCareMedicalRecord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCareMedicalRecord.setBounds(375, 80, 281, 71);
		contentPane.add(lblCareMedicalRecord);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\C\\Desktop\\CareMRS.png"));
		lblNewLabel_1.setBounds(90, 32, 871, 196);
		contentPane.add(lblNewLabel_1);
		*/
		

		ImageIcon image1;
		JLabel label1;
		image1 = new ImageIcon(getClass().getResource("CareMRS.png"));
		label1 = new JLabel(image1);
		label1.setBounds(90,32,871,196);
		contentPane.add(label1);

		
	}
}
