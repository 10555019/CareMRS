import java.io.Serializable;

public class Admin extends Staff implements Serializable{
	
	public Admin(String name, String userName, String password){
		this.name = name;
		this.userName = userName;
		this.password = password;
	}
	
	public static int adminSearch(Db db, LogAc logAc, String Username){
		int i = 0;
		while (logAc.getAdmin(i) != null)
		{
			if (Username.equals(logAc.getAdmin(i).userName))
				return i;
			i++;
		}
		return -1;
	}
	
	private void setOpenHour(){
		int a=0,b=0;
		boolean c=true;
		//Clinic.setOpenHour(a,b,c);
		
	}
	
	private void setTypeOfTreatment(){
		int a=0;
		String b="123";
		//Clinic.setTypeOfTreatment(a,b);
	}
	
	private void setSpecialArrangement(){
		int a=0;
		String b="123";
		//Clinic.setSpecialArrangement(a,b);
		
	}

}
