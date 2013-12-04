import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class LoginAccount implements Serializable{
	private LinkedList<Doctor> doctor = new LinkedList<Doctor>();
	private LinkedList<Admin> admin = new LinkedList<Admin>();
	
	private String filePath = "dat.sav";
	
	public void addDoctor(Doctor doctor){
		this.doctor.add(doctor);
	}
	
	public void addAdmin(Admin admin){
		this.admin.add(admin);
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
	
	public void deleteDoctor(int index){
		doctor.remove(index);
		JOptionPane.showMessageDialog(null, "Doctor is deleted","Delete", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void deleteAdmin(int index){
		if (getAdminSize()==1)
			JOptionPane.showMessageDialog(null, "There should be at least one Admin user, user is not deleted","Delete", JOptionPane.ERROR_MESSAGE);
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
			outObjectStream.close();
		} catch (IOException e){
			System.out.println("outFile IOException");
		}
	}
}
