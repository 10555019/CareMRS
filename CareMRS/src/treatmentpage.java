import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class treatmentpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					treatmentpage frame = new treatmentpage();
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
	public treatmentpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHerbal = new JLabel("Herbal : ");
		lblHerbal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHerbal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHerbal.setBounds(295, 149, 138, 47);
		contentPane.add(lblHerbal);
		
		JLabel lblCupping = new JLabel("Cupping : ");
		lblCupping.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCupping.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCupping.setBounds(295, 265, 138, 47);
		contentPane.add(lblCupping);
		
		JLabel lblAcupuncture = new JLabel("Acupuncture : ");
		lblAcupuncture.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcupuncture.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAcupuncture.setBounds(295, 207, 138, 47);
		contentPane.add(lblAcupuncture);
		
		JLabel lblBonesetting = new JLabel("Bone-setting : ");
		lblBonesetting.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBonesetting.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBonesetting.setBounds(295, 323, 138, 47);
		contentPane.add(lblBonesetting);
		
		textField = new JTextField();
		textField.setBounds(473, 157, 138, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(473, 215, 138, 37);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(473, 273, 138, 37);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(473, 331, 138, 37);
		contentPane.add(textField_3);
		
		JLabel lblFee = new JLabel("Fee($)");
		lblFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblFee.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFee.setBounds(473, 99, 138, 47);
		contentPane.add(lblFee);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(320, 400, 114, 54);
		contentPane.add(btnUpdate);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(478, 400, 114, 54);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("Medical treatment charge");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(247, 21, 453, 67);
		contentPane.add(lblNewLabel);
	}

}
