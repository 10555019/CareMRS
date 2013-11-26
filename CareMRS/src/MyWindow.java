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
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.text.ParseException;
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
		B_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Search");
			}
		});
		B_search.setFont(new Font("Arial", Font.PLAIN, 25));
		B_search.setBounds(304, 219, 136, 56);
		menuPane.add(B_search);
		JButton B_clinic = new JButton("Clinic");
		B_clinic.setFont(new Font("Arial", Font.PLAIN, 25));
		B_clinic.setBounds(346, 352, 282, 108);
		menuPane.add(B_clinic);
		JButton B_myTimetable = new JButton("My Timetable");
		B_myTimetable.setFont(new Font("Arial", Font.PLAIN, 25));
		B_myTimetable.setBounds(537, 167, 282, 108);
		menuPane.add(B_myTimetable);
	}
	
	private void p_searchPage(){
		p_searchPane = new JPanel();
		p_searchPane.setLayout(null);
		
		JLabel lbl_searchPatient = new JLabel("Search Patient");
		lbl_searchPatient.setFont(new Font("Arial", Font.PLAIN, 30));
		lbl_searchPatient.setBounds(386, 20, 202, 41);
		p_searchPane.add(lbl_searchPatient);
		
		JLabel lbl_HKID = new JLabel("HKID:");
		lbl_HKID.setFont(new Font("Arial", Font.PLAIN, 25));
		lbl_HKID.setBounds(343, 253, 80, 41);
		p_searchPane.add(lbl_HKID);
		
		MaskFormatter idFormatter;
		try {
			idFormatter = new MaskFormatter("U######'(#')");
			final JFormattedTextField T_HKID = new JFormattedTextField(idFormatter);
			T_HKID.setFont(new Font("Arial", Font.PLAIN, 25));
			T_HKID.setBounds(447, 253, 171, 41);
			p_searchPane.add(T_HKID);
			T_HKID.setColumns(10);
			
			JButton B_clear = new JButton("Clear");
			B_clear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					T_HKID.setText("");
				}
			});
			B_clear.setFont(new Font("Arial", Font.PLAIN, 25));
			B_clear.setBounds(416, 366, 142, 70);
			p_searchPane.add(B_clear);
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Unable to add ID Field","Failed", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		JButton B_search = new JButton("Search");
		B_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//**********
				//**
				//** Method: call search method here
				//**
				//** patient = Patient.search(.....);
				//**********				

				cardLayout.show(contentPane, "Patient");
			}
		});
		B_search.setFont(new Font("Arial", Font.PLAIN, 25));
		B_search.setBounds(230, 366, 142, 70);
		p_searchPane.add(B_search);
		
		JButton B_menu = new JButton("Menu");
		B_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Menu");
			}
		});
		B_menu.setFont(new Font("Arial", Font.PLAIN, 25));
		B_menu.setBounds(602, 366, 142, 70);
		p_searchPane.add(B_menu);
	}
	
	private void patientPage(){
		patientPane = new JPanel();
		patientPane.setLayout(null);
		
		JButton B_booking = new JButton("Booking");
		B_booking.setFont(new Font("Arial", Font.PLAIN, 25));
		B_booking.setBounds(101, 384, 190, 100);
		patientPane.add(B_booking);
		
		JButton B_treatment = new JButton("Treatment");
		B_treatment.setFont(new Font("Arial", Font.PLAIN, 25));
		B_treatment.setBounds(392, 384, 190, 100);
		patientPane.add(B_treatment);
		
		JButton button_1 = new JButton("New button");
		button_1.setFont(new Font("Arial", Font.PLAIN, 25));
		button_1.setBounds(683, 384, 190, 100);
		patientPane.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setFont(new Font("Arial", Font.PLAIN, 25));
		button_2.setBounds(101, 506, 190, 100);
		patientPane.add(button_2);
		
		JButton B_log = new JButton("Log");
		B_log.setFont(new Font("Arial", Font.PLAIN, 25));
		B_log.setBounds(392, 506, 190, 100);
		patientPane.add(B_log);
		
		JButton B_menu = new JButton("Menu");
		B_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Menu");
			}
		});
		B_menu.setFont(new Font("Arial", Font.PLAIN, 25));
		B_menu.setBounds(683, 506, 190, 100);
		patientPane.add(B_menu);
		
		JLabel lbl_patient = new JLabel("Patient");
		lbl_patient.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_patient.setFont(new Font("Arial", Font.PLAIN, 25));
		lbl_patient.setBounds(158, 167, 282, 42);
		menuPane.add(lbl_patient);
		
		JLabel lbl_menu = new JLabel("Menu");
		lbl_menu.setFont(new Font("Arial", Font.PLAIN, 30));
		lbl_menu.setBounds(445, 20, 83, 56);
		menuPane.add(lbl_menu);
		
		JPanel color1 = new JPanel();
		color1.setBackground(new Color(245, 222, 179));
		color1.setBounds(25, 85, 924, 270);
		patientPane.add(color1);
		color1.setLayout(null);
		
		JLabel label_1 = new JLabel("Date of Birth:");
		label_1.setBounds(36, 194, 133, 32);
		color1.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Arial", Font.PLAIN, 20));
		final JTextField T_dob = new JTextField();
		T_dob.setBounds(179, 194, 133, 32);
		color1.add(T_dob);
		
		T_dob.setFont(new Font("Arial", Font.PLAIN, 20));
		T_dob.setColumns(10);
		
		JLabel lblHkid = new JLabel("HKID:");
		lblHkid.setBounds(36, 112, 133, 32);
		color1.add(lblHkid);
		lblHkid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHkid.setFont(new Font("Arial", Font.PLAIN, 20));
		final JTextField T_HKID = new JTextField();
		T_HKID.setBounds(179, 112, 133, 32);
		color1.add(T_HKID);
		
		T_HKID.setFont(new Font("Arial", Font.PLAIN, 20));
		T_HKID.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(322, 112, 133, 32);
		color1.add(lblGender);
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("Arial", Font.PLAIN, 20));
		final JTextField T_gender = new JTextField();
		T_gender.setBounds(465, 112, 133, 32);
		color1.add(T_gender);
		
		T_gender.setFont(new Font("Arial", Font.PLAIN, 20));
		T_gender.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(36, 30, 133, 32);
		color1.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Arial", Font.PLAIN, 20));
		final JTextField T_name = new JTextField();
		T_name.setBounds(179, 30, 419, 32);
		color1.add(T_name);
		
		T_name.setFont(new Font("Arial", Font.PLAIN, 20));
		T_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Patient");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(436, 20, 102, 41);
		patientPane.add(lblNewLabel_1);
		p_searchPage();
		contentPane.add(p_searchPane, "P_search");
		
		JButton B_save = new JButton("Save");
		B_save.setBounds(673, 216, 98, 32);
		color1.add(B_save);
		B_save.addActionListener(new ActionListener() {
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
		B_save.setFont(new Font("Arial", Font.PLAIN, 20));

		JButton B_update = new JButton("Update");
		B_update.setBounds(801, 216, 98, 32);
		color1.add(B_update);
		B_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				T_name.setEditable(true);
				T_HKID.setEditable(true);
				T_gender.setEditable(true);
				T_dob.setEditable(true);
			}
		});
		B_update.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//after search patient, get and show the patient record
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
		contentPane.add(p_searchPane, "Search");
		
		cardLayout.show(contentPane, "Login");
	}
}
