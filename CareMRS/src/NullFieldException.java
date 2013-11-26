import javax.swing.JOptionPane;


public class NullFieldException extends Exception {
	public void error(){
		JOptionPane.showMessageDialog(null, "HKID field should not be blank.","Save", JOptionPane.ERROR_MESSAGE);
	}
}
