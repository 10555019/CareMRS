import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;


public class Booking implements Serializable{
	private GregorianCalendar date;
	private String HKID;
	private String userName; //DoctorID
	
	public Booking(String HKID, String userName, GregorianCalendar date){
		this.HKID = HKID;
		this.userName = userName;
		this.date = date;
	}
	
}
