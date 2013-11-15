import java.util.Date;


public class Patient {
	private String name;
	private String HKID;
	private String telephone;
	private char gender;
	private Date dob;
	private PBooking booking; //store the booking records
	private TreatmentRec record; //store the treatment records
	
	//constructor - to create patient object
	public Patient(String name, String HKID, String telephone, char gender, Date dob){
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public PBooking getBooking() {
		return booking;
	}

	public void setBooking(PBooking booking) {
		this.booking = booking;
	}

	public TreatmentRec getRecord() {
		return record;
	}

	public void setRecord(TreatmentRec record) {
		this.record = record;
	}
	
	
}
