import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;


public class specialconditionpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					specialconditionpage frame = new specialconditionpage();
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
	public specialconditionpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientAtAge = new JLabel("Patient at age > 50 :");
		lblPatientAtAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPatientAtAge.setBounds(271, 190, 167, 52);
		contentPane.add(lblPatientAtAge);
		
		JLabel lblPatientAtAge_1 = new JLabel("Patient at age < 18 :");
		lblPatientAtAge_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPatientAtAge_1.setBounds(271, 244, 188, 52);
		contentPane.add(lblPatientAtAge_1);
		
		JLabel lblNonpeakHour = new JLabel("Non-Peak hour :");
		lblNonpeakHour.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNonpeakHour.setBounds(296, 309, 142, 43);
		contentPane.add(lblNonpeakHour);
		
		textField = new JTextField();
		textField.setBounds(478, 198, 167, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Discount");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(503, 141, 116, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(322, 424, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(519, 424, 89, 23);
		contentPane.add(btnSave);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(478, 252, 167, 43);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(478, 312, 167, 43);
		contentPane.add(textField_2);
		
		JLabel lblSpecialArrangement = new JLabel("Special Arrangement");
		lblSpecialArrangement.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblSpecialArrangement.setBounds(291, 31, 377, 72);
		contentPane.add(lblSpecialArrangement);
	}
}
