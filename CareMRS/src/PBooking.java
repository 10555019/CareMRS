import java.util.Date;


public class PBooking {
	private Date time;
	private int patientID;
	private Date date= new Date();
	public PBooking(int patientID, Date date){
		this.patientID = patientID;
		this.date = date;
	}
	
}
