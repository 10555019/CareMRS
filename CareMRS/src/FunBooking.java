import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class FunBooking implements Serializable {
	private LinkedList<Booking> booking = new LinkedList<Booking>();
	private String DoctorID;
	private String PID;
	//private 
	public FunBooking(String DoctorID, String PID){
		this.DoctorID = DoctorID;
		this.PID = PID;
		
	}
	public void cancelBooking(String ID, GregorianCalendar date){
		for(int i=0; i<booking.size();i++){//remove
		
		}
	}
	public void showBooking(){//print out list
		
	}
	public void createbooking(String ID, GregorianCalendar date){
		//add list
		
	}
	public void checkoverlap(){
		for (int i=0; i<booking.size();i++){//search and check

		}
	}
}
