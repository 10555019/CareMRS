import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class Db implements Serializable{
	
	private LinkedList<Patient> patient = new LinkedList<Patient>();
	private LinkedList<Booking> booking = new LinkedList<Booking>();
	private ArrayList<Integer> temp = new ArrayList<Integer>(); 
	//storing the location of list
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
	
	public Patient getPatient(int index){
		try{
			return patient.get(index);
		} catch (IndexOutOfBoundsException e){
		}
		return null;
	}
	
	public int getPatientSize(){
		return patient.size();
	}
	

	
	public Clinic getClinic(){
		return clinic;
	}
	
	public void deletePatient(int index){
		patient.remove(index);
		JOptionPane.showMessageDialog(null, "Patient is deleted","Delete", JOptionPane.PLAIN_MESSAGE);
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
				inObjectStream.close();
				return tmpDb;
			}else{
				//first time use
				
				//temp
				addPatient(new Patient("Chan", "A000001(1)", "1234 5678", 'M', "01/01/2013"));
				//temp
				
				TreatmentMeta treatmentMeta1 = new TreatmentMeta("Herbal",250,false);
				TreatmentMeta treatmentMeta2 = new TreatmentMeta("Acupuncture",350,true);
				TreatmentMeta treatmentMeta3 = new TreatmentMeta("Cupping",300,true);
				TreatmentMeta treatmentMeta4 = new TreatmentMeta("Bone-setting",500,true);
				clinic.addTreatmentMeta(treatmentMeta1);
				clinic.addTreatmentMeta(treatmentMeta2);
				clinic.addTreatmentMeta(treatmentMeta3);
				clinic.addTreatmentMeta(treatmentMeta4);
				clinic.setDiscount(0,(float) 0.8);
				clinic.setDiscount(1,(float) 0.5);
				clinic.setDiscount(2,(float) 0.95);
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

	public void save(){
		try{
			File outFile = new File(filePath);
			FileOutputStream outFileStream = new FileOutputStream(outFile);
			ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);
			outObjectStream.writeObject(this);
			outObjectStream.close();
		} catch (IOException e){
			System.out.println("outFile IOException");
		}
	}
	public void searchinglist(String ID){
		for(int i=0; i<booking.size();i++){
			if (ID.equals(booking.get(i).getPatientID())){
				adda(temp.size(),i);
			}
		}
	}
	public void adda(int size, int i) {
		// TODO Auto-generated method stub
	}
	public void showBookDoc(){
		int i=0;
		while (i<temp.size()){
			String PatientID = booking.get(i).getPatientID();
			String date = booking.get(i).getBookingTime();
		}
	}
	public void showBooking(String ID){//print out list
		int i =0;
		while(i<temp.size()){
			String DoctorID = booking.get(i).getDoctorID();
			String date = booking.get(i).getBookingTime();
			i++;
		}
	}
	public void cancelBooking(int i){
		booking.remove(i);
	}
	public void createbooking(String ID, String DoctorID, GregorianCalendar date){
		//add list
		booking.addBooking(ID, DoctorID, date);
	}
	public void checkoverlap(){
		for (int i=0; i<booking.size();i++){
			String date = booking.get(i).getBookingTime();//search and check
			String Doctor = booking.get(i).getDoctorID();
			for(int j=0; j<booking.size(); j++){
				String date1=booking.get(i).getBookingTime();
				String Doctor1 = booking
				if(date.equals(date1)){
				}
			}
		}
	}
	public void delete(){
		temp.removeAll(temp);
	}
}
