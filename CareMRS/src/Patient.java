import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Patient {
	private String name;
	private String HKID;
	private String telephone;
	private char gender;
	private Calendar dob = new GregorianCalendar();
	private LinkedList<PBooking> booking = new LinkedList<PBooking>(); //store the booking records
	private LinkedList<TreatmentRec> record = new LinkedList<TreatmentRec>(); //store the treatment records
	
	//constructor - to create patient object
	public Patient(String name, String HKID, String telephone, char gender, Calendar dob){
		this.name.equals(name);
		this.HKID.equals(HKID);
		this.telephone.equals(telephone);
		this.gender = gender;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHKID() {
		return HKID;
	}

	public void setHKID(String hKID) {
		HKID = hKID;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Calendar getDob() {
		return dob;
	}
	
	public String getDob_S(){
		return Integer.toString(dob.get(5)) + "/" + Integer.toString(dob.get(2)+1) + "/" + Integer.toString(dob.get(1));
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public LinkedList<PBooking> getBooking() {
		return booking;
	}

	public void setBooking(LinkedList<PBooking> booking) {
		this.booking = booking;
	}

	public LinkedList<TreatmentRec> getRecord() {
		return record;
	}

	public void setRecord(LinkedList<TreatmentRec> record) {
		this.record = record;
	}
	
}
