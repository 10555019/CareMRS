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
import javax.swing.SwingConstants;


public class MyWindow extends JFrame {

	private JPanel contentPane;
	private JPanel loginPane;
	private JPanel menuPane;
	private JPanel p_searchPane;
	private JPanel patientPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	CardLayout cardLayout = new CardLayout();
	
	private Patient patient;
	private JTextField txtTesting;
	private JTextField txtY;
	private JTextField textField;
	private JTextField textField_1;
	
	
	
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
					menuPage();
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
		//*****Menu Bar*****//
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
		//*****Menu Bar*****//
		JButton B_new = new JButton("New");
		B_new.setFont(new Font("Arial", Font.PLAIN, 25));
		B_new.setBounds(158, 219, 136, 56);
		menuPane.add(B_new);
		JButton B_search = new JButton("Search");
		B_search.setFont(new Font("Arial", Font.PLAIN, 25));
		B_search.setBounds(304, 219, 136, 56);
		menuPane.add(B_search);
		JButton B_clinic = new JButton("Clinic");
		B_clinic.setFont(new Font("Arial", Font.PLAIN, 25));
		B_clinic.setBounds(158, 352, 282, 108);
		menuPane.add(B_clinic);
		JButton b_myTimetable = new JButton("My Timetable");
		b_myTimetable.setFont(new Font("Arial", Font.PLAIN, 25));
		b_myTimetable.setBounds(537, 167, 282, 108);
		menuPane.add(b_myTimetable);
		JButton B_logOut = new JButton("Log out");
		B_logOut.setFont(new Font("Arial", Font.PLAIN, 25));
		B_logOut.setBounds(537, 352, 282, 108);
		menuPane.add(B_logOut);
	}
	
	private void p_searchPage(){
		
	}
	
	private void patientPage(){
		patientPane = new JPanel();
		patientPane.setLayout(null);
		
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
		patientPage();
		contentPane.add(patientPane, "Patient");
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblName.setBounds(36, 50, 133, 32);
		patientPane.add(lblName);
		
		JLabel lblHkid = new JLabel("HKID:");
		lblHkid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHkid.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHkid.setBounds(36, 132, 133, 32);
		patientPane.add(lblHkid);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGender.setBounds(322, 132, 133, 32);
		patientPane.add(lblGender);
		
		JLabel label_1 = new JLabel("Date of Birth:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Arial", Font.PLAIN, 20));
		label_1.setBounds(36, 214, 133, 32);
		patientPane.add(label_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(698, 331, 98, 32);
		patientPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 20));
		btnUpdate.setBounds(826, 331, 98, 32);
		patientPane.add(btnUpdate);
		
		txtTesting = new JTextField();
		txtTesting.setText("testing");
		txtTesting.setFont(new Font("Arial", Font.PLAIN, 20));
		txtTesting.setBounds(179, 50, 440, 32);
		patientPane.add(txtTesting);
		txtTesting.setColumns(10);
		
		txtY = new JTextField();
		txtY.setFont(new Font("Arial", Font.PLAIN, 20));
		txtY.setColumns(10);
		txtY.setBounds(179, 132, 133, 32);
		patientPane.add(txtY);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(465, 132, 133, 32);
		patientPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(179, 214, 133, 32);
		patientPane.add(textField_1);
		
		JLabel lblPatient = new JLabel("Patient");
		lblPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatient.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPatient.setBounds(158, 167, 282, 42);
		menuPane.add(lblPatient);
		
		cardLayout.show(contentPane, "Login");
	}
}
