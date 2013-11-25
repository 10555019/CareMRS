import java.util.LinkedList;


public class Db {
	
	private LinkedList<Patient> patient = new LinkedList<Patient>();
	private LinkedList<Doctor> doctor = new LinkedList<Doctor>();
	private Clinic clinic = new Clinic();
	
	public Db(){
		
	}
	
	public void addPatient(Patient patient){
		this.patient.add(patient);
	}
	
	public void addDoctor(Doctor doctor){
		this.doctor.add(doctor);
	}
	
}
