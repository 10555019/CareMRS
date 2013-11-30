import java.util.Arrays;
import java.util.LinkedList;

public class Doctor extends Staff{
	private String name; //doctor's FULL name
	private int room; // which room the doctor is using
	private LinkedList<DBooking> booking = new LinkedList<DBooking>(); //timetable for doctor
	
	//constructor - to create doctor object
	public Doctor(String name, String userName, String password, int room){
		this.name=name;
		this.userName=userName;
		this.password=password;
		this.room = room;
	}
	
	public static int doctorSearch(String Username){
		int i = 0;
		while (Care.db.getDoctor(i) != null)
		{
			if (Username.equals(Care.db.getDoctor(i).userName))
				return i;
			i++;
		}
		return -1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
