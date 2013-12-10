import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;


public class Booking implements Serializable{
	private GregorianCalendar date;
	private static String HKID;
	private String userName; //DoctorID
	
	public Booking(String HKID, String userName, GregorianCalendar date){
		this.HKID = HKID;
		this.userName = userName;
		this.date = date;
	}
	public  String getPatientID(){
		return HKID;
	}
	public String getDoctorID(){
		return userName;
	}
	public String getBookingDate(){
		String day, month, year;
		day = Integer.toString(date.get(5));
		month = Integer.toString(date.get(2))+1;
		year = Integer.toString(date.get(1));
		return (day+"/"+month+"/"+year);
	}
	
	public String getBookingTime(){
		String hour, min;
		hour = Integer.toString(date.get(11));
		min = Integer.toString(date.get(12));
		return (hour+":"+min);
	}
	
}
