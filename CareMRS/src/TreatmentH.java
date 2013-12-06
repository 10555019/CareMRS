import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.AbstractListModel;
import javax.swing.SpinnerListModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;


public class TreatmentH extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	public TreatmentH() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTreatment = new JLabel("Type");
		lblTreatment.setForeground(Color.BLUE);
		lblTreatment.setBounds(428, 35, 117, 47);
		lblTreatment.setFont(new Font("新細明體", Font.BOLD, 38));
		contentPane.add(lblTreatment);
		
		JButton btnMenu = new JButton("Back");
		btnMenu.setForeground(Color.BLUE);
		btnMenu.setBounds(879, 610, 81, 31);
		btnMenu.setBackground(Color.WHITE);
		contentPane.add(btnMenu);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(30, 550, 824, 91);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(Color.BLUE);
		btnSave.setBounds(879, 580, 81, 31);
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
		lblTotal.setBounds(541, 487, 191, 31);
		contentPane.add(lblTotal);
		
		JLabel lblFundamentalCost = new JLabel("Fundamental cost: $");
		lblFundamentalCost.setForeground(Color.BLUE);
		lblFundamentalCost.setFont(new Font("新細明體", Font.BOLD, 15));
		lblFundamentalCost.setBounds(122, 111, 191, 31);
		contentPane.add(lblFundamentalCost);
		
		JLabel lblFeePerPart = new JLabel("Fee per part: ");
		lblFeePerPart.setForeground(Color.BLUE);
		lblFeePerPart.setFont(new Font("新細明體", Font.BOLD, 15));
		lblFeePerPart.setBounds(122, 137, 191, 31);
		contentPane.add(lblFeePerPart);
		
		JLabel lblNumberOfParts = new JLabel("Number of part(s): ");
		lblNumberOfParts.setForeground(Color.BLUE);
		lblNumberOfParts.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNumberOfParts.setBounds(122, 161, 191, 31);
		contentPane.add(lblNumberOfParts);
		
		JLabel lblSubtotal = new JLabel("Subtotal: $");
		lblSubtotal.setForeground(Color.BLUE);
		lblSubtotal.setFont(new Font("新細明體", Font.BOLD, 15));
		lblSubtotal.setBounds(541, 462, 191, 31);
		contentPane.add(lblSubtotal);
		
		JLabel lblBodyParts = new JLabel("Entering new body part");
		lblBodyParts.setForeground(Color.BLUE);
		lblBodyParts.setFont(new Font("新細明體", Font.BOLD, 15));
		lblBodyParts.setBounds(122, 228, 191, 31);
		contentPane.add(lblBodyParts);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(0, 191, 255));
		rdbtnNewRadioButton.setBounds(230, 198, 43, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setBackground(new Color(0, 191, 255));
		rdbtnNo.setBounds(275, 198, 43, 23);
		contentPane.add(rdbtnNo);
		
		JLabel lblActivation = new JLabel("Confirmation:");
		lblActivation.setForeground(Color.BLUE);
		lblActivation.setFont(new Font("新細明體", Font.BOLD, 15));
		lblActivation.setBounds(122, 190, 172, 39);
		contentPane.add(lblActivation);
		
		JList list_1 = new JList();
		list_1.setBounds(757, 357, 1, 1);
		contentPane.add(list_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(121, 254, 251, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(122, 296, 95, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setEnabled(false);
		btnClear.setBounds(230, 296, 95, 23);
		contentPane.add(btnClear);
		
		JLabel lblclickFoModifying = new JLabel("(Click for modifying)");
		lblclickFoModifying.setForeground(Color.BLUE);
		lblclickFoModifying.setFont(new Font("Dialog", Font.BOLD, 10));
		lblclickFoModifying.setBounds(721, 464, 141, 31);
		contentPane.add(lblclickFoModifying);
		
		JLabel lblListOfEntered = new JLabel("List of entered body part(s):");
		lblListOfEntered.setForeground(Color.BLUE);
		lblListOfEntered.setFont(new Font("新細明體", Font.BOLD, 15));
		lblListOfEntered.setBounds(541, 111, 251, 31);
		contentPane.add(lblListOfEntered);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(Color.ORANGE);
		textPane.setBounds(113, 229, 269, 97);
		contentPane.add(textPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(541, 137, 263, 328);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "p", "i"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblModifingExistingBody = new JLabel("Modifying existing body part");
		lblModifingExistingBody.setForeground(Color.BLUE);
		lblModifingExistingBody.setFont(new Font("Dialog", Font.BOLD, 15));
		lblModifingExistingBody.setBounds(122, 358, 235, 31);
		contentPane.add(lblModifingExistingBody);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(121, 385, 251, 31);
		contentPane.add(textField_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(122, 424, 95, 23);
		contentPane.add(btnUpdate);
		
		JButton button_1 = new JButton("Clear");
		button_1.setEnabled(false);
		button_1.setBounds(230, 424, 95, 23);
		contentPane.add(button_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.ORANGE);
		textPane_1.setBounds(113, 357, 269, 97);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBackground(Color.ORANGE);
		textPane_2.setBounds(523, 108, 302, 410);
		contentPane.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setBackground(Color.ORANGE);
		textPane_3.setBounds(20, 527, 842, 124);
		contentPane.add(textPane_3);
	}
}
