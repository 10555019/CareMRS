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
	CardLayout cardLayout = new CardLayout();
	
	private Patient patient;
	
	
	
	private void loginPage(){
		loginPane = new JPanel();
		loginPane.setLayout(null);
		final JTextField userNameField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();
		//TextField, for user to type user name
		userNameField.setFont(new Font("Arial", Font.PLAIN, 20));
		userNameField.setBounds(455, 265, 253, 30);
		loginPane.add(userNameField);
		userNameField.setColumns(10);
		//PasswordField, for user to type password
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
		B_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Patient");
			}
		});
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
		B_logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Login");
			}
		});
		B_logOut.setFont(new Font("Arial", Font.PLAIN, 25));
		B_logOut.setBounds(537, 352, 282, 108);
		menuPane.add(B_logOut);
	}
	
	private void p_searchPage(){
		p_searchPane = new JPanel();
		p_searchPane.setLayout(null);
		
	}
	
	private void patientPage(){
		patientPane = new JPanel();
		patientPane.setLayout(null);
		final JTextField T_name = new JTextField();
		final JTextField T_HKID = new JTextField();
		final JTextField T_gender = new JTextField();
		final JTextField T_dob = new JTextField();
		
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//**********
				//**
				//** Method: change patient record
				//**
				//**********
				JOptionPane.showMessageDialog(null, "Patient records have been saved","Patient record", JOptionPane.PLAIN_MESSAGE);
				T_name.setEditable(false);
				T_HKID.setEditable(false);
				T_gender.setEditable(false);
				T_dob.setEditable(false);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(698, 298, 98, 32);
		patientPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				T_name.setEditable(true);
				T_HKID.setEditable(true);
				T_gender.setEditable(true);
				T_dob.setEditable(true);
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 20));
		btnUpdate.setBounds(826, 298, 98, 32);
		patientPane.add(btnUpdate);
		
		JButton btnNewButton_1 = new JButton("Booking");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton_1.setBounds(101, 384, 190, 100);
		patientPane.add(btnNewButton_1);
		
		JButton btnTreatment = new JButton("Treatment");
		btnTreatment.setFont(new Font("Arial", Font.PLAIN, 25));
		btnTreatment.setBounds(392, 384, 190, 100);
		patientPane.add(btnTreatment);
		
		JButton button_1 = new JButton("New button");
		button_1.setFont(new Font("Arial", Font.PLAIN, 25));
		button_1.setBounds(683, 384, 190, 100);
		patientPane.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setFont(new Font("Arial", Font.PLAIN, 25));
		button_2.setBounds(101, 506, 190, 100);
		patientPane.add(button_2);
		
		JButton btnLog = new JButton("Log");
		btnLog.setFont(new Font("Arial", Font.PLAIN, 25));
		btnLog.setBounds(392, 506, 190, 100);
		patientPane.add(btnLog);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Arial", Font.PLAIN, 25));
		btnLogOut.setBounds(683, 506, 190, 100);
		patientPane.add(btnLogOut);
		
		JPanel color1 = new JPanel();
		color1.setBackground(new Color(245, 222, 179));
		color1.setBounds(24, 21, 924, 341);
		patientPane.add(color1);
		
		T_name.setFont(new Font("Arial", Font.PLAIN, 20));
		T_name.setBounds(179, 50, 419, 32);
		patientPane.add(T_name);
		T_name.setColumns(10);
		
		T_HKID.setFont(new Font("Arial", Font.PLAIN, 20));
		T_HKID.setColumns(10);
		T_HKID.setBounds(179, 132, 133, 32);
		patientPane.add(T_HKID);
		
		T_gender.setFont(new Font("Arial", Font.PLAIN, 20));
		T_gender.setColumns(10);
		T_gender.setBounds(465, 132, 133, 32);
		patientPane.add(T_gender);
		
		T_dob.setFont(new Font("Arial", Font.PLAIN, 20));
		T_dob.setColumns(10);
		T_dob.setBounds(179, 214, 133, 32);
		patientPane.add(T_dob);
		
		JLabel lblPatient = new JLabel("Patient");
		lblPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatient.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPatient.setBounds(158, 167, 282, 42);
		menuPane.add(lblPatient);
		
		if (patient != null){
			T_name.setText(patient.getName());
			T_HKID.setText(patient.getHKID());
			T_gender.setText(Character.toString(patient.getGender()));
			T_dob.setText(patient.getDob_S());
			T_name.setEditable(false);
			T_HKID.setEditable(false);
			T_gender.setEditable(false);
			T_dob.setEditable(false);
		}
		
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
		p_searchPage();
		contentPane.add(p_searchPane, "P_search");
		
		cardLayout.show(contentPane, "Login");
	}
}
