public class Admin extends Staff{
	
	public Admin(String name, String userName, String password){
		this.name = name;
		this.userName = userName;
		this.password = password;
	}
	
	public static int adminSearch(Db db,String Username){
		int i = 0;
		while (db.getAdmin(i) != null)
		{
			if (Username.equals(db.getAdmin(i).userName))
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

}
