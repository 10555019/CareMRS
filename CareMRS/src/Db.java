import java.io.*;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class Db implements Serializable{
	
	private LinkedList<Patient> patient = new LinkedList<Patient>();
	private LinkedList<Doctor> doctor = new LinkedList<Doctor>();
	private LinkedList<Admin> admin = new LinkedList<Admin>();
	private LinkedList<Booking> booking = new LinkedList<Booking>();
	private Clinic clinic = new Clinic();
	private String filePath = "db.sav";
	
	public void addBooking(Booking booking){
		this.booking.add(booking);
	}
	
	public void addPatient(Patient patient){
		int index = 0;
		while (index < getPatientSize()){
			if (patient.getHKID().compareTo(this.patient.get(index).getHKID())>0)
				index++;
			else
				break;
		}
		this.patient.add(index, patient);
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
	
	public Clinic getClinic(){
		return clinic;
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

	public Db load(Db db){
		try{
			File inFile = new File(filePath);

			if (inFile.exists()){
				FileInputStream inFileStream = new FileInputStream(inFile);
				ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);
				Db tmpDb = (Db) inObjectStream.readObject();
				
				System.out.println("Load: " + inFile.length());
				
				System.out.println("Load: " + tmpDb.getAdmin(0).getUserName());
				
				inObjectStream.close();
				return tmpDb;
			}else{
				return db;
			}
		} catch (IOException e){
			System.out.println("inFile IOException");
			return db;
		} catch (ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
			return db;
		}
	}

	public void save(Db db){
		try{
			File outFile = new File(filePath);
			FileOutputStream outFileStream = new FileOutputStream(outFile);
			ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);
			outObjectStream.writeObject(db);
			
			System.out.println("Save: " + outFile.length());
			
			System.out.println("Save: " + db.getAdmin(0).getUserName());
			
			outObjectStream.close();
		} catch (IOException e){
			System.out.println("outFile IOException");
		}
	}

}
