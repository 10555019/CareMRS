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
				addPatient(new Patient("Chan", "A000001(1)", "1234 5678", 'M', "01/01/1000"));
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
				clinic.setOpenHr(0,0,true);
				clinic.setOpenHr(0,1,true);
				clinic.setOpenHr(1,0,true);
				clinic.setOpenHr(1,1,true);
				clinic.setOpenHr(2,0,true);
				clinic.setOpenHr(2,1,true);
				clinic.setOpenHr(3,0,true);
				clinic.setOpenHr(3,1,true);
				clinic.setOpenHr(4,0,true);
				clinic.setOpenHr(4,1,true);
				clinic.setOpenHr(5,0,true);
				clinic.setOpenHr(5,1,false);
				clinic.setOpenHr(6,0,false);
				clinic.setOpenHr(6,1,false);
				clinic.setSession(0, "10:00");
				clinic.setSession(1, "13:00");
				clinic.setSession(2, "15:00");
				clinic.setSession(3, "20:00");
				clinic.setNonPH(0, "12:00");
				clinic.setNonPH(1, "13:00");
				clinic.setNonPH(2, "15:00");
				clinic.setNonPH(3, "16:00");
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
		delete();
		for(int i=0; i<booking.size();i++){
			if (ID.equals(booking.get(i).getPatientID())){
				temp.add(i);
			}
		}
	}
	
	public void searchinglistd(String ID){
		delete();
		for(int i=0; i<booking.size();i++){
			if (ID.equals(booking.get(i).getDoctorID())){
				temp.add(i);
			}
		}
	}
	
	public void showBookingDoc(String ID){
		int i=0;
		searchinglist(ID);
		while (i<temp.size()){
			String PatientID = booking.get(temp.get(i)).getPatientID();
			String date = booking.get(temp.get(i)).getBookingDate();
			String time = booking.get(temp.get(i)).getBookingTime();
			i++;
		}
	}
	
	public void showBookingPat(String ID){//print out list
		int i =0;
		searchinglistd(ID);
		while(i<temp.size()){
			String DoctorID = booking.get(temp.get(i)).getDoctorID();
			String date = booking.get(temp.get(i)).getBookingDate();
			String time = booking.get(temp.get(i)).getBookingTime();
			i++;
		}
	}
	
	public void cancelBooking(int i){
		booking.remove(i);
	}
	
	public void createbooking(String ID, String DoctorID, GregorianCalendar date){
		//add list
		Booking booking = new Booking(ID, DoctorID, date);
		addBooking(booking);
	}

	public boolean isoverlap(Booking booking){
		boolean flag = false;
		for (int i=0; i<this.booking.size();i++){
			String time = this.booking.get(i).getBookingTime();
			String date = this.booking.get(i).getBookingDate();
			String doctorID = this.booking.get(i).getDoctorID();
			if((booking.getDoctorID().equals(doctorID)&&(booking.getBookingTime().equals(time))&&(booking.getBookingDate().equals(date))))
				flag = true;
		}
		return flag;
	}

	public void delete(){
		temp.removeAll(temp);
	}
}
