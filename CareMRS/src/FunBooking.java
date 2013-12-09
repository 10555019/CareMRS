import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class FunBooking implements Serializable {
	private LinkedList<Booking> booking = new LinkedList<booking>();
	public void CancelBooking(String ID, GregorianCalendar date){
		for(int i=0; i<booking.size();i++){
		//remove
	}
	public void ShowBooking(){
		
	}
	public void Createbooking(String ID, GregorianCalendar date){
		//add list
	}
	public void Checkoverlap(){
		for (int i=0; i<booking.size();i++)
	}

	}
}
