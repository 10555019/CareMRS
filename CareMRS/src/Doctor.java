import java.util.Arrays;
import java.util.LinkedList;


public class Doctor {
	private String name; //doctor's FULL name
	private String userName; //used to login to the system, so needed to be UNIQUE
	private String password; //used to login to the system, can be same for different user
	private int room; // which room the doctor is using
	private LinkedList<DBooking> booking = new LinkedList<DBooking>(); //timetable for doctor
	
	//constructor - to create doctor object
	public Doctor(String name, String userName, String password, int room){
		this.name=name;
		this.userName=userName;
		this.password=password;
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}
	
	public LinkedList<DBooking> getBooking() {
		return booking;
	}

	public void setBooking(LinkedList<DBooking> booking) {
		this.booking = booking;
	}

	public static boolean checkLogin(String userName, char[] password){
		int i = Care.doctor.size();
		int k=0; //looping variable
		
		do{
			if (Care.doctor.get(k).getUserName().equals(userName)){
				if (Arrays.equals(Care.doctor.get(k).getPassword().toCharArray(),password))
					return true;
			}
			k++;
		} while (k<i);
		return false;
	}
	
}
