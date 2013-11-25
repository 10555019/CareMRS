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
	private int index; //By John  For searching the object of patient linklist
	
	//constructor - to create patient object
	public Patient(String name, String HKID, String telephone, char gender, Calendar dob){
		this.name.equals(name);
		this.HKID.equals(HKID);
		this.telephone.equals(telephone);
		this.gender = gender;
		this.dob = dob;
	}
	
	public static void patientSearch(String inputHKID,List<Patient> patientlist) {	//By John Assume that there is a linklist of patients
		int i = -1;
		do
		{
			i++;
			if (inputHKID.equals(patientlist.get(i).HKID))
			{
				System.out.println("The patient has been found.");
				System.out.println("-----------------------------------------------------");
				System.out.println("Name :" + patientlist.get(i).name);
				System.out.println("HKID :" + patientlist.get(i).HKID);
				System.out.println("Telephone :" + patientlist.get(i).telephone);
				System.out.println("Gender :" + patientlist.get(i).gender);
				System.out.println("Date of birth :" + patientlist.get(i).dob);
				System.out.println("-----------------------------------------------------");
			}
			else
				System.out.println("The patient has not been found.");
		} while (!(inputHKID.equals(patientlist.get(i).HKID))&&(i != patientlist.size()-1));	
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
