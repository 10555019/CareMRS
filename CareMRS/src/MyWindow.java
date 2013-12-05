import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

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
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class MyWindow extends JFrame implements Serializable{

	
	//**********Data Member of MyWindow**********//
	//Database Variables
	private Db db;
	private LoginAccount loginAccount;
	private String filePath = "db.sav";
	
	//MaskFormatter
	private MaskFormatter idFormatter = new MaskFormatter("U######'(#')");
	private MaskFormatter telFormatter = new MaskFormatter("####' ####");
	private MaskFormatter dateFormatter = new MaskFormatter("##'/##'/####");
	
	//Login Page
	private JTextField L_userNameField = new JTextField();
	private JPasswordField L_passwordField = new JPasswordField();
	
	//Patient Search Page
	private JFormattedTextField SPT_HKID = new JFormattedTextField(idFormatter);
	
	//Patient Page
	private JTextField PT_name = new JTextField();
	private JTextField PT_gender = new JTextField();
	private JFormattedTextField PT_HKID = new JFormattedTextField(idFormatter);
	private JFormattedTextField PT_dob = new JFormattedTextField(dateFormatter);
	private JFormattedTextField PT_tel = new JFormattedTextField(telFormatter);
	private JButton PB_update = new JButton("Update");
	private JButton PB_save = new JButton("Save");	
	
	//Patient Booking Page
	private JFormattedTextField PBT_date = new JFormattedTextField(dateFormatter);
	
	//Clinic
	private JTextField SCT_p50;
	private JTextField SCT_p18;
	private JTextField SCT_np;
	private JTextField MTT_treat;
	private JTextField MTT_fpp;
	private JCheckBox MTC_bp;
	private JTable MTTa_table;
	
	//Mode variables
	private int mode=0; //1:doctor 2:admin
	private boolean saveStatus = false;
	
	//Window Panels
	private JPanel color1;
	private JPanel contentPane;
	private JPanel loginPane;
	private JPanel menuPane;
	private JPanel p_searchPane;
	private JPanel patientPane;
	private JPanel p_bookingPane;
	private JPanel clinicPane;
	private JPanel c_SCPane;
	private JPanel c_MTPane;
	private JPanel c_OHPane;
	private JPanel timetablePane;

	//Card Layout
	CardLayout cardLayout = new CardLayout(); //cardLayout, used for different panel

	//Menu Bar
	private JMenuBar menubar = new JMenuBar(); //top menu bar (not shown on login page)

	private Patient patient = null; //pointer pointing accessing which patient 
	//**********Data Member of MyWindow**********//
	

	private void menubar(){
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
				logout();
			}
		}
		logout.addActionListener(new exitaction());
	}

	//Login method
	private void login(String userName, char[] password){
		
		//load login information
		File file = new File(filePath);
		if (!file.exists()){
			//first time use
			Admin admin = new Admin("Superusr","user","user");
			loginAccount.addAdmin(admin);
		} else{
			//read loginAccount information
			loginAccount = loginAccount.load(loginAccount);
		}
		
		if ((mode = Doctor.checkLogin(db,loginAccount,userName,password))!=0){
			//when password match, saved mode : 1:Doctor 2:admin
			db = db.load(db);
			cardLayout.show(contentPane, "Menu"); //change panel
			setJMenuBar(menubar); //show the menu bar
		}
		else
			JOptionPane.showMessageDialog(null, "Please retry","Login Failed", JOptionPane.ERROR_MESSAGE); //password not patch, show error message box
	}

	//Logout method
	private void logout(){
		db.save(); //save data in db
		loginAccount.save();
		cardLayout.show(contentPane, "Login");
		setJMenuBar(null); //disable the menubar when logout
	}
	
	
	//**********************************************************************
	//******************************Login Page******************************
	//**********************************************************************
	private void loginPage(){
		loginPane = new JPanel();
		loginPane.setBackground(SystemColor.activeCaption);
		loginPane.setLayout(null);
		
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
				login(L_userNameField.getText(),L_passwordField.getPassword());
				L_userNameField.setText(null);
				L_passwordField.setText(null);
			}
		});
		B_login.setFont(new Font("Arial", Font.PLAIN, 20));
		B_login.setBounds(327, 452, 110, 60);
		loginPane.add(B_login);
		//Button, Exit
		JButton B_exit = new JButton("Exit");
		B_exit.setBackground(new Color(255, 192, 203));
		B_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		B_exit.setFont(new Font("Arial", Font.PLAIN, 20));
		B_exit.setBounds(547, 452, 110, 60);
		loginPane.add(B_exit);
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
	private void menuPage(){
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
		B_new.setHorizontalAlignment(SwingConstants.LEFT);
		B_new.setIcon(new ImageIcon(getClass().getResource("plus.png")));
		B_new.setBackground(new Color(245, 222, 179));
		B_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patient = null;
				try {
					patientPage();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				PB_update.setEnabled(false);
				PB_save.setEnabled(true);
				cardLayout.show(contentPane, "Patient");
			}
		});
		B_new.setFont(new Font("Arial", Font.PLAIN, 25));
		B_new.setBounds(158, 219, 118, 56);
		menuPane.add(B_new);

		//*****Patient_Search*****
		JButton B_search = new JButton("Search");
		B_search.setHorizontalAlignment(SwingConstants.LEFT);
		B_search.setIcon(new ImageIcon(getClass().getResource("search.png")));
		B_search.setBackground(new Color(245, 222, 179));
		B_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Search");
			}
		});
		B_search.setFont(new Font("Arial", Font.PLAIN, 25));
		B_search.setBounds(286, 219, 154, 56);
		menuPane.add(B_search);

		//*****Clinic*****
		JButton B_clinic = new JButton("Clinic");
		B_clinic.setIcon(new ImageIcon(getClass().getResource("setup.png")));
		B_clinic.setBackground(new Color(152, 251, 152));
		B_clinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Clinic");
			}
		});
		B_clinic.setFont(new Font("Arial", Font.PLAIN, 25));
		B_clinic.setBounds(158, 352, 282, 108);
		menuPane.add(B_clinic);

		//*****My Timetable*****
		JButton B_myTimetable = new JButton("My Timetable");
		B_myTimetable.setIcon(new ImageIcon(getClass().getResource("timetable.png")));
		B_myTimetable.setBackground(new Color(224, 255, 255));
		B_myTimetable.setFont(new Font("Arial", Font.PLAIN, 25));
		B_myTimetable.setBounds(537, 167, 282, 108);
		menuPane.add(B_myTimetable);

		//*****Log out*****
		JButton B_logOut = new JButton("Log out");
		B_logOut.setIcon(new ImageIcon(getClass().getResource("logout.png")));
		B_logOut.setBackground(new Color(255, 192, 203));
		B_logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logout();
			}
		});
		B_logOut.setFont(new Font("Arial", Font.PLAIN, 25));
		B_logOut.setBounds(537, 352, 282, 108);
		menuPane.add(B_logOut);
	}
	//*********************************************************************
	//******************************Menu Page******************************
	//*********************************************************************

	
	//*******************************************************************************
	//******************************Patient Search Page******************************
	//*******************************************************************************
	private void p_searchPage(){
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
				SPT_HKID.setValue(null);
			}
		});
		B_clear.setFont(new Font("Arial", Font.PLAIN, 25));
		B_clear.setBounds(416, 366, 142, 70);
		p_searchPane.add(B_clear);
		
		JButton B_search = new JButton("Search");
		B_search.setBackground(new Color(245, 222, 179));
		B_search.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int index = Patient.patientSearch(db, (String) SPT_HKID.getValue());
				if (index > -1){
					patient = db.getPatient(index);
					SPT_HKID.setValue(null);
					PB_save.setEnabled(false);
					PB_update.setEnabled(true);
					cardLayout.show(contentPane, "Patient");
					try {
						patientPage();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				} else if (index == -1){
					JOptionPane.showMessageDialog(null, "Patient cannot be found.","Search", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		B_search.setFont(new Font("Arial", Font.PLAIN, 25));
		B_search.setBounds(230, 366, 142, 70);
		p_searchPane.add(B_search);
		
		JButton B_menu = new JButton("Menu");
		B_menu.setBackground(new Color(255, 192, 203));
		B_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SPT_HKID.setValue(null);
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
	private void patientPage() throws ParseException{
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

		//*****action button*****
		JButton B_booking = new JButton("Booking");
		B_booking.setHorizontalAlignment(SwingConstants.LEFT);
		B_booking.setIcon(new ImageIcon(getClass().getResource("booking.png")));
		B_booking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saveStatus)
					cardLayout.show(contentPane, "Booking");
				else
					JOptionPane.showMessageDialog(null, "Please save the patient information first.","Patient", JOptionPane.ERROR_MESSAGE);
			}
		});
		B_booking.setFont(new Font("Arial", Font.PLAIN, 25));
		B_booking.setBounds(201, 384, 190, 100);
		patientPane.add(B_booking);

		JButton B_treatment = new JButton("Treatment");
		B_treatment.setHorizontalAlignment(SwingConstants.LEFT);
		B_treatment.setIcon(new ImageIcon(getClass().getResource("treatment.png")));
		B_treatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (saveStatus)
					;//cardLayout.show(contentPane, "Booking");
				else
					JOptionPane.showMessageDialog(null, "Please save the patient information first.","Patient", JOptionPane.ERROR_MESSAGE);
			}
		});
		B_treatment.setFont(new Font("Arial", Font.PLAIN, 25));
		B_treatment.setBounds(592, 384, 190, 100);
		patientPane.add(B_treatment);

		JButton B_log = new JButton("Log");
		B_log.setIcon(new ImageIcon(getClass().getResource("log.png")));
		B_log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saveStatus)
					;//cardLayout.show(contentPane, "Booking");
				else
					JOptionPane.showMessageDialog(null, "Please save the patient information first.","Patient", JOptionPane.ERROR_MESSAGE);
			}
		});
		B_log.setFont(new Font("Arial", Font.PLAIN, 25));
		B_log.setBounds(201, 506, 190, 100);
		patientPane.add(B_log);

		JButton B_menu = new JButton("Menu");
		B_menu.setBackground(new Color(255, 192, 203));
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
				PT_tel.setValue("");
				PT_dob.setValue("");
				PT_HKID.setValue("");
				cardLayout.show(contentPane, "Menu");
			}
		});
		B_menu.setFont(new Font("Arial", Font.PLAIN, 25));
		B_menu.setBounds(592, 506, 190, 100);
		patientPane.add(B_menu);

		//after search patient, get and show the patient record
		if (patient != null){
			PT_name.setText(patient.getName());
			PT_HKID.setValue(patient.getHKID());
			PT_gender.setText(Character.toString(patient.getGender()));
			PT_dob.setValue(patient.getDob_S());
			PT_tel.setValue(patient.getTelephone());
			PT_name.setEditable(false);
			PT_HKID.setEditable(false);
			PT_gender.setEditable(false);
			PT_tel.setEditable(false);
			PT_dob.setEditable(false);
			saveStatus = true;
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
		
		PBT_date.setFont(new Font("Arial", Font.PLAIN, 20));
		PBT_date.setBounds(148, 100, 127, 29);
		p_bookingPane.add(PBT_date);
		
		
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
		btnBackToPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Patient");
			}
		});
		btnBackToPatient.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBackToPatient.setBounds(827, 585, 116, 47);
		p_bookingPane.add(btnBackToPatient);
		
		
	}
	//***********************************************************************
	//***********************Patient booking Page****************************
	//***********************************************************************
	
	
	//***********************************************************************
	//***************************Clinic Page*********************************
	//***********************************************************************
	private void clinicPage(){
		clinicPane = new JPanel();
		clinicPane.setBackground(SystemColor.activeCaption);
		clinicPane.setLayout(null);
		
		JLabel lblClinic = new JLabel("Clinic Setup");
		lblClinic.setHorizontalAlignment(SwingConstants.CENTER);
		lblClinic.setFont(new Font("Arial", Font.BOLD, 30));
		lblClinic.setBounds(399, 20, 185, 47);
		clinicPane.add(lblClinic);
		
		JButton B_MT = new JButton("Medical Treatment");
		B_MT.setBackground(new Color(152, 251, 152));
		B_MT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "c_MT");
			}
		});
		B_MT.setFont(new Font("Arial", Font.PLAIN, 25));
		B_MT.setBounds(537, 167, 282, 108);
		clinicPane.add(B_MT);
		
		JButton B_SC = new JButton("Special Condition");
		B_SC.setBackground(new Color(152, 251, 152));
		B_SC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "c_SC");
			}
		});
		B_SC.setFont(new Font("Arial", Font.PLAIN, 25));
		B_SC.setBounds(158, 352, 282, 108);
		clinicPane.add(B_SC);
		
		JButton B_OH = new JButton("Opening Hour");
		B_OH.setBackground(new Color(152, 251, 152));
		B_OH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "c_OH");
			}
		});
		B_OH.setFont(new Font("Arial", Font.PLAIN, 25));
		B_OH.setBounds(158, 167, 282, 108);
		clinicPane.add(B_OH);
		
		JButton B_M = new JButton("Menu");
		B_M.setBackground(new Color(255, 192, 203));
		B_M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Menu");
			}
		});
		B_M.setFont(new Font("Arial", Font.PLAIN, 25));
		B_M.setBounds(537, 352, 282, 108);
		clinicPane.add(B_M);
		
		
	}
	//***********************************************************************
	//***************************Clinic Page*********************************
	//***********************************************************************
	
	
	//***********************************************************************
	//***************************C SC Page***********************************
	//***********************************************************************
	private void c_SCPage(){
		c_SCPane = new JPanel();
		c_SCPane.setBackground(SystemColor.activeCaption);
		c_SCPane.setLayout(null);
		
		JLabel lbl_SpecialCondition = new JLabel("Special Condition");
		lbl_SpecialCondition.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SpecialCondition.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_SpecialCondition.setBounds(357, 20, 269, 47);
		c_SCPane.add(lbl_SpecialCondition);
		
		JLabel lbl_PatientAtAge50 = new JLabel("Patient at age > 50 :");
		lbl_PatientAtAge50.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_PatientAtAge50.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_PatientAtAge50.setBounds(228, 237, 185, 47);
		c_SCPane.add(lbl_PatientAtAge50);
		
		JLabel lbl_PatientAtAge18 = new JLabel("Patient at age <18 :");
		lbl_PatientAtAge18.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_PatientAtAge18.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_PatientAtAge18.setBounds(228, 307, 185, 47);
		c_SCPane.add(lbl_PatientAtAge18);
		
		JLabel lbl_np = new JLabel("Non-Peak hour :");
		lbl_np.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_np.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_np.setBounds(228, 374, 185, 47);
		c_SCPane.add(lbl_np);
		
		JLabel lbl_Discount = new JLabel("Discount (%)");
		lbl_Discount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Discount.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_Discount.setBounds(458, 160, 143, 47);
		c_SCPane.add(lbl_Discount);
		
		SCT_p50 = new JTextField();
		SCT_p50.setHorizontalAlignment(SwingConstants.CENTER);
		SCT_p50.setFont(new Font("Arial", Font.PLAIN, 20));
		SCT_p50.setBounds(458, 237, 143, 47);
		c_SCPane.add(SCT_p50);
		SCT_p50.setColumns(10);
		
		SCT_p18 = new JTextField();
		SCT_p18.setHorizontalAlignment(SwingConstants.CENTER);
		SCT_p18.setFont(new Font("Arial", Font.PLAIN, 20));
		SCT_p18.setColumns(10);
		SCT_p18.setBounds(458, 307, 143, 47);
		c_SCPane.add(SCT_p18);
		
		SCT_np = new JTextField();
		SCT_np.setHorizontalAlignment(SwingConstants.CENTER);
		SCT_np.setFont(new Font("Arial", Font.PLAIN, 20));
		SCT_np.setColumns(10);
		SCT_np.setBounds(458, 374, 143, 47);
		c_SCPane.add(SCT_np);
		
		JButton SCB_update = new JButton("Update");
		SCB_update.setFont(new Font("Arial", Font.PLAIN, 20));
		SCB_update.setBounds(419, 489, 143, 47);
		c_SCPane.add(SCB_update);
		
		JButton SCB_save = new JButton("Save");
		SCB_save.setFont(new Font("Arial", Font.PLAIN, 20));
		SCB_save.setBounds(138, 489, 143, 47);
		c_SCPane.add(SCB_save);
		
		JButton B_clinic = new JButton("Clinic");
		B_clinic.setFont(new Font("Arial", Font.PLAIN, 20));
		B_clinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Clinic");
			}
		});
		B_clinic.setBackground(new Color(255, 192, 203));
		B_clinic.setBounds(700, 489, 143, 47);
		c_SCPane.add(B_clinic);
	}
	//***********************************************************************
	//***************************C SC Page***********************************
	//***********************************************************************
	
	
	//***********************************************************************
	//***************************C MT Page***********************************
	//***********************************************************************
	private void c_MTPage(){
		c_MTPane = new JPanel();
		c_MTPane.setBackground(SystemColor.activeCaption);
		c_MTPane.setLayout(null);
		
		JLabel lbl_MedicalTreatment = new JLabel("Medical Treatment");
		lbl_MedicalTreatment.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MedicalTreatment.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_MedicalTreatment.setBounds(349, 20, 286, 47);
		c_MTPane.add(lbl_MedicalTreatment);
		
		String[] columns = {"Type of treatment", "Fee ($) per part", "Body parts"};
		
		String[][] data = {{"Herbal", "250", "N/A"},
				{"acupuncture", "350", "Y"},
				{"cupping", "300", "Y"}
				
		
		
		};

		JPanel MTP_pane = new JPanel();
		MTP_pane.setBackground(SystemColor.activeCaption);
		MTP_pane.setBounds(479, 107, 448, 390);
		MTP_pane.setLayout(new FlowLayout());
		c_MTPane.add(MTP_pane);

		MTTa_table = new JTable(data, columns);
		MTTa_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MTTa_table.setFont(new Font("Arial", Font.PLAIN, 18));
		MTTa_table.setBackground(SystemColor.activeCaption);
		MTTa_table.setPreferredScrollableViewportSize(new Dimension(400, 350));
		MTTa_table.setFillsViewportHeight(true);
		
		
		MTTa_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				MTT_treat.setText((String) MTTa_table.getValueAt(MTTa_table.getSelectedRow(),0).toString());
				MTT_fpp.setText((String) MTTa_table.getValueAt(MTTa_table.getSelectedRow(),1).toString());
				if (MTTa_table.getValueAt(MTTa_table.getSelectedRow(),2).toString()=="Y")
					MTC_bp.setSelected(true);
				else
					MTC_bp.setSelected(false);
			}});

		JScrollPane MTjp = new JScrollPane(MTTa_table);
		MTP_pane.add(MTjp);

		
		
		
		JLabel lbl_Treatment = new JLabel("Treatment :");
		lbl_Treatment.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Treatment.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_Treatment.setBounds(63, 131, 112, 47);
		c_MTPane.add(lbl_Treatment);
		
		JLabel lbl_FeePerPart = new JLabel("Fee per part :");
		lbl_FeePerPart.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_FeePerPart.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_FeePerPart.setBounds(40, 237, 137, 47);
		c_MTPane.add(lbl_FeePerPart);
		
		JLabel lbl_BodyParts = new JLabel("Body parts :");
		lbl_BodyParts.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_BodyParts.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_BodyParts.setBounds(40, 350, 137, 47);
		c_MTPane.add(lbl_BodyParts);
		
		MTT_treat = new JTextField();
		MTT_treat.setFont(new Font("Arial", Font.PLAIN, 20));
		MTT_treat.setColumns(10);
		MTT_treat.setBounds(185, 131, 240, 47);
		c_MTPane.add(MTT_treat);
		
		MTT_fpp = new JTextField();
		MTT_fpp.setFont(new Font("Arial", Font.PLAIN, 20));
		MTT_fpp.setColumns(10);
		MTT_fpp.setBounds(187, 237, 238, 47);
		c_MTPane.add(MTT_fpp);
		
		MTC_bp = new JCheckBox("");
		MTC_bp.setBackground(SystemColor.activeCaption);
		MTC_bp.setHorizontalAlignment(SwingConstants.CENTER);
		MTC_bp.setBounds(187, 350, 240, 47);
		c_MTPane.add(MTC_bp);
		
		JButton B_save = new JButton("Save");
		B_save.setFont(new Font("Arial", Font.PLAIN, 20));
		B_save.setBounds(63, 548, 143, 47);
		c_MTPane.add(B_save);
		
		JButton B_clinic = new JButton("Clinic");
		B_clinic.setFont(new Font("Arial", Font.PLAIN, 20));
		B_clinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Clinic");
			}
		});
		B_clinic.setBackground(new Color(255, 192, 203));
		B_clinic.setBounds(797, 576, 143, 47);
		c_MTPane.add(B_clinic);
		
		JButton B_new = new JButton("New");
		B_new.setFont(new Font("Arial", Font.PLAIN, 20));
		B_new.setBounds(232, 548, 143, 47);
		c_MTPane.add(B_new);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDelete.setBounds(405, 548, 143, 47);
		c_MTPane.add(btnDelete);
		c_OHPage();
		contentPane.add(c_OHPane, "c_OH");
	}
	//***********************************************************************
	//***************************C MT Page***********************************
	//***********************************************************************
	
	
	//***********************************************************************
	//***************************C OH Page***********************************
	//***********************************************************************
	private void c_OHPage(){
		c_OHPane = new JPanel();
		c_OHPane.setBackground(SystemColor.activeCaption);
		c_OHPane.setLayout(null);
	}
	//***********************************************************************
	//***************************C OH Page***********************************
	//***********************************************************************
	
	private void timetablePage(){
		timetablePane = new JPanel();
		timetablePane.setBackground(SystemColor.activeCaption);
		timetablePane.setLayout(null);
		
	}
	
	
	//*******************Construct Label and Button**************************
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
		
		//TextField, for user to type user name
		L_userNameField.setFont(new Font("Arial", Font.PLAIN, 20));
		L_userNameField.setBounds(439, 265, 253, 30);
		loginPane.add(L_userNameField);
		L_userNameField.setColumns(10);
		//PasswordField, for user to type password
		L_passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == KeyEvent.VK_ENTER) { //when user press Enter key after typing password
					login(L_userNameField.getText(),L_passwordField.getPassword());
					L_userNameField.setText(null);
					L_passwordField.setText(null);
				}
			}
		});
		L_passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		L_passwordField.setBounds(439, 342, 253, 30);
		loginPane.add(L_passwordField);
		
		//Patient page button
		//B_save
		PB_save.setBounds(693, 227, 98, 32);
		color1.add(PB_save);
		PB_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ //Saving or creating patient record
					if (PT_HKID.getValue() == null) throw new NullFieldException(); //primary key should not be null
					int index = Patient.patientSearch(db, (String) PT_HKID.getValue());
					boolean save = false; //used to toggle save message
					if (patient==null){
						//need to create a new patient
						if (index == -1){
							patient = new Patient(PT_name.getText(),(String)PT_HKID.getValue(),(String)PT_tel.getValue(),PT_gender.getText().charAt(0),(String)PT_dob.getValue());
							db.addPatient(patient);
							save = true;
						} else{
							if (JOptionPane.showConfirmDialog(null, "Same patient found, amend record?","Patient record", JOptionPane.YES_NO_OPTION)==1){
								patient = new Patient(PT_name.getText(),(String)PT_HKID.getValue(),(String)PT_tel.getValue(),PT_gender.getText().charAt(0),(String)PT_dob.getValue());
								//patient = new Patient(PT_name.getText(),PT_HKID.getText(),PT_tel.getText(),PT_gender.getText().charAt(0),PT_dob.getText());
								db.addPatient(patient);
								save = true;
							} else {
								JOptionPane.showMessageDialog(null, "Original Patient record will be shown","Patient record", JOptionPane.PLAIN_MESSAGE);
								patient = db.getPatient(index);
								PT_name.setText(patient.getName());
								PT_HKID.setValue(patient.getHKID());
								PT_gender.setText(Character.toString(patient.getGender()));
								PT_dob.setValue(patient.getDob_S());
							}
						}
					} else {
						//amend current patient record
						db.getPatient(index).setName(PT_name.getText());
						db.getPatient(index).setTelephone((String)PT_tel.getValue());
						db.getPatient(index).setGender(PT_gender.getText().charAt(0));
						db.getPatient(index).setDob((String)PT_dob.getValue());
						save = true;
					}
					if (save)
						JOptionPane.showMessageDialog(null, "Patient records have been saved","Patient record", JOptionPane.PLAIN_MESSAGE);
					PT_name.setEditable(false);
					PT_HKID.setEditable(false);
					PT_gender.setEditable(false);
					PT_tel.setEditable(false);
					PT_dob.setEditable(false);
					PB_save.setEnabled(false);
					PB_update.setEnabled(true);
				} catch (NullFieldException e1){
					e1.error();
				} 
			}
		});
		PB_save.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//B_update
		PB_update.setBounds(816, 227, 98, 32);
		color1.add(PB_update);
		PB_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//**HKID cannot be changed**
				saveStatus = false;
				PT_name.setEditable(true);
				PT_gender.setEditable(true);
				PT_tel.setEditable(true);
				PT_dob.setEditable(true);
				PB_update.setEnabled(false);
				PB_save.setEnabled(true);
			}
		});
		PB_update.setFont(new Font("Arial", Font.PLAIN, 20));

	}
	//*******************Construct Label and Button**************************

	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public MyWindow(Db db, LoginAccount loginAccount) throws ParseException {
		this.db = db;
		this.loginAccount = loginAccount;
		String filePath = "dat.sav";
		setResizable(false);
		setTitle("CareMRS");
		setIconImage(new ImageIcon(getClass().getResource("C.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		menubar();
		loginPage();
		contentPane.add(loginPane, "Login");
		menuPage();
		contentPane.add(menuPane, "Menu");
		p_searchPage();
		contentPane.add(p_searchPane, "Search");
		patientPage();
		addToWindow();
		contentPane.add(patientPane, "Patient");
		p_bookingPage();
		contentPane.add(p_bookingPane, "Booking");
		clinicPage();
		contentPane.add(clinicPane, "Clinic");
		c_SCPage();
		contentPane.add(c_SCPane, "c_SC");
		c_MTPage();
		contentPane.add(c_MTPane, "c_MT");
		timetablePage();
		contentPane.add(timetablePane, "Timetable");
		
		JLabel lbl_OpeningHour = new JLabel("Opening Hour");
		lbl_OpeningHour.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_OpeningHour.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_OpeningHour.setBounds(372, 20, 240, 47);
		c_OHPane.add(lbl_OpeningHour);
		
		JButton B_clinic = new JButton("Clinic");
		B_clinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Clinic");
			}
		});
		B_clinic.setFont(new Font("Arial", Font.PLAIN, 20));
		B_clinic.setBackground(new Color(255, 192, 203));
		B_clinic.setBounds(420, 307, 143, 47);
		c_OHPane.add(B_clinic);
		
		login("user","user".toCharArray()); //temp login
		cardLayout.show(contentPane, "Menu");
	}
}
