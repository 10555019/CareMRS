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
		if (day.length()==1)
			day = "0" + day;
		month = Integer.toString(date.get(2))+1;
		if (month.length()==1)
			month = "0" + month;
		year = Integer.toString(date.get(1));
		if (year.length()==1)
			year = "0" + year;
		return (day+"/"+month+"/"+year);
	}
	
	public String getBookingTime(){
		String hour, min;
		hour = Integer.toString(date.get(11));
		if (hour.length()==1)
			hour = "0" + hour;
		min = Integer.toString(date.get(12));
		if (min.length()==1)
			min = "0" + min;
		return (hour+":"+min);
	}
	
}
