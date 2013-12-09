import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;


public class Booking implements Serializable{
	private GregorianCalendar date = new GregorianCanlendar();
	private String HKID;
	private String userName; //DoctorID
	
	public Booking(String HKID, String userName, GregorianCalendar date){
		this.HKID = HKID;
		this.userName = userName;
		this.date = date;
	}
	public String getpatientID(){
		return HKID;
	}
	public String getDoctorID(){
		return userName;
	}
	public String getBookingTime(){
		String day, month, year, hour, min;
		day = Integer.toString(date.get(5));
		month = Integer.toString(date.get(2));
		year = Integer.toString(date.get(1));
		hour = Integer.toString(date.get(11));
		min = Integer.toString(date.get(12));
	}
}
