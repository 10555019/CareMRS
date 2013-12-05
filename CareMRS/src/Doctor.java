import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JComboBox;

public class Doctor extends Staff implements Serializable{
	private int room; // which room the doctor is using
	
	//constructor - to create doctor object
	public Doctor(String name, String userName, String password, int room){
		this.name=name;
		this.userName=userName;
		this.password=password;
		this.room = room;
	}
	
	public static int doctorSearch(Db db, LogAc logAc, String Username){
		int i = 0;
		while (logAc.getDoctor(i) != null){
			if (Username.equals(logAc.getDoctor(i).userName))
				return i;
			i++;
		}
		return -1;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}
	
	public static void addCombo(LogAc logAc, JComboBox<String> comboBox){
		int index = 0;
		while (logAc.getDoctor(index)!=null){
			System.out.println("+1: " + index);
			comboBox.addItem(logAc.getDoctor(index).getName());
			index++;
		}
	}
}

