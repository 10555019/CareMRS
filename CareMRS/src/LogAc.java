import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class LogAc implements Serializable{
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
	
	public int getDoctorSize(){
		return doctor.size();
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
		else{
			admin.remove(index);
			JOptionPane.showMessageDialog(null, "Admin is deleted","Delete", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public LogAc load(LogAc logAc){
		try{
			File inFile = new File(filePath);

			if (inFile.exists()){
				FileInputStream inFileStream = new FileInputStream(inFile);
				ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);
				LogAc tmplogin = (LogAc) inObjectStream.readObject();
				inObjectStream.close();
				return tmplogin;
			}else{
				//first time use
				Admin admin = new Admin("Superusr","user","user");
				Doctor doctor = new Doctor("Default Doctor","doctor","doctor",1);
				logAc.addAdmin(admin);
				logAc.addDoctor(doctor);
				return logAc;
			}
		} catch (IOException e){
			System.out.println("inFile IOException");
			return logAc;
		} catch (ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
			return logAc;
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
}
