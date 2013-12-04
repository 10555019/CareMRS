import java.io.Serializable;
import java.util.LinkedList;

public class Doctor extends Staff implements Serializable{
	private int room; // which room the doctor is using
	
	//constructor - to create doctor object
	public Doctor(String name, String userName, String password, int room){
		this.name=name;
		this.userName=userName;
		this.password=password;
		this.room = room;
	}
	
	public static int doctorSearch(Db db, LoginAccount loginAccount, String Username){
		int i = 0;
		while (loginAccount.getDoctor(i) != null){
			if (Username.equals(loginAccount.getDoctor(i).userName))
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
}

