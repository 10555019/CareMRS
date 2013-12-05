import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;


public class Treatmenttype extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Treatmentint1 frame = new Treatmentint1();
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
	public Treatmenttype() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTreatment = new JLabel("(Type of treatment)");
		lblTreatment.setForeground(Color.BLUE);
		lblTreatment.setBounds(306, 36, 335, 47);
		lblTreatment.setFont(new Font("新細明體", Font.BOLD, 38));
		contentPane.add(lblTreatment);
		
		JButton btnMenu = new JButton("Back");
		btnMenu.setForeground(Color.BLUE);
		btnMenu.setBounds(879, 610, 81, 31);
		btnMenu.setBackground(Color.WHITE);
		contentPane.add(btnMenu);
		
		textField = new JTextField();
		textField.setBounds(30, 550, 824, 91);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setBounds(879, 580, 81, 31);
		btnUpdate.setBackground(Color.WHITE);
		contentPane.add(btnUpdate);
		
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(Color.BLUE);
		btnSave.setBounds(879, 550, 81, 31);
		btnSave.setBackground(Color.WHITE);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("Remark:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(30, 519, 86, 31);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblTotal = new JLabel("Total: $");
		lblTotal.setForeground(Color.BLUE);
		lblTotal.setFont(new Font("新細明體", Font.BOLD, 15));
		lblTotal.setBounds(30, 478, 191, 31);
		contentPane.add(lblTotal);
		
		JLabel lblFundamentalCost = new JLabel("Fundamental cost: $");
		lblFundamentalCost.setForeground(Color.BLUE);
		lblFundamentalCost.setFont(new Font("新細明體", Font.BOLD, 15));
		lblFundamentalCost.setBounds(30, 94, 191, 31);
		contentPane.add(lblFundamentalCost);
		
		JLabel lblFeePerPart = new JLabel("Fee per part: $");
		lblFeePerPart.setForeground(Color.BLUE);
		lblFeePerPart.setFont(new Font("新細明體", Font.BOLD, 15));
		lblFeePerPart.setBounds(30, 129, 191, 31);
		contentPane.add(lblFeePerPart);
		
		JLabel lblNumberOfParts = new JLabel("Number of part(s): ");
		lblNumberOfParts.setForeground(Color.BLUE);
		lblNumberOfParts.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNumberOfParts.setBounds(30, 163, 191, 31);
		contentPane.add(lblNumberOfParts);
		
		JLabel lblSubtotal = new JLabel("Subtotal: $");
		lblSubtotal.setForeground(Color.BLUE);
		lblSubtotal.setFont(new Font("新細明體", Font.BOLD, 15));
		lblSubtotal.setBounds(30, 446, 191, 31);
		contentPane.add(lblSubtotal);
		
		JLabel lblBodyParts = new JLabel("Body part(s):");
		lblBodyParts.setForeground(Color.BLUE);
		lblBodyParts.setFont(new Font("新細明體", Font.BOLD, 15));
		lblBodyParts.setBounds(30, 224, 191, 31);
		contentPane.add(lblBodyParts);
		
		textField_1 = new JTextField();
		textField_1.setBounds(30, 265, 191, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(231, 265, 191, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(432, 265, 191, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(633, 265, 191, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(30, 296, 191, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(30, 327, 191, 21);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(30, 358, 191, 21);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(30, 389, 191, 21);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(30, 420, 191, 21);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(231, 296, 191, 21);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(231, 327, 191, 21);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(231, 358, 191, 21);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(231, 389, 191, 21);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(231, 420, 191, 21);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(432, 296, 191, 21);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(432, 327, 191, 21);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(432, 358, 191, 21);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(432, 389, 191, 21);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(432, 420, 191, 21);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(633, 296, 191, 21);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(633, 327, 191, 21);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(633, 358, 191, 21);
		contentPane.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(633, 389, 191, 21);
		contentPane.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(633, 420, 191, 21);
		contentPane.add(textField_24);
	}
}
