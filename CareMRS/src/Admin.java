public class Admin extends Staff{
	
	public Admin(String name, String userName, String password){
		this.name = name;
		this.userName = userName;
		this.password = password;
	}
	
	public static int adminSearch(String Username){
		int i = 0;
		while (Care.db.getAdmin(i) != null)
		{
			if (Username.equals(Care.db.getAdmin(i).userName))
				return i;
			i++;
		}
		return -1;
	}

}
