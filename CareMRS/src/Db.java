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
	
	public Patient getPatient(int index){
		return patient.get(index);
	}
	
	public int getPatientSize(){
		return patient.size();
	}
	
	public Doctor getDoctor(int index){
		try{
			return doctor.get(index);
		} catch (IndexOutOfBoundsException e){
		}
		return null;
	}
	
}
