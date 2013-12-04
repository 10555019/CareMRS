import java.io.Serializable;

public class Admin extends Staff implements Serializable{
	
	public Admin(String name, String userName, String password){
		this.name = name;
		this.userName = userName;
		this.password = password;
	}
	
	public static int adminSearch(Db db, LoginAccount loginAccount, String Username){
		int i = 0;
		while (loginAccount.getAdmin(i) != null)
		{
			if (Username.equals(loginAccount.getAdmin(i).userName))
				return i;
			i++;
		}
		return -1;
	}
	
	private void setOpenHour(){
		int a=0,b=0;
		boolean c=true;
		Clinic.setOpenHour(a,b,c);
		
	}
	
	private void setTypeOfTreatment(){
		int a=0;
		String b="123";
		Clinic.setTypeOfTreatment(a,b);
	}
	
	private void setSpecialArrangement(){
		int a=0;
		String b="123";
		Clinic.setSpecialArrangement(a,b);
		
	}

}
