import javax.swing.JOptionPane;


public class NullFieldException extends Exception {
	private int i;
	public NullFieldException(int i) {
		this.i=i;
	}

	public void error(){
		switch(i){
		case 1:
			JOptionPane.showMessageDialog(null, "HKID field should not be blank.","Blank Field", JOptionPane.ERROR_MESSAGE);
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Field should not be blank.","Blank Field", JOptionPane.ERROR_MESSAGE);
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Please select a time slot.","Blank Field", JOptionPane.ERROR_MESSAGE);
		}
	}
}
