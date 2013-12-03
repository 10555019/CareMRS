import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;


public class aaa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aaa frame = new aaa();
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
	public aaa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBooking = new JButton("Booking");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBooking.setBounds(100, 200, 282, 108);
		contentPane.add(btnBooking);
		
		JButton btnModifyOpeningHour = new JButton("Modify Opening Hour");
		btnModifyOpeningHour.setBounds(100, 367, 282, 108);
		contentPane.add(btnModifyOpeningHour);
		
		JButton btnModifyTreatmentsOf = new JButton("Modify Treatment(s) of Patient");
		btnModifyTreatmentsOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModifyTreatmentsOf.setBounds(500, 200, 282, 108);
		contentPane.add(btnModifyTreatmentsOf);
		
		JButton btnModifySpecialCondition = new JButton("Modify Special Condition for Patient");
		btnModifySpecialCondition.setBounds(498, 367, 282, 108);
		contentPane.add(btnModifySpecialCondition);
		
		JLabel lblAdminPage = new JLabel("Admin Page");
		lblAdminPage.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		lblAdminPage.setBounds(275, 60, 310, 100);
		contentPane.add(lblAdminPage);
	}
}
