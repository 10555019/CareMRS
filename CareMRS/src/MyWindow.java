import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JList;


public class MyWindow extends JFrame implements Serializable{

	//**********Data Member of MyWindow**********//
	
	private MaskFormatter idFormatter = new MaskFormatter("U######'(#')");
	private MaskFormatter telFormatter = new MaskFormatter("####' ####");
	private MaskFormatter dateFormatter = new MaskFormatter("##'/##'/####");
	
	private JTextField PT_name = new JTextField();
	private JFormattedTextField PT_HKID = new JFormattedTextField(idFormatter);
	private JTextField PT_gender = new JTextField();
	private JFormattedTextField PT_dob = new JFormattedTextField(dateFormatter);
	private JFormattedTextField PT_tel = new JFormattedTextField(telFormatter);
	
	
	private JFormattedTextField SPT_HKID = new JFormattedTextField(idFormatter);
	
	
	
	int mode=0; //1:doctor 2:admin
	
	private String filePath = "db.sav";
	
	private JPanel color1;
	private JPanel contentPane;
	private JPanel loginPane;
	private JPanel menuPane;
	private JPanel p_searchPane;
	private JPanel patientPane;
	private JPanel p_bookingPane;

	CardLayout cardLayout = new CardLayout(); //cardLayout, used for different panel

	private JMenuBar menubar = new JMenuBar(); //top menu bar (not shown on login page)

	private Patient patient = null; //pointer pointing accessing which patient 
	//**********Data Member of MyWindow**********//

	private void menubar(final Db db){
		//construct the menubar
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
				logout(db);
			}
		}
		logout.addActionListener(new exitaction());
	}

	//Login method
	private void login(Db db, String userName, char[] password){
		
		//temp record for testing..........
		db.addPatient(new Patient("Chan","A000001(1)","12345678",'M',"01/01/2013"));
		//temp record for testing..........
		
		if ((mode = Doctor.checkLogin(db,userName,password))!=0){ //when password match, saved mode : 1:Doctor 2:admin
			db = db.load(); //load data from file
			cardLayout.show(contentPane, "Menu"); //change panel
			setJMenuBar(menubar); //show the menu bar
		}
		else
			JOptionPane.showMessageDialog(null, "Please retry","Login Failed", JOptionPane.ERROR_MESSAGE); //password not patch, show error message box
	}

	//Logout method
	private void logout(Db db){
		db.save(db); //save data in db
		cardLayout.show(contentPane, "Login");
		setJMenuBar(null); //disable the menubar when logout
	}
	
	
	//**********************************************************************
	//******************************Login Page******************************
	//**********************************************************************
	private void loginPage(final Db db){
		loginPane = new JPanel();
		loginPane.setBackground(SystemColor.activeCaption);
		loginPane.setLayout(null);
		
		final JTextField userNameField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();
		//Title Image, CareMRS
		ImageIcon image_title;
		JLabel label1;
		image_title = new ImageIcon(getClass().getResource("CareMRS.png"));
		label1 = new JLabel(image_title);
		label1.setBounds(51,32,871,196);
		loginPane.add(label1);
		//Button, Login
		JButton B_login = new JButton("Login");
		B_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userNameField.setText(null);
				passwordField.setText(null);
				login(db,userNameField.getText(),passwordField.getPassword());
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
		//TextField, for user to type user name
		userNameField.setFont(new Font("Arial", Font.PLAIN, 20));
		userNameField.setBounds(439, 265, 253, 30);
		loginPane.add(userNameField);
		userNameField.setColumns(10);
		//PasswordField, for user to type password
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == KeyEvent.VK_ENTER) { //when user press Enter key after typing password
					userNameField.setText(null);
					passwordField.setText(null);
					login(db,userNameField.getText(),passwordField.getPassword());
				}
			}
		});
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField.setBounds(439, 342, 253, 30);
		loginPane.add(passwordField);
		//Label, User name
		JLabel lblNewLabel = new JLabel("User Name :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(285, 265, 120, 30);
		loginPane.add(lblNewLabel);
		//Label, Password
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(285, 342, 120, 30);
		loginPane.add(lblPassword);
	}
	//**********************************************************************
	//******************************Login Page******************************
	//**********************************************************************
	
	
	//*********************************************************************
	//******************************Menu Page******************************
	//*********************************************************************
	private void menuPage(final Db db){
		menuPane = new JPanel();
		menuPane.setBackground(SystemColor.activeCaption);
		menuPane.setLayout(null);

		//*****head label*****
		JLabel lbl_menu = new JLabel("Menu");
		lbl_menu.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_menu.setBounds(445, 20, 83, 56);
		menuPane.add(lbl_menu);

		//*****patient label*****
		JLabel lbl_patient = new JLabel("Patient");
		lbl_patient.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_patient.setFont(new Font("Arial", Font.PLAIN, 25));
		lbl_patient.setBounds(158, 167, 282, 42);
		menuPane.add(lbl_patient);

		//*****Patient_New*****
		JButton B_new = new JButton("New");
		B_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patient = null;
				try {
					patientPage(db);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				cardLayout.show(contentPane, "Patient");
			}
		});
		B_new.setFont(new Font("Arial", Font.PLAIN, 25));
		B_new.setBounds(158, 219, 136, 56);
		menuPane.add(B_new);

		//*****Patient_Search*****
		JButton B_search = new JButton("Search");
		B_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Search");
			}
		});
		B_search.setFont(new Font("Arial", Font.PLAIN, 25));
		B_search.setBounds(304, 219, 136, 56);
		menuPane.add(B_search);

		//*****Clinic*****
		JButton B_clinic = new JButton("Clinic");
		B_clinic.setFont(new Font("Arial", Font.PLAIN, 25));
		B_clinic.setBounds(158, 352, 282, 108);
		menuPane.add(B_clinic);

		//*****My Timetable*****
		JButton B_myTimetable = new JButton("My Timetable");
		B_myTimetable.setFont(new Font("Arial", Font.PLAIN, 25));
		B_myTimetable.setBounds(537, 167, 282, 108);
		menuPane.add(B_myTimetable);

		//*****Log out*****
		JButton lbl_logOut = new JButton("Log out");
		lbl_logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logout(db);
			}
		});
		lbl_logOut.setFont(new Font("Arial", Font.PLAIN, 25));
		lbl_logOut.setBounds(537, 352, 282, 108);
		menuPane.add(lbl_logOut);
	}
	//*********************************************************************
	//******************************Menu Page******************************
	//*********************************************************************

	
	//*******************************************************************************
	//******************************Patient Search Page******************************
	//*******************************************************************************
	private void p_searchPage(final Db db){
		p_searchPane = new JPanel();
		p_searchPane.setBackground(SystemColor.activeCaption);
		p_searchPane.setLayout(null);
		
		JLabel lbl_searchPatient = new JLabel("Search Patient");
		lbl_searchPatient.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_searchPatient.setBounds(376, 20, 221, 41);
		p_searchPane.add(lbl_searchPatient);
		JLabel lbl_HKID = new JLabel("HKID:");
		lbl_HKID.setFont(new Font("Arial", Font.PLAIN, 25));
		lbl_HKID.setBounds(343, 253, 80, 41);
		p_searchPane.add(lbl_HKID);
		
		JButton B_clear = new JButton("Clear");
		B_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SPT_HKID.setText(null);
			}
		});
		B_clear.setFont(new Font("Arial", Font.PLAIN, 25));
		B_clear.setBounds(416, 366, 142, 70);
		p_searchPane.add(B_clear);
		
		JButton B_search = new JButton("Search");
		B_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Patient.patientSearch(db, SPT_HKID.getText());
				if (index != -1){
					patient = db.getPatient(index);
					SPT_HKID.setText(null);
					cardLayout.show(contentPane, "Patient");
					try {
						patientPage(db);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				} else{
					JOptionPane.showMessageDialog(null, "Patient cannot be found.","Search", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		B_search.setFont(new Font("Arial", Font.PLAIN, 25));
		B_search.setBounds(230, 366, 142, 70);
		p_searchPane.add(B_search);
		
		JButton B_menu = new JButton("Menu");
		B_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SPT_HKID.setText(null);
				cardLayout.show(contentPane, "Menu");
			}
		});
		B_menu.setFont(new Font("Arial", Font.PLAIN, 25));
		B_menu.setBounds(602, 366, 142, 70);
		p_searchPane.add(B_menu);
	}
	//*******************************************************************************
	//******************************Patient Search Page******************************
	//*******************************************************************************

	
	//************************************************************************
	//******************************Patient Page******************************
	//************************************************************************
	private void patientPage(final Db db) throws ParseException{
		patientPane = new JPanel();
		patientPane.setBackground(SystemColor.activeCaption);
		patientPane.setLayout(null);

		//*****Head Label*****
		JLabel lbl_patient = new JLabel("Patient");
		lbl_patient.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_patient.setBounds(436, 20, 102, 41);
		patientPane.add(lbl_patient);

		//Upper frame
		color1 = new JPanel();
		color1.setBackground(new Color(245, 222, 179));
		color1.setBounds(25, 85, 924, 270);
		patientPane.add(color1);
		color1.setLayout(null);

		//*****Name*****
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setBounds(36, 30, 133, 32);
		color1.add(lbl_name);
		lbl_name.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_name.setFont(new Font("Arial", Font.PLAIN, 20));

		//*****HKID*****
		JLabel lbl_HKID = new JLabel("HKID:");
		lbl_HKID.setBounds(36, 112, 133, 32);
		color1.add(lbl_HKID);
		lbl_HKID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_HKID.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		

		//*****Gender*****
		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setBounds(373, 112, 133, 32);
		color1.add(lbl_gender);
		lbl_gender.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_gender.setFont(new Font("Arial", Font.PLAIN, 20));

		
		

		//*****DOB*****
		//upper label
		JLabel lbl_dob = new JLabel("Date of Birth:");
		lbl_dob.setBounds(36, 194, 133, 32);
		color1.add(lbl_dob);
		lbl_dob.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_dob.setFont(new Font("Arial", Font.PLAIN, 20));
		//lower label
		JLabel lbl_dmy = new JLabel("(dd/mm/yyyy)");
		lbl_dmy.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_dmy.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_dmy.setBounds(36, 216, 133, 32);
		color1.add(lbl_dmy);

		
		

		//*****Tel*****
		JLabel lbl_tel = new JLabel("Telephone:");
		lbl_tel.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tel.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_tel.setBounds(373, 194, 133, 32);
		color1.add(lbl_tel);

		
		

		//*****B_save*****
		JButton B_save = new JButton("Save");
		B_save.setBounds(693, 227, 98, 32);
		color1.add(B_save);
		B_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ //Saving or creating patient record
					int index = Patient.patientSearch(db, PT_HKID.getText());
					boolean save = false; //used to toggle save message
					if (PT_HKID.getText().equals("       ( )")) throw new NullFieldException(); //primary key should not be null
					if (patient==null){
						//need to create a new patient
						if (index == -1){
							patient = new Patient(PT_name.getText(),PT_HKID.getText(),PT_tel.getText(),PT_gender.getText().charAt(0),PT_dob.getText());
							db.addPatient(patient);
							save = true;
						} else{
							if (JOptionPane.showConfirmDialog(null, "Same patient found, amend record?","Patient record", JOptionPane.YES_NO_OPTION)==1){
								patient = new Patient(PT_name.getText(),PT_HKID.getText(),PT_tel.getText(),PT_gender.getText().charAt(0),PT_dob.getText());
								db.addPatient(patient);
								save = true;
							} else {
								JOptionPane.showMessageDialog(null, "Original Patient record will be shown","Patient record", JOptionPane.PLAIN_MESSAGE);
								patient = db.getPatient(index);
								PT_name.setText(patient.getName());
								PT_HKID.setText(patient.getHKID());
								PT_gender.setText(Character.toString(patient.getGender()));
								PT_dob.setText(patient.getDob_S());
							}
						}
					} else {
						//amend current patient record
						db.getPatient(index).setName(PT_name.getText());
						db.getPatient(index).setTelephone(PT_tel.getText());
						db.getPatient(index).setGender(PT_gender.getText().charAt(0));
						db.getPatient(index).setDob(PT_dob.getText());
						save = true;
					}
					if (save)
						JOptionPane.showMessageDialog(null, "Patient records have been saved","Patient record", JOptionPane.PLAIN_MESSAGE);
					PT_name.setEditable(false);
					PT_HKID.setEditable(false);
					PT_gender.setEditable(false);
					PT_tel.setEditable(false);
					PT_dob.setEditable(false);
				} catch (NullFieldException e1){
					e1.error();
				}
			}
		});
		B_save.setFont(new Font("Arial", Font.PLAIN, 20));

		//*****B_update*****
		JButton B_update = new JButton("Update");
		B_update.setBounds(816, 227, 98, 32);
		color1.add(B_update);
		B_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//**HKID cannot be changed**
				PT_name.setEditable(true);
				PT_gender.setEditable(true);
				PT_tel.setEditable(true);
				PT_dob.setEditable(true);
			}
		});
		B_update.setFont(new Font("Arial", Font.PLAIN, 20));

		//*****action button*****
		JButton B_booking = new JButton("Booking");
		B_booking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Booking");
			}
		});
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
				patient = null;
				PT_name.setEditable(true);
				PT_gender.setEditable(true);
				PT_tel.setEditable(true);
				PT_dob.setEditable(true);
				PT_HKID.setEditable(true);
				PT_name.setText("");
				PT_gender.setText("");
				PT_tel.setText("");
				PT_dob.setText("");
				PT_HKID.setText("");
				cardLayout.show(contentPane, "Menu");
			}
		});
		B_menu.setFont(new Font("Arial", Font.PLAIN, 25));
		B_menu.setBounds(683, 506, 190, 100);
		patientPane.add(B_menu);

		//after search patient, get and show the patient record
		if (patient != null){
			PT_name.setText(patient.getName());
			PT_HKID.setText(patient.getHKID());
			PT_gender.setText(Character.toString(patient.getGender()));
			PT_dob.setText(patient.getDob_S());
			PT_tel.setText(patient.getTelephone());
			PT_name.setEditable(false);
			PT_HKID.setEditable(false);
			PT_gender.setEditable(false);
			PT_tel.setEditable(false);
			PT_dob.setEditable(false);
		}

	}
	//************************************************************************
	//******************************Patient Page******************************
	//************************************************************************

	
	//***********************************************************************
	//***********************Patient booking Page****************************
	//***********************************************************************
	private void p_bookingPage(){
		p_bookingPane = new JPanel();
		p_bookingPane.setBackground(SystemColor.activeCaption);
		p_bookingPane.setLayout(null);
		
		JLabel lbl_Booking = new JLabel("Booking");
		lbl_Booking.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_Booking.setBounds(428, 20, 127, 47);
		p_bookingPane.add(lbl_Booking);
		
		JLabel lbl_date = new JLabel("Date:");
		lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_date.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_date.setBounds(81, 103, 57, 24);
		p_bookingPane.add(lbl_date);
		
		JLabel lbl_doctor = new JLabel("Doctor:");
		lbl_doctor.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_doctor.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_doctor.setBounds(69, 156, 71, 24);
		p_bookingPane.add(lbl_doctor);
		
		JButton B_update = new JButton("update");
		B_update.setFont(new Font("Arial", Font.PLAIN, 20));
		B_update.setBounds(428, 138, 101, 47);
		p_bookingPane.add(B_update);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		formattedTextField.setBounds(148, 100, 127, 29);
		p_bookingPane.add(formattedTextField);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setBounds(150, 156, 206, 24);
		p_bookingPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("10:00     11:00     12:00     15:00     16:00     17:00     18:00     19:00");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(81, 213, 620, 29);
		p_bookingPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("    -            -            -            -            -             -            -            -");
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setBounds(81, 237, 620, 29);
		p_bookingPane.add(label);
		
		JLabel label_1 = new JLabel("11:00     12:00     13:00     16:00     17:00     18:00     19:00     20:00");
		label_1.setFont(new Font("Arial", Font.PLAIN, 20));
		label_1.setBounds(81, 263, 620, 29);
		p_bookingPane.add(label_1);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBackground(SystemColor.activeCaption);
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton.setFont(new Font("·s²Ó©úÅé", Font.PLAIN, 20));
		radioButton.setBounds(75, 288, 60, 50);
		p_bookingPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBackground(SystemColor.activeCaption);
		radioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_1.setBounds(155, 288, 60, 50);
		p_bookingPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBackground(SystemColor.activeCaption);
		radioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_2.setBounds(233, 288, 60, 50);
		p_bookingPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBackground(SystemColor.activeCaption);
		radioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_3.setBounds(314, 288, 60, 50);
		p_bookingPane.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBackground(SystemColor.activeCaption);
		radioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_4.setBounds(393, 288, 60, 50);
		p_bookingPane.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBackground(SystemColor.activeCaption);
		radioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_5.setBounds(474, 288, 60, 50);
		p_bookingPane.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("");
		radioButton_6.setBackground(SystemColor.activeCaption);
		radioButton_6.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_6.setBounds(556, 288, 60, 50);
		p_bookingPane.add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("");
		radioButton_7.setBackground(SystemColor.activeCaption);
		radioButton_7.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_7.setBounds(634, 288, 60, 50);
		p_bookingPane.add(radioButton_7);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radioButton);
		radioGroup.add(radioButton_1);
		radioGroup.add(radioButton_2);
		radioGroup.add(radioButton_3);
		radioGroup.add(radioButton_4);
		radioGroup.add(radioButton_5);
		radioGroup.add(radioButton_6);
		radioGroup.add(radioButton_7);
		
		JButton B_book = new JButton("Book");
		B_book.setFont(new Font("Arial", Font.PLAIN, 20));
		B_book.setBounds(782, 280, 109, 47);
		p_bookingPane.add(B_book);
		
		JList list = new JList();
		list.setBounds(62, 357, 828, 211);
		p_bookingPane.add(list);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(685, 585, 116, 47);
		p_bookingPane.add(btnNewButton);
		
		JButton btnBackToPatient = new JButton("Patient");
		btnBackToPatient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBackToPatient.setBounds(827, 585, 116, 47);
		p_bookingPane.add(btnBackToPatient);
		
		
	}
	//***********************************************************************
	//***********************Patient booking Page****************************
	//***********************************************************************
	
	private void addToWindow(){
		PT_name.setBounds(179, 30, 501, 32);
		color1.add(PT_name);
		PT_name.setFont(new Font("Arial", Font.PLAIN, 20));
		PT_name.setColumns(10);
		
		PT_HKID.setBounds(179,112,163,32);
		color1.add(PT_HKID);
		PT_HKID.setFont(new Font("Arial", Font.PLAIN, 25));
		PT_HKID.setColumns(10);
		
		PT_gender.setBounds(547, 112, 133, 32);
		color1.add(PT_gender);
		PT_gender.setFont(new Font("Arial", Font.PLAIN, 20));
		PT_gender.setColumns(10);
		
		PT_dob.setFont(new Font("Arial", Font.PLAIN, 25));
		PT_dob.setBounds(179,194,163,32);
		color1.add(PT_dob);
		PT_dob.setColumns(10);
		
		PT_tel.setFont(new Font("Arial", Font.PLAIN, 25));
		PT_tel.setBounds(516,194,164,32);
		color1.add(PT_tel);
		PT_tel.setColumns(10);
		
		SPT_HKID.setFont(new Font("Arial", Font.PLAIN, 25));
		SPT_HKID.setBounds(447, 253, 171, 41);
		p_searchPane.add(SPT_HKID);
		SPT_HKID.setColumns(10);
	}

	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public MyWindow(Db db) throws ParseException {
		setResizable(false);
		setTitle("CareMRS");
		setIconImage(new ImageIcon(getClass().getResource("C.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		menubar(db);
		loginPage(db);
		contentPane.add(loginPane, "Login");
		menuPage(db);
		contentPane.add(menuPane, "Menu");
		p_searchPage(db);
		contentPane.add(p_searchPane, "Search");
		patientPage(db);
		
		
		addToWindow();
		
		
		contentPane.add(patientPane, "Patient");
		p_bookingPage();
		contentPane.add(p_bookingPane, "Booking");

		login(db,"user","user".toCharArray());
		cardLayout.show(contentPane, "Menu");
	}
}
