import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;


public class MyWindow extends JFrame {

	private JPanel contentPane;
	private JPanel loginPane;
	private JPanel menuPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	CardLayout cardLayout = new CardLayout();
	
	private void loginPage(){
		loginPane = new JPanel();
		loginPane.setLayout(null);
		//TextField, for user to type user name
		userNameField = new JTextField();
		userNameField.setFont(new Font("Arial", Font.PLAIN, 20));
		userNameField.setBounds(455, 265, 253, 30);
		loginPane.add(userNameField);
		userNameField.setColumns(10);
		//PasswordField, for user to type password
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField.setBounds(455, 342, 253, 30);
		loginPane.add(passwordField);
		//Label, User name
		JLabel lblNewLabel = new JLabel("User Name :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(301, 265, 120, 30);
		loginPane.add(lblNewLabel);
		//Label, Password
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(301, 342, 120, 30);
		loginPane.add(lblPassword);
		//Button, Login
		JButton B_login = new JButton("Login");
		B_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//when login button is pressed
				if (Doctor.checkLogin(userNameField.getText(),passwordField.getPassword() )){
					userNameField.setText("");
					passwordField.setText("");
					cardLayout.show(contentPane, "Menu");
				}
				else
					JOptionPane.showMessageDialog(null, "Please retry","Login Failed", JOptionPane.ERROR_MESSAGE);
			}
		});
		B_login.setFont(new Font("Arial", Font.PLAIN, 20));
		B_login.setBounds(327, 452, 110, 60);
		loginPane.add(B_login);
		//Button, Exit
		JButton B_exit = new JButton("Exit");
		B_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		B_exit.setFont(new Font("Arial", Font.PLAIN, 20));
		B_exit.setBounds(547, 452, 110, 60);
		loginPane.add(B_exit);
		//Title Image, CareMRS
		ImageIcon image_title;
		JLabel label1;
		image_title = new ImageIcon(getClass().getResource("CareMRS.png"));
		label1 = new JLabel(image_title);
		label1.setBounds(90,32,871,196);
		loginPane.add(label1);
	}
	
	private void menuPage(){
		menuPane = new JPanel();
		menuPane.setLayout(null);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu patient = new JMenu("Patient");
		menubar.add(patient);
		JMenuItem newpatient = new JMenuItem("New");
		JMenuItem searchpatient = new JMenuItem("Search");
		patient.add(newpatient);
		patient.add(searchpatient);
		
		JMenu clinic = new JMenu("Clinic");
		menubar.add(clinic);
		JMenuItem openinghr = new JMenuItem("Opening hour");
		JMenuItem medicTreat = new JMenuItem("Medical Treatment");
		JMenuItem specCond = new JMenuItem("Special Condition");
		JMenuItem backup = new JMenuItem("Backup data");
		clinic.add(openinghr);
		clinic.add(medicTreat);
		clinic.add(specCond);
		clinic.add(backup);
		
		JMenu account = new JMenu("Account");
		menubar.add(account);
		JMenuItem changePassword = new JMenuItem("Change Password");
		JMenuItem logout = new JMenuItem("Log out");
		account.add(changePassword);
		account.add(logout);
		
		class exitaction implements ActionListener{
			public void actionPerformed (ActionEvent e){
				cardLayout.show(contentPane, "Login");
			}
		}
		logout.addActionListener(new exitaction());
		
	}

	/**
	 * Create the frame.
	 */
	public MyWindow() {
		
		/*
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		*/
		
		setTitle("CareMRS");
		setIconImage(new ImageIcon(getClass().getResource("C.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		loginPage();
		contentPane.add(loginPane, "Login");
		menuPage();
		contentPane.add(menuPane, "Menu");
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(189, 167, 136, 108);
		menuPane.add(btnNew);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(335, 167, 136, 108);
		menuPane.add(btnSearch);
		
		JButton btnClinic = new JButton("Clinic");
		btnClinic.setBounds(265, 396, 136, 108);
		menuPane.add(btnClinic);
		
		JButton btnMyTimetable = new JButton("My Timetable");
		btnMyTimetable.setBounds(578, 167, 136, 108);
		menuPane.add(btnMyTimetable);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(578, 396, 136, 108);
		menuPane.add(btnLogOut);
		
		cardLayout.show(contentPane, "Login");
	}
}
