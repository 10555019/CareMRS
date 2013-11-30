import java.awt.CardLayout;

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

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MyWindow extends JFrame {

	//**********Data Member of MyWindow**********//
	private JPanel contentPane;
	private JPanel loginPane;
	private JPanel menuPane;
	private JPanel p_searchPane;
	private JPanel patientPane;
	private JPanel p_bookingPane;

	CardLayout cardLayout = new CardLayout();

	private JMenuBar menubar = new JMenuBar();

	private Patient patient;
	//**********Data Member of MyWindow**********//

	private void menubar(){
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
	private void login(String userName, char[] password, JTextField userNameField, JPasswordField passwordField){
		userNameField.setText("");
		passwordField.setText("");
		if (Doctor.checkLogin(userName,password)){
			Care.db = Care.db.load();
			cardLayout.show(contentPane, "Menu");
			setJMenuBar(menubar);
		}
		else
			JOptionPane.showMessageDialog(null, "Please retry","Login Failed", JOptionPane.ERROR_MESSAGE);
	}

	//Logout method
	private void logout(){
		Care.db.save();
		cardLayout.show(contentPane, "Login");
		setJMenuBar(null);
	}
	
	//**********************************************************************
	//******************************Login Page******************************
	//**********************************************************************
	private void loginPage(){
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
				login(userNameField.getText(),passwordField.getPassword(),userNameField,passwordField);
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
				if (key == KeyEvent.VK_ENTER) {
					login(userNameField.getText(),passwordField.getPassword(),userNameField,passwordField);
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
		B_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				logout();
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
	private void p_searchPage(){
		p_searchPane = new JPanel();
		p_searchPane.setBackground(SystemColor.activeCaption);
		p_searchPane.setLayout(null);
		
		JLabel lbl_searchPatient = new JLabel("Search Patient");
		lbl_searchPatient.setFont(new Font("Arial", Font.BOLD, 30));
		lbl_searchPatient.setBounds(376, 20, 221, 41);
		p_searchPane.add(lbl_searchPatient);

		MaskFormatter idFormatter;
		try {
			idFormatter = new MaskFormatter("U######'(#')");
			JLabel lbl_HKID = new JLabel("HKID:");
			lbl_HKID.setFont(new Font("Arial", Font.PLAIN, 25));
			lbl_HKID.setBounds(343, 253, 80, 41);
			p_searchPane.add(lbl_HKID);
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
			
			JButton B_search = new JButton("Search");
			B_search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//**********
					//**
					//** Method: call search method here
					//**
					//** patient = Patient.search(.....);
					//**********				
					T_HKID.setText("");
					cardLayout.show(contentPane, "Patient");
				}
			});
			B_search.setFont(new Font("Arial", Font.PLAIN, 25));
			B_search.setBounds(230, 366, 142, 70);
			p_searchPane.add(B_search);
			
			JButton B_menu = new JButton("Menu");
			B_menu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					T_HKID.setText("");
					cardLayout.show(contentPane, "Menu");
				}
			});
			B_menu.setFont(new Font("Arial", Font.PLAIN, 25));
			B_menu.setBounds(602, 366, 142, 70);
			p_searchPane.add(B_menu);

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Unable to add ID Field","Failed", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
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
		JPanel color1 = new JPanel();
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

		final JTextField T_name = new JTextField();
		T_name.setBounds(179, 30, 501, 32);
		color1.add(T_name);
		T_name.setFont(new Font("Arial", Font.PLAIN, 20));
		T_name.setColumns(10);

		//*****HKID*****
		JLabel lbl_HKID = new JLabel("HKID:");
		lbl_HKID.setBounds(36, 112, 133, 32);
		color1.add(lbl_HKID);
		lbl_HKID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_HKID.setFont(new Font("Arial", Font.PLAIN, 20));

		MaskFormatter idFormatter = new MaskFormatter("U######'(#')");
		final JFormattedTextField T_HKID = new JFormattedTextField(idFormatter);
		T_HKID.setText("");
		T_HKID.setFont(new Font("Arial", Font.PLAIN, 25));
		T_HKID.setBounds(179,112,163,32);
		color1.add(T_HKID);
		T_HKID.setColumns(10);

		//*****Gender*****
		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setBounds(373, 112, 133, 32);
		color1.add(lbl_gender);
		lbl_gender.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_gender.setFont(new Font("Arial", Font.PLAIN, 20));

		final JTextField T_gender = new JTextField();
		T_gender.setBounds(547, 112, 133, 32);
		color1.add(T_gender);
		T_gender.setFont(new Font("Arial", Font.PLAIN, 20));
		T_gender.setColumns(10);

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

		MaskFormatter dateFormatter = new MaskFormatter("##'/##'/####");
		final JFormattedTextField T_dob = new JFormattedTextField(dateFormatter);
		T_dob.setText("");
		T_dob.setFont(new Font("Arial", Font.PLAIN, 25));
		T_dob.setBounds(179,194,163,32);
		color1.add(T_dob);
		T_dob.setColumns(10);

		//*****Tel*****
		JLabel lbl_tel = new JLabel("Telephone:");
		lbl_tel.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tel.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_tel.setBounds(373, 194, 133, 32);
		color1.add(lbl_tel);

		MaskFormatter telFormatter = new MaskFormatter("####' ####");
		final JFormattedTextField T_tel = new JFormattedTextField(telFormatter);
		T_tel.setText("");
		T_tel.setFont(new Font("Arial", Font.PLAIN, 25));
		T_tel.setBounds(516,194,164,32);
		color1.add(T_tel);
		T_tel.setColumns(10);

		//*****B_save*****
		JButton B_save = new JButton("Save");
		B_save.setBounds(693, 227, 98, 32);
		color1.add(B_save);
		B_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//**********
				//**
				//** Method: change patient record
				//**
				//**********
				try{
					if (T_HKID.getText().equals("")) throw new NullFieldException(); //primary key should not be null
					if (patient==null){
						//need to create a new patient
						//patient = new Patient(T_name.getText(),T_HKID.getText(),T_telephone.getText(),T_gender.getText().charAt(0),);
					} else {
						//amend current patient record

					}
					JOptionPane.showMessageDialog(null, "Patient records have been saved","Patient record", JOptionPane.PLAIN_MESSAGE);
					T_name.setEditable(false);
					T_HKID.setEditable(false);
					T_gender.setEditable(false);
					T_tel.setEditable(false);
					T_dob.setEditable(false);
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
				T_name.setEditable(true);
				T_HKID.setEditable(true);
				T_gender.setEditable(true);
				T_tel.setEditable(true);
				T_dob.setEditable(true);
			}
		});
		B_update.setFont(new Font("Arial", Font.PLAIN, 20));

		//*****action button*****
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

		//after search patient, get and show the patient record
		if (patient != null){
			T_name.setText(patient.getName());
			T_HKID.setText(patient.getHKID());
			T_gender.setText(Character.toString(patient.getGender()));
			T_dob.setText(patient.getDob_S());
			T_name.setEditable(false);
			T_HKID.setEditable(false);
			T_gender.setEditable(false);
			T_tel.setEditable(false);
			T_dob.setEditable(false);
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
	}
	//***********************************************************************
	//***********************Patient booking Page****************************
	//***********************************************************************

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public MyWindow() throws ParseException {
		setResizable(false);

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
		menubar();
		loginPage();
		contentPane.add(loginPane, "Login");
		menuPage();
		contentPane.add(menuPane, "Menu");
		p_searchPage();
		contentPane.add(p_searchPane, "Search");
		patientPage();
		contentPane.add(patientPane, "Patient");
		p_searchPage();
		p_bookingPage();
		contentPane.add(p_bookingPane, "Booking");

		cardLayout.show(contentPane, "Login");
	}
}