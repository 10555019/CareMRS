import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Patient implements Serializable{
	private String name;
	private String HKID;
	private String telephone;
	private char gender;
	private GregorianCalendar dob = new GregorianCalendar();
	private LinkedList<TreatmentRec> record = new LinkedList<TreatmentRec>(); //store the treatment records
	private Calendar current ;
	//constructor - to create patient object
	public Patient(String name, String HKID, String telephone, char gender, String date){
		this.name = name;
		this.HKID = HKID;
		this.telephone = telephone;
		this.gender = gender;
		setDob(date);
		current = Calendar.getInstance();
	}

	public static int patientSearch(Db db, String inputHKID) {	
		int min=0;
		int max=db.getPatientSize() - 1;
		int mid;
		while(min <= max)
		{
			mid = (int) ((min+max)/2);
			if (inputHKID.charAt(0) == db.getPatient(mid).HKID.charAt(0))
			{
				if (Integer.parseInt(inputHKID.substring(1,7)) == Integer.parseInt(db.getPatient(mid).HKID.substring(1,7)))
				{
					if (inputHKID.charAt(8) == db.getPatient(mid).HKID.charAt(8))
						return mid;
					else if ((inputHKID.charAt(8) < db.getPatient(mid).HKID.charAt(8)))
						max = mid - 1;
					else
						min = mid + 1;
				}
				else if (Integer.parseInt(inputHKID.substring(1,7)) < Integer.parseInt(db.getPatient(mid).HKID.substring(1,7)))
					max = mid - 1;
				else 
					min = mid + 1;
			}	
			else if (inputHKID.charAt(0) < db.getPatient(mid).HKID.charAt(0))      
				max = mid - 1;
			else
				min = mid + 1;
		}
		return -1;                                                   //Not found
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

	public void setDob(String date) {
		int day, month, year;
		day = Integer.parseInt(date.substring(0,2));
		month = Integer.parseInt(date.substring(3,5));
		year = Integer.parseInt(date.substring(6,10));
		dob.set(year, month-1, day);
	}

	public LinkedList<TreatmentRec> getRecord() {
		return record;
	}

	public void setRecord(LinkedList<TreatmentRec> record) {
		this.record = record;
	}
	public void book(){
		
		/*
		
		
		
		
		Booking booking = new Booking()
		
		
		*/
		
		
		
		
		int cyear = current.get(Calendar.YEAR);
		int diff1 = cyear-dob.get(1);
		int cmonth = current.get(Calendar.MONTH);
		int diff = cmonth - dob.get(2);
		if(diff<0){
			diff1++;
		}
		else{
			diff1--;
		}
		if(diff1>50){
			int book = 2;
		}
		else{
			int book = 1;
		}
	}
}
