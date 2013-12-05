import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.UIManager;


public class Treatmentint1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	public Treatmentint1() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTreatment = new JLabel("Treatment");
		lblTreatment.setForeground(Color.BLUE);
		lblTreatment.setBounds(383, 36, 174, 47);
		lblTreatment.setFont(new Font("新細明體", Font.BOLD, 38));
		contentPane.add(lblTreatment);
		
		JButton btnNewButton = new JButton("Herbal");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(163, 129, 206, 59);
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 25));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnAcupuncture = new JButton("Acupuncture");
		btnAcupuncture.setForeground(Color.BLUE);
		btnAcupuncture.setBounds(579, 129, 206, 59);
		btnAcupuncture.setFont(new Font("新細明體", Font.BOLD, 25));
		btnAcupuncture.setBackground(Color.WHITE);
		contentPane.add(btnAcupuncture);
		
		JButton btnCupping = new JButton("Cupping");
		btnCupping.setForeground(Color.BLUE);
		btnCupping.setBounds(163, 339, 206, 59);
		btnCupping.setFont(new Font("新細明體", Font.BOLD, 25));
		btnCupping.setBackground(Color.WHITE);
		contentPane.add(btnCupping);
		
		JButton btnBonesetting = new JButton("Bone-setting");
		btnBonesetting.setForeground(Color.BLUE);
		btnBonesetting.setBounds(579, 339, 206, 59);
		btnBonesetting.setFont(new Font("新細明體", Font.BOLD, 25));
		btnBonesetting.setBackground(Color.WHITE);
		contentPane.add(btnBonesetting);
		
		JButton btnMenu = new JButton("Menu");
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
		
		JTextPane txtpnFundamentalCost = new JTextPane();
		txtpnFundamentalCost.setForeground(Color.BLUE);
		txtpnFundamentalCost.setBackground(Color.ORANGE);
		txtpnFundamentalCost.setText("Fundamental cost: $\r\nFee per part: $\r\nNumber of part(s): \r\nSubtotal: $");
		txtpnFundamentalCost.setBounds(163, 398, 206, 66);
		contentPane.add(txtpnFundamentalCost);
		
		JTextPane txtpnFundamentalCost_1 = new JTextPane();
		txtpnFundamentalCost_1.setForeground(Color.BLUE);
		txtpnFundamentalCost_1.setText("Fundamental cost: $\r\nFee per part: $\r\nNumber of part(s): \r\nSubtotal: $");
		txtpnFundamentalCost_1.setBackground(Color.ORANGE);
		txtpnFundamentalCost_1.setBounds(163, 189, 206, 66);
		contentPane.add(txtpnFundamentalCost_1);
		
		JTextPane txtpnFundamentalCost_2 = new JTextPane();
		txtpnFundamentalCost_2.setForeground(Color.BLUE);
		txtpnFundamentalCost_2.setText("Fundamental cost: $\r\nFee per part: $\r\nNumber of part(s): \r\nSubtotal: $");
		txtpnFundamentalCost_2.setBackground(Color.ORANGE);
		txtpnFundamentalCost_2.setBounds(579, 189, 206, 66);
		contentPane.add(txtpnFundamentalCost_2);
		
		JTextPane txtpnFundamentalCost_3 = new JTextPane();
		txtpnFundamentalCost_3.setForeground(Color.BLUE);
		txtpnFundamentalCost_3.setText("Fundamental cost: $\r\nFee per part: $\r\nNumber of part(s): \r\nSubtotal: $");
		txtpnFundamentalCost_3.setBackground(Color.ORANGE);
		txtpnFundamentalCost_3.setBounds(579, 398, 206, 66);
		contentPane.add(txtpnFundamentalCost_3);
		
		JLabel lblTotal = new JLabel("Total: $");
		lblTotal.setForeground(Color.BLUE);
		lblTotal.setFont(new Font("新細明體", Font.BOLD, 15));
		lblTotal.setBounds(163, 474, 86, 31);
		contentPane.add(lblTotal);
	}
}
