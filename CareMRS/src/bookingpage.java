import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;


public class bookingpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookingpage frame = new bookingpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bookingpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(107, 62, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setBounds(32, 65, 46, 14);
		contentPane.add(lblDoctorId);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(30, 90, 53, 14);
		contentPane.add(lblPatientId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(107, 93, 86, 20);
		contentPane.add(textField_1);
		
		table = new JTable();
		table.setBounds(32, 150, 751, 456);
		contentPane.add(table);
		
		JLabel lblDate = new JLabel("Date(MM/YYYY)");
		lblDate.setBounds(265, 65, 106, 14);
		contentPane.add(lblDate);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(434, 62, 106, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(550, 62, 106, 20);
		contentPane.add(comboBox_2);
	}
}
