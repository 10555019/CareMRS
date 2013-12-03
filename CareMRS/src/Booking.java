import java.util.Date;


public class Booking {
	private Date time;
	private int patientID;
	private Date date= new Date();
	public Booking(int patientID, Date date){
		this.patientID = patientID;
		this.date = date;
	}
	
}
