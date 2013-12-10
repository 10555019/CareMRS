import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
import javax.swing.table.TableColumn;
import javax.swing.JTextPane;
import javax.swing.ListModel;


public class MyWindow extends JFrame implements Serializable{

	
	//**********Data Member of MyWindow**********//
	//Database Variables
	private Db db;
	private LogAc logAc;
	private String filePath = "db.sav";
	
	//MaskFormatter
	private MaskFormatter idFormatter = new MaskFormatter("U######'(A')");
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
	private JButton PB_booking = new JButton("Booking");
	private JButton PB_treatment = new JButton("Treatment");
	private JButton PB_log = new JButton("Log");
	private JButton PB_menu = new JButton("Menu");
	
	//Patient Booking Page
	private JFormattedTextField PBT_date = new JFormattedTextField(dateFormatter);
	private JComboBox<String> PBCB_doctor = new JComboBox<String>();
	private JButton PBB_myTimetable = new JButton("My Timetable");
	private JButton PBB_account = new JButton("Account");
	private JPanel PBP_choose = new JPanel();
	private JPanel PBP_show = new JPanel();
	private DefaultListModel<String> PBL_choose_model = new DefaultListModel<String>();
	public JList<String> PBL_choose = new JList<String>(PBL_choose_model);
	private DefaultTableModel PBT_model;
	private String[] PBcolumn = {"Date","Time","Type of Treatment","Price","Doctor"};
	private JTable PBT_table = new JTable(new DefaultTableModel(null,PBcolumn));
	
	
	//Clinic
	private JTextField SCT_p50 = new JTextField();
	private JTextField SCT_p18 = new JTextField();
	private JTextField SCT_np = new JTextField();
	private JTextField MTT_treat = new JTextField();
	private JTextField MTT_fpp = new JTextField();
	private JCheckBox MTC_bp = new JCheckBox();
	
	//SC
	private JButton SCB_update = new JButton("Update");
	private JButton SCB_save = new JButton("Save");
	private JButton B_clinic = new JButton("Clinic");
	
	//MT
	private JPanel MTP_pane = new JPanel();
	private DefaultTableModel MTTa_model;
	private String[] MTTa_columns = {"Type of treatment", "Fee ($) per part", "Body parts"};
	private JTable MTTa_table = new JTable(new DefaultTableModel(null,MTTa_columns));
	private JButton MTB_save = new JButton("Save");
	private JButton MTB_add = new JButton("Add");
	private JButton MTB_delete = new JButton("Delete");
	private JButton MTB_clinic = new JButton("Clinic");
	
	//OH
	private MaskFormatter timeFormatter = new MaskFormatter("##':##");
	private JFormattedTextField OHT_AS = new JFormattedTextField(timeFormatter);
	private JFormattedTextField OHT_AE = new JFormattedTextField(timeFormatter);
	private JFormattedTextField OHT_PS = new JFormattedTextField(timeFormatter);
	private JFormattedTextField OHT_PE = new JFormattedTextField(timeFormatter);
	private JFormattedTextField OHT_np1 = new JFormattedTextField(timeFormatter);
	private JFormattedTextField OHT_np2 = new JFormattedTextField(timeFormatter);
	private JFormattedTextField OHT_np3 = new JFormattedTextField(timeFormatter);
	private JFormattedTextField OHT_np4 = new JFormattedTextField(timeFormatter);
	private JButton OHB_save = new JButton("Save");
	private JButton OHB_clinic = new JButton("Clinic");
	private JCheckBox OH1 = new JCheckBox("");
	private JCheckBox OH3 = new JCheckBox("");
	private JCheckBox OH5 = new JCheckBox("");
	private JCheckBox OH7 = new JCheckBox("");
	private JCheckBox OH9 = new JCheckBox("");
	private JCheckBox OH11 = new JCheckBox("");
	private JCheckBox OH13 = new JCheckBox("");
	private JCheckBox OH2 = new JCheckBox("");
	private JCheckBox OH4 = new JCheckBox("");
	private JCheckBox OH6 = new JCheckBox("");
	private JCheckBox OH8 = new JCheckBox("");
	private JCheckBox OH10 = new JCheckBox("");
	private JCheckBox OH12 = new JCheckBox("");
	private JCheckBox OH14 = new JCheckBox("");
	
	//Treatment
	private JTextField TbT_text;
	private JPanel JP_treatmentType = new JPanel();
	private JPanel JP_bodyPart = new JPanel();
	private JPanel JP_treatTable = new JPanel();
	private JPanel JP_bodyTable = new JPanel();	
	private JPanel JP_remark = new JPanel();
	private JTextField TTP_remark = new JTextField();
	private JPanel JP_fee = new JPanel();
	private JLabel Tlbl_total = new JLabel();
	private JLabel Tlbl_Sub_total = new JLabel();
	private JComboBox<String> TtCB_text = new JComboBox<String>();
	private DefaultListModel<String> TtL_model = new DefaultListModel<String>();
	private DefaultListModel<String> TbL_model = new DefaultListModel<String>();
	private JList<String> TtL_list = new JList<String>(TtL_model);
	private JList<String> TbL_list = new JList<String>(TbL_model);
	
	//log
	private JPanel TLP_treatmentRec = new JPanel();
	private DefaultTableModel TLTa_model;
	private String[] TLTa_columns = {"Date","Time","Type of Treatment","Price","Doctor"};
	private JTable TLTa_table = new JTable(new DefaultTableModel(null,TLTa_columns));
	private JPanel TLP_bodyParts = new JPanel();
	private DefaultListModel<String> TLL_model = new DefaultListModel<String>();
	private JList<String> TLL_list = new JList<String>(TLL_model);
	private JPanel TLP_remarks = new JPanel();
	private JLabel TLTP_remarks = new JLabel("");
	
	//account
	private JTextField AST_name = new JTextField();
	private JTextField AST_userName = new JTextField();
	private JPasswordField AST_password = new JPasswordField();
	private JTextField AST_room= new JTextField();
	private JPanel ASP_pane = new JPanel();
	private JButton ASB_save = new JButton("Save");
	private JButton ASB_add = new JButton("Add");
	private JButton ASB_delete = new JButton("Delete");
	private JRadioButton ASR_doctor = new JRadioButton("Doctor");
	private JRadioButton ASR_admin = new JRadioButton("Admin");
	private ButtonGroup ASRG_radiogp = new ButtonGroup();
	private DefaultListModel<String> ASL_model = new DefaultListModel<String>();
	private JList<String> ASL_doctor= new JList<String>(ASL_model);
	private DefaultListModel<String> ASL_adminmodel = new DefaultListModel<String>();
	private JList<String> ASL_admin = new JList<String>(ASL_adminmodel);
	private JButton ASB_menu = new JButton("Menu");
	
	//Mode variables
	private boolean cnt=true;
	private int mode; //1:doctor 2:admin
	private boolean saveStatus = false;
	private String doctorID;
	private boolean elderly = false;
	
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
	private JPanel accountPane;
	private JPanel treatmentPane;
	private JPanel logPane;
	

	//Card Layout
	CardLayout cardLayout = new CardLayout(); //cardLayout, used for different panel

	//Menu Bar
	private JMenuBar menubar = new JMenuBar(); //top menu bar (not shown on login page)

	private Patient patient = null; //pointer pointing accessing which patient
	//**********Data Member of MyWindow**********//
	

	private void menubar(){
		//construct the menubar
		JMenu M_patient = new JMenu("Patient");
		menubar.add(M_patient);
		JMenuItem newpatient = new JMenuItem("New");
		JMenuItem searchpatient = new JMenuItem("Search");
		M_patient.add(newpatient);
		newpatient.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				patient = null;
				try {
					patientPage();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				PB_save.setEnabled(true);
				PB_update.setEnabled(false);
				cardLayout.show(contentPane, "Patient");
			}});
		M_patient.add(searchpatient);
		searchpatient.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Search");
			}});

		JMenu clinic = new JMenu("Clinic");
		menubar.add(clinic);
		JMenuItem openinghr = new JMenuItem("Opening Hour");
		JMenuItem medicTreat = new JMenuItem("Medical Treatment");
		JMenuItem specCond = new JMenuItem("Special Condition");
		clinic.add(openinghr);
		openinghr.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "c_OH");
			}});
		clinic.add(medicTreat);
		medicTreat.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				c_MTPage();
				cardLayout.show(contentPane, "c_MT");
			}});
		clinic.add(specCond);
		specCond.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "c_SC");
			}});

		JMenu account = new JMenu("Account");
		menubar.add(account);
		JMenuItem changePassword = new JMenuItem("Change Password");
		JMenuItem logout = new JMenuItem("Log out");
		account.add(changePassword);
		account.add(logout);
		logout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				logout();
			}});
	}

	//Login method
	private void login(String userName, char[] password){
		
		//load login information
		logAc = logAc.load(logAc);
		if ((mode = Doctor.checkLogin(db,logAc,userName,password))!=0){
			//when password match, saved mode : 1:Doctor 2:admin
			doctorID = userName;
			db = db.load(db);
			menuPage();
			cardLayout.show(contentPane, "Menu"); //change panel
			setJMenuBar(menubar); //show the menu bar
		}
		else
			JOptionPane.showMessageDialog(null, "Please retry","Login Failed", JOptionPane.ERROR_MESSAGE); //password not patch, show error message box
	}

	//Logout method
	private void logout(){
		db.save(); //save data in db
		logAc.save();
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
				login("user","user".toCharArray());
				//login(L_userNameField.getText(),L_passwordField.getPassword());
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
				try {
					patientPage();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				patient = null;
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

		//only show Account or Timetable

		//*****My Timetable*****
		if (mode==1){
			PBB_myTimetable.setVisible(true);
			PBB_account.setVisible(false);
		}

		//*****Account*****
		if (mode==2){
			PBB_account.setVisible(true);
			PBB_myTimetable.setVisible(false);
		}

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
				//int index = Patient.patientSearch(db, (String) SPT_HKID.getValue());
				
				
				
				int index = Patient.patientSearch(db, "A000001(1)");
				
				
				if (index > -1){
					patient = db.getPatient(index);
					if (patient.getAge()>50)
						elderly = true;
					else
						elderly = false;
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
		
		saveStatus = false;

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
		if (mode==2){
			PB_treatment.setEnabled(false);
		} else{
			PB_treatment.setEnabled(true);
		}
		
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
		lbl_date.setBounds(185, 119, 57, 24);
		p_bookingPane.add(lbl_date);
		
		JLabel lblDdmmyyyy = new JLabel("dd/mm/yyyy");
		lblDdmmyyyy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDdmmyyyy.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDdmmyyyy.setBounds(124, 141, 116, 24);
		p_bookingPane.add(lblDdmmyyyy);
		
		JLabel lbl_doctor = new JLabel("Doctor:");
		lbl_doctor.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_doctor.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_doctor.setBounds(92, 198, 71, 24);
		p_bookingPane.add(lbl_doctor);

		JButton PBB_update = new JButton("update");
		PBB_update.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PBupdate();
			}});
		PBB_update.setFont(new Font("Arial", Font.PLAIN, 20));
		PBB_update.setBounds(278, 274, 101, 47);
		p_bookingPane.add(PBB_update);

		//set Doctor list
		PBCB_doctor.removeAllItems();
		Doctor.addCombo(logAc, PBCB_doctor);


		JButton PBB_book = new JButton("Book");
		PBB_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if (PBL_choose.getSelectedIndex()==-1)
						throw new NullFieldException(3);
					int day, month, year;
					day = Integer.parseInt(((String)PBT_date.getValue()).substring(0,2));
					month = Integer.parseInt(((String)PBT_date.getValue()).substring(3,5))-1;
					year = Integer.parseInt(((String)PBT_date.getValue()).substring(6,10));

					GregorianCalendar date = new GregorianCalendar();
					date.set(year, month, day,Integer.parseInt(PBL_choose_model.getElementAt(PBL_choose.getSelectedIndex()).substring(0, 2)),0);
					int index = PBCB_doctor.getSelectedIndex();
					String doctorID = logAc.getDoctor(index).getUserName();
					db.createbooking(patient.getHKID(), doctorID, date);
				} catch (NullFieldException e){
					e.error();
				}
				PBupdate();
			}
		});
		PBB_book.setFont(new Font("Arial", Font.PLAIN, 20));
		PBB_book.setBounds(843, 300, 109, 47);
		p_bookingPane.add(PBB_book);
		
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

	private void PBupdate(){
		try{
			if (PBT_date.getValue()==null)
				throw new NullFieldException(2);
			PBL_choose_model.removeAllElements();
			int index = PBCB_doctor.getSelectedIndex();
			String doctorID = logAc.getDoctor(index).getUserName();
			int start = Integer.parseInt(db.getClinic().getSession(0).substring(0, 2));
			int end = Integer.parseInt(db.getClinic().getSession(3).substring(0, 2));
			int cnt = start;
			if (!elderly){
				while (cnt<end){
					if (db.isavaliable(doctorID, (String)PBT_date.getValue(), cnt))
						if ((cnt<Integer.parseInt(db.getClinic().getSession(1).substring(0, 2))) || (cnt>=Integer.parseInt(db.getClinic().getSession(2).substring(0, 2)))){
							PBL_choose_model.add(PBL_choose_model.getSize(), Integer.toString(cnt)+":00");
						}
					cnt++;
				}
			} 
		}catch (NullFieldException e){
			e.error();
		}
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
				c_MTPage();
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
				c_SCPage();
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
				c_OHPage();
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
		
		SCT_p50.setText(Float.toString(db.getClinic().getDiscount(0)));
		SCT_p18.setText(Float.toString(db.getClinic().getDiscount(1)));
		SCT_np.setText(Float.toString(db.getClinic().getDiscount(2)));
		SCT_p50.setEnabled(false);
		SCT_p18.setEnabled(false);
		SCT_np.setEnabled(false);
		
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
		
		JLabel lbl_Discount = new JLabel("Rate");
		lbl_Discount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Discount.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_Discount.setBounds(458, 160, 143, 47);
		c_SCPane.add(lbl_Discount);
		
		SCB_update.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SCT_p50.setEnabled(true);
				SCT_p18.setEnabled(true);
				SCT_np.setEnabled(true);
			}});
		
		SCB_save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				db.getClinic().setDiscount(0, Float.parseFloat(SCT_p50.getText()));
				db.getClinic().setDiscount(1, Float.parseFloat(SCT_p18.getText()));
				db.getClinic().setDiscount(2, Float.parseFloat(SCT_np.getText()));
				SCT_p50.setEnabled(false);
				SCT_p18.setEnabled(false);
				SCT_np.setEnabled(false);
			}});
		
		B_clinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Clinic");
			}
		});
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
		
		MTT_treat.setText("");
		MTT_fpp.setText("");
		MTC_bp.setSelected(false);
		
		JLabel lbl_MedicalTreatment = new JLabel("Medical Treatment");
		lbl_MedicalTreatment.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MedicalTreatment.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_MedicalTreatment.setBounds(349, 20, 286, 47);
		c_MTPane.add(lbl_MedicalTreatment);

		MTTa_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (MTTa_table.getSelectedRow()>=0){
					MTT_treat.setText((String) MTTa_table.getValueAt(MTTa_table.getSelectedRow(),0).toString());
					MTT_fpp.setText((String) MTTa_table.getValueAt(MTTa_table.getSelectedRow(),1).toString());
					if (MTTa_table.getValueAt(MTTa_table.getSelectedRow(),2).toString()=="Y")
						MTC_bp.setSelected(true);
					else
						MTC_bp.setSelected(false);
				}
			}});
		TreatmentMeta.addTable(db, MTTa_model);
		
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

		MTB_save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cnt){
					cnt = false;
				if (MTTa_table.getSelectedRow()!=-1){
					//save
					db.getClinic().getTreatmentMeta(MTTa_table.getSelectedRow()).setType(MTT_treat.getText());
					db.getClinic().getTreatmentMeta(MTTa_table.getSelectedRow()).setFpp(Integer.parseInt(MTT_fpp.getText()));
					db.getClinic().getTreatmentMeta(MTTa_table.getSelectedRow()).setBodyPart(MTC_bp.isSelected());
					TreatmentMeta.addTable(db, MTTa_model);
					JOptionPane.showMessageDialog(null, "Treatment record saved.", "Treatment Record",JOptionPane.PLAIN_MESSAGE);
				} else{
					//new
					TreatmentMeta treatmentMeta = new TreatmentMeta(MTT_treat.getText(),Integer.parseInt(MTT_fpp.getText()),MTC_bp.isSelected());
					db.getClinic().addTreatmentMeta(treatmentMeta);
					TreatmentMeta.addTable(db, MTTa_model);
					JOptionPane.showMessageDialog(null, "Treatment record saved.", "Treatment Record",JOptionPane.PLAIN_MESSAGE);
				}
				} else{
					cnt = true;
				}
			}});
		
		MTB_add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MTTa_table.clearSelection();
				MTT_treat.setText("");
				MTT_fpp.setText("");
				MTC_bp.setSelected(false);
			}});
		
		MTB_delete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MTTa_table.getSelectedRow()!=-1){
					db.getClinic().deleteTreatmentMeta(MTTa_table.getSelectedRow());
					TreatmentMeta.addTable(db, MTTa_model);
					MTT_treat.setText("");
					MTT_fpp.setText("");
					MTC_bp.setSelected(false);
					JOptionPane.showMessageDialog(null, "Treatment record deleted.", "Treatment Record",JOptionPane.PLAIN_MESSAGE);
				}
			}});
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
		
		JLabel lbl_OpeningHour = new JLabel("Opening Hour");
		lbl_OpeningHour.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_OpeningHour.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_OpeningHour.setBounds(372, 20, 240, 47);
		c_OHPane.add(lbl_OpeningHour);
		
		OH1.setSelected(db.getClinic().getOpenHr(0, 0));
		OH2.setSelected(db.getClinic().getOpenHr(0, 1));
		OH3.setSelected(db.getClinic().getOpenHr(1, 0));
		OH4.setSelected(db.getClinic().getOpenHr(1, 1));
		OH5.setSelected(db.getClinic().getOpenHr(2, 0));
		OH6.setSelected(db.getClinic().getOpenHr(2, 1));
		OH7.setSelected(db.getClinic().getOpenHr(3, 0));
		OH8.setSelected(db.getClinic().getOpenHr(3, 1));
		OH9.setSelected(db.getClinic().getOpenHr(4, 0));
		OH10.setSelected(db.getClinic().getOpenHr(4, 1));
		OH11.setSelected(db.getClinic().getOpenHr(5, 0));
		OH12.setSelected(db.getClinic().getOpenHr(5, 1));
		OH13.setSelected(db.getClinic().getOpenHr(6, 0));
		OH14.setSelected(db.getClinic().getOpenHr(6, 1));
		OHT_AS.setValue(db.getClinic().getSession(0));
		OHT_AE.setValue(db.getClinic().getSession(1));
		OHT_PS.setValue(db.getClinic().getSession(2));
		OHT_PE.setValue(db.getClinic().getSession(3));
		OHT_np1.setValue(db.getClinic().getNonPHr(0));
		OHT_np2.setValue(db.getClinic().getNonPHr(1));
		OHT_np3.setValue(db.getClinic().getNonPHr(2));
		OHT_np4.setValue(db.getClinic().getNonPHr(3));
		
		OHB_save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				db.getClinic().setOpenHr(0, 0, OH1.isSelected());
				db.getClinic().setOpenHr(0, 1, OH2.isSelected());
				db.getClinic().setOpenHr(1, 0, OH3.isSelected());
				db.getClinic().setOpenHr(1, 1, OH4.isSelected());
				db.getClinic().setOpenHr(2, 0, OH5.isSelected());
				db.getClinic().setOpenHr(2, 1, OH6.isSelected());
				db.getClinic().setOpenHr(3, 0, OH7.isSelected());
				db.getClinic().setOpenHr(3, 1, OH8.isSelected());
				db.getClinic().setOpenHr(4, 0, OH9.isSelected());
				db.getClinic().setOpenHr(4, 1, OH10.isSelected());
				db.getClinic().setOpenHr(5, 0, OH11.isSelected());
				db.getClinic().setOpenHr(5, 1, OH12.isSelected());
				db.getClinic().setOpenHr(6, 0, OH13.isSelected());
				db.getClinic().setOpenHr(6, 1, OH14.isSelected());
				db.getClinic().setSession(0, (String)OHT_AS.getValue());
				db.getClinic().setSession(1, (String)OHT_AE.getValue());
				db.getClinic().setSession(2, (String)OHT_PS.getValue());
				db.getClinic().setSession(3, (String)OHT_PE.getValue());
				db.getClinic().setNonPH(0, (String)OHT_np1.getValue());
				db.getClinic().setNonPH(1, (String)OHT_np2.getValue());
				db.getClinic().setNonPH(2, (String)OHT_np3.getValue());
				db.getClinic().setNonPH(3, (String)OHT_np4.getValue());
				JOptionPane.showMessageDialog(null, "Setting saved","Opening Hour",JOptionPane.PLAIN_MESSAGE);
			}});
		
		OHB_clinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Clinic");
			}
		});
	}
	//***********************************************************************
	//***************************C OH Page***********************************
	//***********************************************************************
	
	
	//***********************************************************************
	//**************************Account Page*********************************
	//***********************************************************************	
	private void accountPage(){
		int index; //index for the user account in the LinkedList
		int type; //type: 1 for doctor, 2 for admin
		
		accountPane = new JPanel();
		accountPane.setBackground(SystemColor.activeCaption);
		accountPane.setLayout(null);
		
		AST_name.setText(null);
		AST_userName.setText(null);
		AST_password.setText(null);
		AST_room.setText(null);
		ASL_doctor.clearSelection();
		ASL_admin.clearSelection();
		ASR_doctor.setSelected(false);
		ASR_admin.setSelected(false);
		
		
		JLabel lblAccountSetting = new JLabel("Account Setting");
		lblAccountSetting.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountSetting.setFont(new Font("Arial", Font.BOLD, 30));
		lblAccountSetting.setBounds(349, 20, 286, 47);
		accountPane.add(lblAccountSetting);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(70, 223, 111, 24);
		accountPane.add(lblNewLabel_3);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUsername.setBounds(70, 285, 111, 24);
		accountPane.add(lblUsername);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword_1.setBounds(70, 347, 111, 24);
		accountPane.add(lblPassword_1);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoom.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRoom.setBounds(70, 409, 111, 24);
		accountPane.add(lblRoom);
		
		JLabel lblNameOfUser = new JLabel("Name of User");
		lblNameOfUser.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNameOfUser.setBounds(10, 11, 121, 24);
		ASP_pane.add(lblNameOfUser);

		renewASL();

		ASL_doctor.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {

				if (ASL_doctor.getSelectedIndex() != -1){
					ASL_admin.clearSelection();
					ASR_doctor.setEnabled(false);
					ASR_admin.setEnabled(false);
					AST_room.setEnabled(true);
					AST_password.setEnabled(false);
					ASR_doctor.setSelected(true);
					ASR_admin.setSelected(false);
					AST_password.setText(logAc.getDoctor(ASL_doctor.getSelectedIndex()).getPassword());
					AST_name.setText(logAc.getDoctor(ASL_doctor.getSelectedIndex()).getName());
					AST_userName.setText(logAc.getDoctor(ASL_doctor.getSelectedIndex()).getUserName());
					AST_room.setText(Integer.toString(logAc.getDoctor(ASL_doctor.getSelectedIndex()).getRoom()));
				}
			}});
		
		ASL_doctor.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				if (ASL_doctor.getSelectedIndex() != -1){
					ASL_admin.clearSelection();
					ASR_doctor.setEnabled(false);
					ASR_admin.setEnabled(false);
					AST_room.setEnabled(true);
					AST_password.setEnabled(false);
					ASR_doctor.setSelected(true);
					ASR_admin.setSelected(false);
					AST_password.setText(logAc.getDoctor(ASL_doctor.getSelectedIndex()).getPassword());
					AST_name.setText(logAc.getDoctor(ASL_doctor.getSelectedIndex()).getName());
					AST_userName.setText(logAc.getDoctor(ASL_doctor.getSelectedIndex()).getUserName());
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}});

		ASL_admin.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (ASL_admin.getSelectedIndex() != -1){
					ASL_doctor.clearSelection();
					ASR_doctor.setEnabled(false);
					ASR_admin.setEnabled(false);
					AST_room.setText(null);
					AST_room.setEnabled(false);
					AST_password.setEnabled(false);
					ASR_doctor.setSelected(false);
					ASR_admin.setSelected(true);
					AST_password.setText(logAc.getAdmin(ASL_admin.getSelectedIndex()).getPassword());
					AST_name.setText(logAc.getAdmin(ASL_admin.getSelectedIndex()).getName());
					AST_userName.setText(logAc.getAdmin(ASL_admin.getSelectedIndex()).getUserName());
				}
			}});
		
		ASL_admin.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e) {
				if (ASL_admin.getSelectedIndex() != -1){
					ASL_doctor.clearSelection();
					ASR_doctor.setEnabled(false);
					ASR_admin.setEnabled(false);
					AST_room.setText(null);
					AST_room.setEnabled(false);
					AST_password.setEnabled(false);
					ASR_doctor.setSelected(false);
					ASR_admin.setSelected(true);
					AST_password.setText(logAc.getAdmin(ASL_admin.getSelectedIndex()).getPassword());
					AST_name.setText(logAc.getAdmin(ASL_admin.getSelectedIndex()).getName());
					AST_userName.setText(logAc.getAdmin(ASL_admin.getSelectedIndex()).getUserName());
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
			}});
		
		ASR_doctor.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (ASR_doctor.isSelected())
					AST_room.setEnabled(true);
			}});
		
		ASR_admin.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (ASR_admin.isSelected())
					AST_room.setEnabled(false);
			}});
		
		ASB_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ASR_doctor.setEnabled(true);
				ASR_admin.setEnabled(true);
				ASR_doctor.setSelected(false);
				ASR_admin.setSelected(false);
				AST_room.setEnabled(true);
				AST_password.setEnabled(true);
				AST_name.setText(null);
				AST_userName.setText(null);
				AST_password.setText(null);
				AST_room.setText(null);
				ASL_admin.clearSelection();
				ASL_doctor.clearSelection();
			}

		});
		
		ASB_save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cnt){
					cnt = false;
					try{
						if ((AST_name.getText().equals("")) || (AST_userName.getText().equals("")) || (AST_password.getText().equals("")))
							throw new NullFieldException(2);
						if (ASL_doctor.getSelectedIndex()!=-1){
							//save to doctor
							if (AST_room.getText().equals(""))
								throw new NullFieldException(2);
							if (AST_userName.getText().equals(logAc.getDoctor(ASL_doctor.getSelectedIndex()).getUserName()) ||
									((Doctor.doctorSearch(db,logAc,AST_userName.getText())==-1) && (Admin.adminSearch(db,logAc,AST_userName.getText())==-1))){ //make sure userName is unique
								logAc.getDoctor(ASL_doctor.getSelectedIndex()).setName(AST_name.getText());
								logAc.getDoctor(ASL_doctor.getSelectedIndex()).setUserName(AST_userName.getText());
								logAc.getDoctor(ASL_doctor.getSelectedIndex()).setRoom(Integer.parseInt(AST_room.getText()));
								renewASL();
								JOptionPane.showMessageDialog(null, "Doctor saved.", "Account",JOptionPane.PLAIN_MESSAGE);
							} else{
								JOptionPane.showMessageDialog(null, "User Name is not unique, please use another user name.", "Account",JOptionPane.ERROR_MESSAGE);
							}
						} else if (ASL_admin.getSelectedIndex()!=-1){
							//save to admin
							if (AST_userName.getText().equals(logAc.getAdmin(ASL_admin.getSelectedIndex()).getUserName()) ||
									((Doctor.doctorSearch(db,logAc,AST_userName.getText())==-1) && (Admin.adminSearch(db,logAc,AST_userName.getText())==-1))){ //make sure userName is unique
								logAc.getAdmin(ASL_admin.getSelectedIndex()).setName(AST_name.getText());
								logAc.getAdmin(ASL_admin.getSelectedIndex()).setUserName(AST_userName.getText());
								renewASL();
								JOptionPane.showMessageDialog(null, "Admin saved.", "Account",JOptionPane.PLAIN_MESSAGE);
							} else{
								JOptionPane.showMessageDialog(null, "User Name is not unique, please use another user name.", "Account",JOptionPane.ERROR_MESSAGE);
							}

						}
						else if ((ASL_doctor.getSelectedIndex()==-1) && (ASL_admin.getSelectedIndex()==-1)){
							//add new account
							if (ASR_doctor.isSelected()){
								//add doctor
								if (AST_room.getText().equals(""))
									throw new NullFieldException(2);
								String pass = new String(AST_password.getPassword());
								logAc.addDoctor(new Doctor(AST_name.getText(),AST_userName.getText(),pass,Integer.parseInt(AST_room.getText())));
								AST_password.setEnabled(false);
								renewASL();
								JOptionPane.showMessageDialog(null, "Doctor added.", "Account",JOptionPane.PLAIN_MESSAGE);
							} else if (ASR_admin.isSelected()){
								//add admin
								String pass = new String(AST_password.getPassword());
								logAc.addAdmin(new Admin(AST_name.getText(),AST_userName.getText(),pass));
								AST_password.setEnabled(false);
								renewASL();
								JOptionPane.showMessageDialog(null, "Admin added.", "Account",JOptionPane.PLAIN_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Please select Staff type.", "Account",JOptionPane.ERROR_MESSAGE);
							}
						}
					} catch (NullFieldException e1){
						e1.error();
					}

				} else {
					cnt = true;
				}
			}});
		
		ASB_delete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ASL_doctor.getSelectedIndex()!=-1){
					//delete doctor
					logAc.deleteDoctor(ASL_doctor.getSelectedIndex());
					ASL_doctor.clearSelection();
					renewASL();
				} else if (ASL_admin.getSelectedIndex()!=-1){
					//delete admin
					logAc.deleteAdmin(ASL_admin.getSelectedIndex());
					ASL_admin.clearSelection();
					renewASL();
				}
			}});
	}

	private void renewASL(){
		ASL_model.removeAllElements();
		for (int i = 0; i<logAc.getDoctorSize(); i++){
			ASL_model.add(i, logAc.getDoctor(i).getName());
		}
		ASL_adminmodel.removeAllElements();
		for (int i = 0; i<logAc.getAdminSize(); i++){
			ASL_adminmodel.add(i, logAc.getAdmin(i).getName());
		}
		ASR_doctor.setEnabled(true);
		ASR_admin.setEnabled(true);
		AST_password.setEnabled(true);
		AST_name.setText("");
		AST_userName.setText("");
		AST_password.setText("");
		AST_room.setText("");
	}
	//***********************************************************************
	//**************************Account Page*********************************
	//***********************************************************************	
	
	
	//***********************************************************************
	//*************************Timetable Page********************************
	//***********************************************************************	
	private void timetablePage(){
		timetablePane = new JPanel();
		timetablePane.setBackground(SystemColor.activeCaption);
		timetablePane.setLayout(null);
		
		JLabel lblTimetable = new JLabel("Timetable");
		lblTimetable.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimetable.setFont(new Font("Arial", Font.BOLD, 30));
		lblTimetable.setBounds(349, 20, 286, 47);
		timetablePane.add(lblTimetable);
	}
	//***********************************************************************
	//*************************Timetable Page********************************
	//***********************************************************************
	
	
	//***********************************************************************
	//*************************Treatment Page********************************
	//***********************************************************************
	private void treatmentPage(){
		
		TTP_remark.setText(null);
		
		TreatmentRec treatmentRec = new TreatmentRec(db,patient,doctorID);
		
		if (patient != null){
			patient.addTreatmentRec(treatmentRec);
			TTP_remark.setText(patient.getTreatmentRec(patient.getTreatmentRecSize()-1).getCondition());
			patient.getTreatmentRec(patient.getTreatmentRecSize()-1).setRemarks(TTP_remark.getText());
		}
		
		treatmentPane = new JPanel();
		treatmentPane.setBackground(SystemColor.activeCaption);
		treatmentPane.setLayout(null);
		
		JLabel lblTreatment = new JLabel("Treatment");
		lblTreatment.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreatment.setFont(new Font("Arial", Font.BOLD, 30));
		lblTreatment.setBounds(349, 20, 286, 47);
		treatmentPane.add(lblTreatment);
		
		JLabel lbl_Tt = new JLabel("Enter treatment type");
		lbl_Tt.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_Tt.setBounds(10, 10, 193, 24);
		JP_treatmentType.add(lbl_Tt);

		TtCB_text.removeAllItems();
		TreatmentMeta.addCombo(db, TtCB_text);

		TtL_model.removeAllElements();
		TbL_model.removeAllElements();

		TtL_list.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (TtL_list.getSelectedIndex()!=-1){
					Tlbl_total.setText(Float.toString(patient.getTreatmentRec(patient.getTreatmentRecSize()-1).getTreatment(TtL_list.getSelectedIndex()).getPrice()));
					TbL_model.removeAllElements();
					if (TtL_list.getSelectedIndex()!=-1)
						for (int i=0; i<patient.getTreatmentRec(patient.getTreatmentRecSize()-1).getTreatment(TtL_list.getSelectedIndex()).getPartsSize(); i++){
							TbL_model.add(i, patient.getTreatmentRec(patient.getTreatmentRecSize()-1).getTreatment(TtL_list.getSelectedIndex()).getParts(i));
						}
				}
			}});

		
		
		
		if (patient!=null){
			final float discount = patient.getTreatmentRec(patient.getTreatmentRecSize()-1).getDiscount();
		
			
			
		JButton TtB_save = new JButton("Save");
		TtB_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cur_rec = patient.getTreatmentRecSize()-1;
				int cur_treat = TtL_list.getSelectedIndex();
				float tmp_price;
				float tmp_sub_price;
				//add treatment
				Treatment treatment = new Treatment();
				treatment.setType(db.getClinic().getTreatmentMeta(TtCB_text.getSelectedIndex()).getType());
				patient.getTreatmentRec(patient.getTreatmentRecSize()-1).addTreatment(treatment);
				//update list
				TtL_model.add(patient.getTreatmentRec(patient.getTreatmentRecSize()-1).getTreatmentSize()-1,
						patient.getTreatmentRec(patient.getTreatmentRecSize()-1).getTreatment(patient.getTreatmentRec(patient.getTreatmentRecSize()-1).getTreatmentSize()-1).getType());
				if (!(db.getClinic().getTreatmentMeta(TtCB_text.getSelectedIndex()).isBodyPart())){
					//calculate price
					tmp_sub_price = patient.getTreatmentRec(cur_rec).getTotalPrice() + db.getClinic().getTreatmentMeta(TtCB_text.getSelectedIndex()).getFpp()*discount;
					//System.out.println(tmp_sub_price);
					patient.getTreatmentRec(cur_rec).setTotalPrice(tmp_sub_price);
					tmp_price = db.getClinic().getTreatmentMeta(TtCB_text.getSelectedIndex()).getFpp()*discount;
					//System.out.println(tmp_price);
					patient.getTreatmentRec(cur_rec).getTreatment(patient.getTreatmentRec(cur_rec).getTreatmentSize()-1).setPrice(tmp_price);
					//update price
					Tlbl_total.setText(Float.toString(tmp_price));
					Tlbl_Sub_total.setText(Float.toString(tmp_sub_price));
				}
			}
		});
		TtB_save.setFont(new Font("Arial", Font.PLAIN, 20));
		TtB_save.setBounds(39, 90, 79, 33);
		JP_treatmentType.add(TtB_save);

		JButton Ttb_clear = new JButton("Clear");
		Ttb_clear.setFont(new Font("Arial", Font.PLAIN, 20));
		Ttb_clear.setBounds(157, 90, 90, 33);
		JP_treatmentType.add(Ttb_clear);



		JLabel lbl_Tb = new JLabel("Enter Body part");
		lbl_Tb.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_Tb.setBounds(10, 10, 155, 24);
		JP_bodyPart.add(lbl_Tb);

		JButton TbB_save = new JButton("Save");
		TbB_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((db.getClinic().getTreatmentMeta(TtCB_text.getSelectedIndex()).isBodyPart())){
					if (!TbT_text.getText().equals("")){
						int cur_rec = patient.getTreatmentRecSize()-1;
						int cur_treat = TtL_list.getSelectedIndex();
						float tmp_price;
						float tmp_sub_price;

						if (cur_treat!=-1){
							//add parts
							patient.getTreatmentRec(cur_rec).getTreatment(cur_treat).addParts(TbT_text.getText());
							//update list
							TbL_model.add(patient.getTreatmentRec(cur_rec).getTreatment(cur_treat).getPartsSize()-1, patient.getTreatmentRec(cur_rec).getTreatment(cur_treat).getParts(patient.getTreatmentRec(cur_rec).getTreatment(cur_treat).getPartsSize()-1));
							//clear textField
							TbT_text.setText(null);
							//calculate price
							tmp_sub_price = patient.getTreatmentRec(cur_rec).getTotalPrice() +
									db.getClinic().getTreatmentMeta(db.getClinic().searchType(patient.getTreatmentRec(cur_rec).getTreatment(cur_treat).getType())).getFpp()*discount;
							patient.getTreatmentRec(cur_rec).setTotalPrice(tmp_sub_price);
							tmp_price = patient.getTreatmentRec(cur_rec).getTreatment(cur_treat).getPrice() +
									db.getClinic().getTreatmentMeta(db.getClinic().searchType(patient.getTreatmentRec(cur_rec).getTreatment(cur_treat).getType())).getFpp()*discount;
							patient.getTreatmentRec(cur_rec).getTreatment(cur_treat).setPrice(tmp_price);
							//update price
							Tlbl_total.setText(Float.toString(tmp_price));
							Tlbl_Sub_total.setText(Float.toString(tmp_sub_price));
						} else{
							JOptionPane.showMessageDialog(null, "Please select a Treatment type from the Type of treatment list","Body Parts", JOptionPane.WARNING_MESSAGE);
						}
					} else{
						JOptionPane.showMessageDialog(null, "Please enter body part","Body Parts", JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "No body parts should be entered.","Body Parts", JOptionPane.WARNING_MESSAGE);
					TbT_text.setText(null);
				}
			}
		});
		TbB_save.setFont(new Font("Arial", Font.PLAIN, 20));
		TbB_save.setBounds(39, 90, 79, 33);
		JP_bodyPart.add(TbB_save);
		
		
		
		}
		
		
		
		JButton TbB_clear = new JButton("Clear");
		TbB_clear.setFont(new Font("Arial", Font.PLAIN, 20));
		TbB_clear.setBounds(157, 90, 90, 33);
		JP_bodyPart.add(TbB_clear);
		
		JLabel lbl_remark = new JLabel("Remark:");
		lbl_remark.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_remark.setBounds(10, 15, 85, 24);
		JP_remark.add(lbl_remark);
		
		JButton TB_patient = new JButton("Patient");
		TB_patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Patient");
			}
		});
		TB_patient.setFont(new Font("Arial", Font.PLAIN, 20));
		TB_patient.setBackground(new Color(255, 192, 203));
		TB_patient.setBounds(808, 566, 143, 47);
		treatmentPane.add(TB_patient);
		
		JButton TB_save = new JButton("Save");
		TB_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				patient.getTreatmentRec(patient.getTreatmentRecSize()-1).setRemarks(TTP_remark.getText());
			}
		});
		TB_save.setFont(new Font("Arial", Font.PLAIN, 20));
		TB_save.setBounds(529, 565, 143, 48);
		treatmentPane.add(TB_save);
		
		JLabel lbl_total = new JLabel("Total");
		lbl_total.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_total.setBounds(10, 48, 123, 24);
		JP_fee.add(lbl_total);
		
		JLabel lblSubtotal = new JLabel("Sub-Total");
		lblSubtotal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSubtotal.setBounds(10, 14, 123, 24);
		JP_fee.add(lblSubtotal);
		
		
	}
	//***********************************************************************
	//*************************Treatment Page********************************
	//***********************************************************************
	
	
	//***********************************************************************
	//***************************log Page************************************
	//***********************************************************************
	private void logPage(){
		logPane = new JPanel();
		logPane.setBackground(SystemColor.activeCaption);
		logPane.setLayout(null);
		
		JLabel lblTreatmentLog = new JLabel("Treatment Log");
		lblTreatmentLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreatmentLog.setFont(new Font("Arial", Font.BOLD, 30));
		lblTreatmentLog.setBounds(349, 20, 286, 47);
		logPane.add(lblTreatmentLog);

		TLTa_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int beforehand=0;
				TLL_model.removeAllElements();
				if (TLTa_table.getSelectedRow()!=-1){
					for (int x=findRec()-1;x>=0;x--){
						beforehand += patient.getTreatmentRec(x).getTreatmentSize();
					}
					for (int i=0; i<patient.getTreatmentRec(findRec()).getTreatment(TLTa_table.getSelectedRow()-beforehand).getPartsSize(); i++){
						TLL_model.add(i, patient.getTreatmentRec(findRec()).getTreatment(TLTa_table.getSelectedRow()-beforehand).getParts(i));
					}
					TLTP_remarks.setText(patient.getTreatmentRec(findRec()).getRemarks());
				}
			}});

		if (patient!=null){
			int rowCount=TLTa_model.getRowCount();
			for(int i=rowCount-1;i>=0;i--){
				TLTa_model.removeRow(i);
			}
			TLTP_remarks.setText(null);
			Patient.addTable(patient, TLTa_model);
		}
	}
	
	private int findRec(){
		int i = TLTa_table.getSelectedRow();
		int x;
		for (x = 0; i>0; x++){
			i = i - patient.getTreatmentRec(x).getTreatmentSize();
			if (i<0)
				x--;
		}
		return x;
	}
	//***********************************************************************
	//***************************log Page************************************
	//***********************************************************************
	
	
	//*******************Construct Label and Button**************************
	private void addToWindow(){
		//Patient page
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
		
		JButton btnLogindoctor = new JButton("Doctor");
		btnLogindoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login("doctor","doctor".toCharArray());
			}
		});
		btnLogindoctor.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLogindoctor.setBounds(327, 537, 110, 60);
		loginPane.add(btnLogindoctor);
		
		//Patient page button
		//B_save
		PB_save.setBounds(693, 227, 98, 32);
		color1.add(PB_save);
		PB_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ //Saving or creating patient record
					if ((PT_name.getText().equals("")) || (PT_dob.getValue()==null) || (PT_gender.getText().equals("")) || (PT_tel.getText().equals("")))
						throw new NullFieldException(2);
					if (PT_HKID.getValue() == null) throw new NullFieldException(1); //primary key should not be null
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
					saveStatus = true;
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
		
		PB_booking.setHorizontalAlignment(SwingConstants.LEFT);
		PB_booking.setIcon(new ImageIcon(getClass().getResource("booking.png")));
		PB_booking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saveStatus){
					p_bookingPage();
					cardLayout.show(contentPane, "Booking");
				} else
					JOptionPane.showMessageDialog(null, "Please save the patient information first.","Patient", JOptionPane.ERROR_MESSAGE);
			}
		});
		PB_booking.setFont(new Font("Arial", Font.PLAIN, 25));
		PB_booking.setBounds(201, 384, 190, 100);
		patientPane.add(PB_booking);
		
		PB_treatment.setHorizontalAlignment(SwingConstants.LEFT);
		PB_treatment.setIcon(new ImageIcon(getClass().getResource("treatment.png")));
		PB_treatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (saveStatus){
					treatmentPage();
					cardLayout.show(contentPane, "Treatment");
				}else
					JOptionPane.showMessageDialog(null, "Please save the patient information first.","Patient", JOptionPane.ERROR_MESSAGE);
			}
		});
		PB_treatment.setFont(new Font("Arial", Font.PLAIN, 25));
		PB_treatment.setBounds(592, 384, 190, 100);
		patientPane.add(PB_treatment);
		
		PB_log.setIcon(new ImageIcon(getClass().getResource("log.png")));
		PB_log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saveStatus){
					logPage();
					cardLayout.show(contentPane, "Log");
				}else
					JOptionPane.showMessageDialog(null, "Please save the patient information first.","Patient", JOptionPane.ERROR_MESSAGE);
			}
		});
		PB_log.setFont(new Font("Arial", Font.PLAIN, 25));
		PB_log.setBounds(201, 506, 190, 100);
		patientPane.add(PB_log);
		
		PB_menu.setBackground(new Color(255, 192, 203));
		PB_menu.addActionListener(new ActionListener() {
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
		PB_menu.setFont(new Font("Arial", Font.PLAIN, 25));
		PB_menu.setBounds(592, 506, 190, 100);
		patientPane.add(PB_menu);
		
		//Patient Booking
		PBT_date.setFont(new Font("Arial", Font.PLAIN, 20));
		PBT_date.setBounds(252, 116, 127, 29);
		p_bookingPane.add(PBT_date);
		
		PBCB_doctor.setFont(new Font("Arial", Font.PLAIN, 20));
		PBCB_doctor.setBounds(173, 198, 206, 24);
		p_bookingPane.add(PBCB_doctor);
		
		PBB_account.setIcon(new ImageIcon(getClass().getResource("account.png")));
		PBB_account.setFont(new Font("Arial", Font.PLAIN, 25));
		PBB_account.setBackground(new Color(224, 255, 255));
		PBB_account.setBounds(537, 167, 282, 108);
		menuPane.add(PBB_account);
		PBB_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountPage();
				cardLayout.show(contentPane, "Account");
			}
		});
		
		PBB_myTimetable.setIcon(new ImageIcon(getClass().getResource("timetable.png")));
		PBB_myTimetable.setBackground(new Color(224, 255, 255));
		PBB_myTimetable.setFont(new Font("Arial", Font.PLAIN, 25));
		PBB_myTimetable.setBounds(537, 167, 282, 108);
		menuPane.add(PBB_myTimetable);
		PBB_myTimetable.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//
			}
		});
		
		PBP_show.setBackground(new Color(255, 228, 181));
		PBP_show.setBounds(33, 388, 879, 186);
		p_bookingPane.add(PBP_show);
		PBP_show.setLayout(null);
		
		JLabel lblBookingLog = new JLabel("Booking log");
		lblBookingLog.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBookingLog.setFont(new Font("Arial", Font.PLAIN, 20));
		lblBookingLog.setBounds(10, 10, 125, 24);
		PBP_show.add(lblBookingLog);
		
		PBP_choose.setBackground(new Color(255, 228, 181));
		PBP_choose.setBounds(531, 89, 302, 275);
		p_bookingPane.add(PBP_choose);
		PBP_choose.setLayout(null);
		
		PBL_choose.setBounds(10, 44, 282, 221);
		PBP_choose.add(PBL_choose);
		
		JLabel lblStartTime = new JLabel("Start time");
		lblStartTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartTime.setFont(new Font("Arial", Font.PLAIN, 20));
		lblStartTime.setBounds(10, 10, 86, 24);
		PBP_choose.add(lblStartTime);
		
		PBT_model = (DefaultTableModel) PBT_table.getModel();
		PBT_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PBT_table.setFont(new Font("Arial", Font.PLAIN, 18));
		PBT_table.setBackground(SystemColor.activeCaption);
		PBT_table.setPreferredScrollableViewportSize(new Dimension(850, 150));
		PBT_table.setFillsViewportHeight(true);
		JScrollPane PBjp = new JScrollPane(PBT_table);
		PBjp.setFont(new Font("Arial", Font.PLAIN, 18));
		PBP_show.add(PBjp);
		
		
		//treatment
		TtCB_text.setBounds(20, 44, 256, 24);
		JP_treatmentType.add(TtCB_text);
		
		TbT_text = new JTextField();
		TbT_text.setFont(new Font("Arial", Font.PLAIN, 20));
		TbT_text.setColumns(10);
		TbT_text.setBounds(20, 44, 256, 24);
		JP_bodyPart.add(TbT_text);
		
		TTP_remark.setBounds(10, 50, 426, 24);
		TTP_remark.setColumns(10);
		JP_remark.add(TTP_remark);
		
		Tlbl_total.setFont(new Font("Arial", Font.PLAIN, 20));
		Tlbl_total.setBounds(143, 14, 123, 24);
		JP_fee.add(Tlbl_total);
		
		Tlbl_Sub_total.setFont(new Font("Arial", Font.PLAIN, 20));
		Tlbl_Sub_total.setBounds(143, 48, 123, 24);
		JP_fee.add(Tlbl_Sub_total);
		
		JP_treatmentType.setBackground(new Color(255, 228, 181));
		JP_treatmentType.setBounds(73, 118, 286, 133);
		treatmentPane.add(JP_treatmentType);
		JP_treatmentType.setLayout(null);
		
		JP_bodyPart.setBackground(new Color(255, 228, 181));
		JP_bodyPart.setLayout(null);
		JP_bodyPart.setBounds(73, 318, 286, 133);
		treatmentPane.add(JP_bodyPart);
		
		JLabel lblEnterBodyParts = new JLabel("Enter body parts");
		lblEnterBodyParts.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEnterBodyParts.setBounds(11, 10, 193, 24);
		JP_bodyPart.add(lblEnterBodyParts);
		
		JP_treatTable.setBounds(410, 94, 254, 285);
		treatmentPane.add(JP_treatTable);
		JP_treatTable.setLayout(null);
		TtL_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
		TtL_list.setBounds(10, 44, 234, 227);
		JP_treatTable.add(TtL_list);
		
		JLabel lbl_type = new JLabel("Type of Treatment");
		lbl_type.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_type.setBounds(10, 10, 170, 24);
		JP_treatTable.add(lbl_type);
		
		JP_bodyTable.setBounds(697, 94, 254, 285);
		treatmentPane.add(JP_bodyTable);
		JP_bodyTable.setLayout(null);
		
		JLabel lbl_bodyPart = new JLabel("Body Parts");
		lbl_bodyPart.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_bodyPart.setBounds(10, 10, 170, 24);
		JP_bodyTable.add(lbl_bodyPart);
		TbL_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TbL_list.setBounds(10, 44, 234, 227);
		JP_bodyTable.add(TbL_list);
		
		JP_remark.setBackground(new Color(255, 228, 181));
		JP_remark.setBounds(73, 483, 446, 99);
		treatmentPane.add(JP_remark);
		JP_remark.setLayout(null);
		
		JP_fee.setBackground(new Color(255, 228, 181));
		JP_fee.setBounds(558, 453, 392, 90);
		treatmentPane.add(JP_fee);
		JP_fee.setLayout(null);
		
		
		//OH
		OHB_clinic.setFont(new Font("Arial", Font.PLAIN, 20));
		OHB_clinic.setBackground(new Color(255, 192, 203));
		OHB_clinic.setBounds(806, 552, 143, 47);
		c_OHPane.add(OHB_clinic);
		
		JLabel lblAmSession = new JLabel("A.M. session");
		lblAmSession.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAmSession.setBounds(65, 119, 123, 24);
		c_OHPane.add(lblAmSession);
		
		JLabel lblPmSession = new JLabel("P.M. session");
		lblPmSession.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPmSession.setBounds(65, 161, 123, 24);
		c_OHPane.add(lblPmSession);
		
		OHT_AS.setFont(new Font("Arial", Font.PLAIN, 20));
		OHT_AS.setBounds(227, 119, 96, 24);
		c_OHPane.add(OHT_AS);
		OHT_AS.setColumns(10);
		
		
		OHT_AE.setFont(new Font("Arial", Font.PLAIN, 20));
		OHT_AE.setColumns(10);
		OHT_AE.setBounds(386, 119, 96, 24);
		c_OHPane.add(OHT_AE);
		
		
		OHT_PS.setFont(new Font("Arial", Font.PLAIN, 20));
		OHT_PS.setColumns(10);
		OHT_PS.setBounds(227, 166, 96, 24);
		c_OHPane.add(OHT_PS);
		
		
		OHT_PE.setFont(new Font("Arial", Font.PLAIN, 20));
		OHT_PE.setColumns(10);
		OHT_PE.setBounds(386, 166, 96, 24);
		c_OHPane.add(OHT_PE);
		
		OHT_np1.setFont(new Font("Arial", Font.PLAIN, 20));
		OHT_np1.setColumns(10);
		OHT_np1.setBounds(117, 512, 96, 24);
		c_OHPane.add(OHT_np1);
		
		OHT_np2.setFont(new Font("Arial", Font.PLAIN, 20));
		OHT_np2.setColumns(10);
		OHT_np2.setBounds(262, 512, 96, 24);
		c_OHPane.add(OHT_np2);
		
		OHT_np3.setFont(new Font("Arial", Font.PLAIN, 20));
		OHT_np3.setColumns(10);
		OHT_np3.setBounds(117, 559, 96, 24);
		c_OHPane.add(OHT_np3);
		
		OHT_np4.setFont(new Font("Arial", Font.PLAIN, 20));
		OHT_np4.setColumns(10);
		OHT_np4.setBounds(262, 559, 96, 24);
		c_OHPane.add(OHT_np4);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTo.setBounds(342, 119, 25, 24);
		c_OHPane.add(lblTo);
		
		JLabel label = new JLabel("to");
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setBounds(342, 166, 25, 24);
		c_OHPane.add(label);
		
		JLabel lblMon = new JLabel("Mon");
		lblMon.setHorizontalAlignment(SwingConstants.CENTER);
		lblMon.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMon.setBounds(201, 246, 60, 24);
		c_OHPane.add(lblMon);
		
		JLabel lblTue = new JLabel("Tue");
		lblTue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTue.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTue.setBounds(288, 246, 60, 24);
		c_OHPane.add(lblTue);
		
		JLabel lblWed = new JLabel("Wed");
		lblWed.setHorizontalAlignment(SwingConstants.CENTER);
		lblWed.setFont(new Font("Arial", Font.PLAIN, 20));
		lblWed.setBounds(375, 246, 60, 24);
		c_OHPane.add(lblWed);
		
		JLabel lblThu = new JLabel("Thu");
		lblThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblThu.setFont(new Font("Arial", Font.PLAIN, 20));
		lblThu.setBounds(462, 246, 60, 24);
		c_OHPane.add(lblThu);
		
		JLabel lblFri = new JLabel("Fri");
		lblFri.setHorizontalAlignment(SwingConstants.CENTER);
		lblFri.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFri.setBounds(549, 246, 60, 24);
		c_OHPane.add(lblFri);
		
		JLabel lblSat = new JLabel("Sat");
		lblSat.setHorizontalAlignment(SwingConstants.CENTER);
		lblSat.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSat.setBounds(636, 246, 60, 24);
		c_OHPane.add(lblSat);
		
		JLabel lblSun = new JLabel("Sun");
		lblSun.setHorizontalAlignment(SwingConstants.CENTER);
		lblSun.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSun.setBounds(723, 246, 60, 24);
		c_OHPane.add(lblSun);
		
		JLabel lblAm = new JLabel("A.M.");
		lblAm.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAm.setBounds(106, 301, 60, 24);
		c_OHPane.add(lblAm);
		
		JLabel lblPm = new JLabel("P.M.");
		lblPm.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPm.setBounds(106, 352, 60, 24);
		c_OHPane.add(lblPm);
		
		OH1.setHorizontalAlignment(SwingConstants.CENTER);
		OH1.setBackground(new Color(152, 251, 152));
		OH1.setBounds(201, 301, 60, 24);
		c_OHPane.add(OH1);
		
		OH3.setHorizontalAlignment(SwingConstants.CENTER);
		OH3.setBackground(new Color(152, 251, 152));
		OH3.setBounds(288, 301, 60, 24);
		c_OHPane.add(OH3);
		
		OH5.setHorizontalAlignment(SwingConstants.CENTER);
		OH5.setBackground(new Color(152, 251, 152));
		OH5.setBounds(375, 301, 60, 24);
		c_OHPane.add(OH5);
		
		OH7.setHorizontalAlignment(SwingConstants.CENTER);
		OH7.setBackground(new Color(152, 251, 152));
		OH7.setBounds(462, 301, 60, 24);
		c_OHPane.add(OH7);
		
		OH9.setHorizontalAlignment(SwingConstants.CENTER);
		OH9.setBackground(new Color(152, 251, 152));
		OH9.setBounds(549, 301, 60, 24);
		c_OHPane.add(OH9);
		
		OH11.setHorizontalAlignment(SwingConstants.CENTER);
		OH11.setBackground(new Color(152, 251, 152));
		OH11.setBounds(636, 301, 60, 24);
		c_OHPane.add(OH11);
		
		OH13.setHorizontalAlignment(SwingConstants.CENTER);
		OH13.setBackground(new Color(152, 251, 152));
		OH13.setBounds(723, 305, 60, 24);
		c_OHPane.add(OH13);
		
		OH2.setHorizontalAlignment(SwingConstants.CENTER);
		OH2.setBackground(new Color(152, 251, 152));
		OH2.setBounds(201, 352, 60, 24);
		c_OHPane.add(OH2);
		
		OH4.setHorizontalAlignment(SwingConstants.CENTER);
		OH4.setBackground(new Color(152, 251, 152));
		OH4.setBounds(288, 352, 60, 24);
		c_OHPane.add(OH4);
		
		OH6.setHorizontalAlignment(SwingConstants.CENTER);
		OH6.setBackground(new Color(152, 251, 152));
		OH6.setBounds(375, 352, 60, 24);
		c_OHPane.add(OH6);
		
		OH8.setHorizontalAlignment(SwingConstants.CENTER);
		OH8.setBackground(new Color(152, 251, 152));
		OH8.setBounds(462, 352, 60, 24);
		c_OHPane.add(OH8);
		
		OH10.setHorizontalAlignment(SwingConstants.CENTER);
		OH10.setBackground(new Color(152, 251, 152));
		OH10.setBounds(549, 352, 60, 24);
		c_OHPane.add(OH10);
		
		OH12.setHorizontalAlignment(SwingConstants.CENTER);
		OH12.setBackground(new Color(152, 251, 152));
		OH12.setBounds(636, 352, 60, 24);
		c_OHPane.add(OH12);
		
		OH14.setHorizontalAlignment(SwingConstants.CENTER);
		OH14.setBackground(new Color(152, 251, 152));
		OH14.setBounds(723, 356, 60, 24);
		c_OHPane.add(OH14);
		
		OHB_save.setFont(new Font("Arial", Font.PLAIN, 20));
		OHB_save.setBounds(640, 552, 143, 47);
		c_OHPane.add(OHB_save);
		
		JLabel lblNonpeakHour = new JLabel("Non-Peak hour");
		lblNonpeakHour.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNonpeakHour.setBounds(65, 468, 148, 24);
		c_OHPane.add(lblNonpeakHour);
		
		JLabel label_3 = new JLabel("to");
		label_3.setFont(new Font("Arial", Font.PLAIN, 20));
		label_3.setBounds(227, 512, 25, 24);
		c_OHPane.add(label_3);
		
		JLabel label_4 = new JLabel("to");
		label_4.setFont(new Font("Arial", Font.PLAIN, 20));
		label_4.setBounds(227, 559, 25, 24);
		c_OHPane.add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(53, 108, 446, 94);
		c_OHPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(152, 251, 152));
		panel_1.setBounds(90, 239, 716, 151);
		c_OHPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(152, 251, 152));
		panel_2.setBounds(50, 457, 335, 147);
		c_OHPane.add(panel_2);
		
		
		//MT
		MTP_pane.setBackground(new Color(152, 251, 152));
		MTP_pane.setBounds(479, 107, 448, 390);
		MTP_pane.setLayout(new FlowLayout());
		c_MTPane.add(MTP_pane);
		MTTa_model = (DefaultTableModel) MTTa_table.getModel();
		MTTa_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MTTa_table.setFont(new Font("Arial", Font.PLAIN, 18));
		MTTa_table.setBackground(SystemColor.activeCaption);
		MTTa_table.setPreferredScrollableViewportSize(new Dimension(400, 350));
		MTTa_table.setFillsViewportHeight(true);
		JScrollPane MTjp = new JScrollPane(MTTa_table);
		MTjp.setFont(new Font("Arial", Font.PLAIN, 18));
		MTP_pane.add(MTjp);
		
		MTT_treat.setFont(new Font("Arial", Font.PLAIN, 20));
		MTT_treat.setColumns(10);
		MTT_treat.setBounds(185, 131, 240, 47);
		c_MTPane.add(MTT_treat);
		
		MTT_fpp.setFont(new Font("Arial", Font.PLAIN, 20));
		MTT_fpp.setColumns(10);
		MTT_fpp.setBounds(187, 237, 238, 47);
		c_MTPane.add(MTT_fpp);
		
		MTC_bp.setBackground(SystemColor.activeCaption);
		MTC_bp.setHorizontalAlignment(SwingConstants.CENTER);
		MTC_bp.setBounds(187, 350, 240, 47);
		c_MTPane.add(MTC_bp);
		TLP_treatmentRec.setBackground(SystemColor.activeCaption);
		
		MTB_save.setFont(new Font("Arial", Font.PLAIN, 20));
		MTB_save.setBounds(235, 548, 143, 47);
		c_MTPane.add(MTB_save);
		
		MTB_add.setFont(new Font("Arial", Font.PLAIN, 20));
		MTB_add.setBounds(63, 548, 143, 47);
		c_MTPane.add(MTB_add);
		
		MTB_delete.setFont(new Font("Arial", Font.PLAIN, 20));
		MTB_delete.setBounds(405, 548, 143, 47);
		c_MTPane.add(MTB_delete);
		
		MTB_clinic.setFont(new Font("Arial", Font.PLAIN, 20));
		MTB_clinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Clinic");
			}
		});
		MTB_clinic.setBackground(new Color(255, 192, 203));
		MTB_clinic.setBounds(797, 576, 143, 47);
		c_MTPane.add(MTB_clinic);
		
		//SC
		SCT_p50.setHorizontalAlignment(SwingConstants.CENTER);
		SCT_p50.setFont(new Font("Arial", Font.PLAIN, 20));
		SCT_p50.setBounds(458, 237, 143, 47);
		c_SCPane.add(SCT_p50);
		SCT_p50.setColumns(10);
		
		SCT_p18.setHorizontalAlignment(SwingConstants.CENTER);
		SCT_p18.setFont(new Font("Arial", Font.PLAIN, 20));
		SCT_p18.setColumns(10);
		SCT_p18.setBounds(458, 307, 143, 47);
		c_SCPane.add(SCT_p18);
		
		SCT_np.setHorizontalAlignment(SwingConstants.CENTER);
		SCT_np.setFont(new Font("Arial", Font.PLAIN, 20));
		SCT_np.setColumns(10);
		SCT_np.setBounds(458, 374, 143, 47);
		c_SCPane.add(SCT_np);
		
		SCB_update.setFont(new Font("Arial", Font.PLAIN, 20));
		SCB_update.setBounds(419, 489, 143, 47);
		c_SCPane.add(SCB_update);
		
		SCB_save.setFont(new Font("Arial", Font.PLAIN, 20));
		SCB_save.setBounds(138, 489, 143, 47);
		c_SCPane.add(SCB_save);
		
		B_clinic.setFont(new Font("Arial", Font.PLAIN, 20));
		B_clinic.setBackground(new Color(255, 192, 203));
		B_clinic.setBounds(700, 489, 143, 47);
		c_SCPane.add(B_clinic);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(152, 251, 152));
		panel_3.setBounds(221, 154, 400, 283);
		c_SCPane.add(panel_3);
		
		
		//log
		TLP_treatmentRec.setBounds(23, 90, 937, 260);
		TLP_treatmentRec.setLayout(new FlowLayout());
		logPane.add(TLP_treatmentRec);
		TLTa_model = (DefaultTableModel) TLTa_table.getModel();
		TLTa_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TLTa_table.setFont(new Font("Arial", Font.PLAIN, 18));
		TLTa_table.setBackground(SystemColor.activeCaption);
		TLTa_table.setPreferredScrollableViewportSize(new Dimension(900, 220));
		TLTa_table.setFillsViewportHeight(true);
		JScrollPane TLjp = new JScrollPane(TLTa_table);
		TLjp.setFont(new Font("Arial", Font.PLAIN, 18));
		TLP_treatmentRec.add(TLjp);
		
		TLP_bodyParts.setBackground(SystemColor.activeCaption);
		TLP_bodyParts.setBounds(37, 389, 229, 238);
		logPane.add(TLP_bodyParts);
		TLP_bodyParts.setLayout(null);
		
		JLabel lblBodyParts = new JLabel("Body Parts");
		lblBodyParts.setFont(new Font("Arial", Font.PLAIN, 20));
		lblBodyParts.setBounds(10, 10, 98, 24);
		TLP_bodyParts.add(lblBodyParts);
		
		TLL_list.setBounds(10, 44, 209, 184);
		TLP_bodyParts.add(TLL_list);
		
		TLP_remarks.setLayout(null);
		TLP_remarks.setBackground(SystemColor.activeCaption);
		TLP_remarks.setBounds(316, 389, 229, 238);
		logPane.add(TLP_remarks);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRemarks.setBounds(10, 10, 98, 24);
		TLP_remarks.add(lblRemarks);
		TLTP_remarks.setFont(new Font("Arial", Font.PLAIN, 20));
		TLTP_remarks.setVerticalAlignment(SwingConstants.TOP);
		
		TLTP_remarks.setBounds(10, 44, 209, 184);
		TLP_remarks.add(TLTP_remarks);
		
		JButton TLB_patient = new JButton("Patient");
		TLB_patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Patient");
			}
		});
		TLB_patient.setFont(new Font("Arial", Font.PLAIN, 20));
		TLB_patient.setBackground(new Color(255, 192, 203));
		TLB_patient.setBounds(817, 580, 143, 47);
		logPane.add(TLB_patient);
		
		//account
		AST_name.setBounds(191, 223, 181, 24);
		accountPane.add(AST_name);
		AST_name.setColumns(10);
		
		AST_userName.setColumns(10);
		AST_userName.setBounds(191, 285, 181, 24);
		accountPane.add(AST_userName);
		
		AST_password.setColumns(10);
		AST_password.setBounds(191, 347, 181, 24);
		accountPane.add(AST_password);
		
		AST_room.setColumns(10);
		AST_room.setBounds(191, 409, 181, 24);
		accountPane.add(AST_room);
		
		ASB_save.setFont(new Font("Arial", Font.PLAIN, 20));
		ASB_save.setBounds(172, 495, 121, 47);
		accountPane.add(ASB_save);
		
		ASR_doctor.setFont(new Font("Arial", Font.PLAIN, 20));
		ASR_doctor.setBackground(SystemColor.activeCaption);
		ASR_doctor.setBounds(161, 128, 92, 41);
		accountPane.add(ASR_doctor);
		
		ASR_admin.setFont(new Font("Arial", Font.PLAIN, 20));
		ASR_admin.setBackground(SystemColor.activeCaption);
		ASR_admin.setBounds(280, 128, 92, 41);
		accountPane.add(ASR_admin);
		
		ASRG_radiogp.add(ASR_doctor);
		ASRG_radiogp.add(ASR_admin);
		
		ASB_add.setFont(new Font("Arial", Font.PLAIN, 20));
		ASB_add.setBounds(24, 495, 121, 47);
		accountPane.add(ASB_add);
		
		ASP_pane.setBackground(SystemColor.activeCaption);
		ASP_pane.setBounds(472, 128, 286, 426);
		accountPane.add(ASP_pane);
		ASP_pane.setLayout(null);
		
		ASL_doctor.setBounds(10, 37, 266, 177);
		ASP_pane.add(ASL_doctor);
		
		ASL_admin.setBounds(10, 225, 266, 190);
		ASP_pane.add(ASL_admin);
		
		
		ASB_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPane, "Menu");
			}
		});
		ASB_menu.setFont(new Font("Arial", Font.PLAIN, 25));
		ASB_menu.setBackground(new Color(255, 192, 203));
		ASB_menu.setBounds(799, 566, 121, 47);
		accountPane.add(ASB_menu);
		
		ASB_delete.setFont(new Font("Arial", Font.PLAIN, 20));
		ASB_delete.setBounds(320, 495, 121, 47);
		accountPane.add(ASB_delete);

	}
	//*******************Construct Label and Button**************************

	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public MyWindow(Db db, LogAc logAc) throws ParseException {
		this.db = db;
		this.logAc = logAc;
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
		contentPane.add(patientPane, "Patient");
		p_bookingPage();
		contentPane.add(p_bookingPane, "Booking");
		clinicPage();
		contentPane.add(clinicPane, "Clinic");
		c_SCPage();
		contentPane.add(c_SCPane, "c_SC");
		c_MTPage();
		contentPane.add(c_MTPane, "c_MT");
		c_OHPage();
		contentPane.add(c_OHPane, "c_OH");
		timetablePage();
		contentPane.add(timetablePane, "Timetable");
		accountPage();
		contentPane.add(accountPane, "Account");
		treatmentPage();
		contentPane.add(treatmentPane, "Treatment");
		logPage();
		contentPane.add(logPane, "Log");
		
		addToWindow();

		cardLayout.show(contentPane, "Login");
	}
}
