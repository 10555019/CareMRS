import java.util.LinkedList;

public class Doctor extends Staff{
	private int room; // which room the doctor is using
	private LinkedList<DBooking> booking = new LinkedList<DBooking>(); //timetable for doctor
	
	//constructor - to create doctor object
	public Doctor(String name, String userName, String password, int room){
		this.name=name;
		this.userName=userName;
		this.password=password;
		this.room = room;
	}
	
	public static int doctorSearch(Db db, String Username){
		int i = 0;
		while (db.getDoctor(i) != null){
			if (Username.equals(db.getDoctor(i).userName))
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
	
	public LinkedList<DBooking> getBooking() {
		return booking;
	}

	public void setBooking(LinkedList<DBooking> booking) {
		this.booking = booking;
	}
}
