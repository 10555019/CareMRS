import java.util.LinkedList;


public class Db {
	
	private static LinkedList<Patient> l_patient = new LinkedList<Patient>();
	private static LinkedList<Doctor> l_doctor = new LinkedList<Doctor>();
	private static Clinic clinic = new Clinic();
	
	public Db(){
		
	}
	
	public static void addPatient(Patient patient){
		l_patient.add(patient);
	}
	
	public static void addDoctor(Doctor doctor){
		l_doctor.add(doctor);
	}
	
	public static Patient getPatient(int index){
		return l_patient.get(index);
	}
	
	public static Doctor getDoctor(int index){
		return l_doctor.get(index);
	}
	
}
