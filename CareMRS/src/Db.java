import java.io.*;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class Db implements Serializable{
	
	private LinkedList<Patient> patient = new LinkedList<Patient>();
	private LinkedList<Doctor> doctor = new LinkedList<Doctor>();
	private LinkedList<Admin> admin = new LinkedList<Admin>();
	private Clinic clinic = new Clinic();
	private String filePath = "db.sav";
	
	public Db(){
		
	}
	
	public void addPatient(Patient patient){
		this.patient.add(patient);
	}
	
	public void addDoctor(Doctor doctor){
		this.doctor.add(doctor);
	}
	
	public void addAdmin(Admin admin){
		this.admin.add(admin);
	}
	
	public Patient getPatient(int index){
		return patient.get(index);
	}
	
	public int getPatientSize(){
		return patient.size();
	}
	
	public int getAdminSize(){
		return admin.size();
	}
	
	public Doctor getDoctor(int index){
		try{
			return doctor.get(index);
		} catch (IndexOutOfBoundsException e){
		}
		return null;
	}
	
	public Admin getAdmin(int index){
		try{
			return admin.get(index);
		} catch (IndexOutOfBoundsException e){
		}
		return null;
	}
	
	public void deletePatient(int index){
		patient.remove(index);
		JOptionPane.showMessageDialog(null, "Patient is deleted","Delete", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void deleteDoctor(int index){
		doctor.remove(index);
		JOptionPane.showMessageDialog(null, "Doctor is deleted","Delete", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void deleteAdmin(int index){
		if (getAdminSize()==1)
			JOptionPane.showMessageDialog(null, "There should be at least one Admin user, user is not deleted","Delete", JOptionPane.ERROR_MESSAGE);
	}
	
	public void setPath(){
		
	}
	
	public Db load() throws IOException, ClassNotFoundException{
		File inFile = new File(filePath);
		FileInputStream inFileStream = new FileInputStream(inFile);
		ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);
		
		Db tmpDb = (Db) inObjectStream.readObject();
		inObjectStream.close();
		return tmpDb;
	}
	
	public void save() throws IOException{
		File outFile = new File(filePath);
		FileOutputStream outFileStream = new FileOutputStream(outFile);
		ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);
		
		outObjectStream.writeObject(this);
		outObjectStream.close();
	}
	
}